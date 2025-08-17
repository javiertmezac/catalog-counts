package com.jtmc.apps.reforma.service.excelimport;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.BranchDetails;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.repository.BranchRepository;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelImportService {
    private final Logger logger = LoggerFactory.getLogger(ExcelImportService.class);

    @Inject
    private CatalogCountRepository repository;

    @Inject
    private CatalogCountEnumRepository ccEnumRepository;

    @Inject
    private BranchImpl branchImpl;

    private List<CatalogCountEnum> list = new ArrayList<>();

    private static final List<Path> ALLOWED_BASES = List.of(
            Paths.get("/Users/jtmc/cc-service"),
            Paths.get("/tmp/uploads")
    );

    private FileInputStream getExcelFile(String fileStorageKey) throws Exception {
        for (Path baseDir : ALLOWED_BASES) {
            Path resolvedPath = baseDir.resolve(fileStorageKey).normalize();

            if (resolvedPath.startsWith(baseDir) && Files.exists(resolvedPath)) {
                return new FileInputStream(resolvedPath.toFile());
            }
        }
        throw new FileNotFoundException("File not found or access denied: " + fileStorageKey);
    }

    public void execute(String fileStorageKey, String tabSheetName, CatalogCountExcelDefinition def) {

        try {

            StringBuilder catalogCountStringBuilder = new StringBuilder();
            XSSFWorkbook wb = new XSSFWorkbook(getExcelFile(fileStorageKey));

//            ExcelSheet excelSheet = new ExcelSheet(wb, tabSheetName);
//            if (!excelSheet.isValid()) {
//                throw new ExcelImportServiceSheetNotValidException(format("Excel '%s' on TabSheet '%s' didn't pass validations", fileStorageKey, tabSheetName));
//            }

            XSSFSheet sheet = wb.getSheet(tabSheetName);

            Iterator<Row> itr = sheet.iterator();
//            int totalRowIndex = sheet.getTables().get(0).getEndRowIndex();

            list = ccEnumRepository.selectAllCatalogCountEnum();
            BranchDetails branchDetails = branchImpl.selectOneBranch(def.account);

            /*
            todo:
              in the future keep track of the "row" that is written as a new record,
              if something goes wrong, process should be stopped and track of the
              process should be stored for reference  (return ExcelImportStatusResponse)
            */

            int secondsToAdd = 0;
            int minutesToAdd = 0;
            while (itr.hasNext()) {
                Row row = itr.next();
                if (skipFirstTwoRows(row) || row.getRowNum() < def.startRow) {
                    continue;
                }

                if(row.getRowNum() == def.endRow) {
                    break;
                }

                CatalogCount catalogCount = new CatalogCount();
                if (secondsToAdd == 60) {
                    secondsToAdd = 0;
                    minutesToAdd++;
                }

                ZonedDateTime zonedDateTime = Instant
                        .ofEpochMilli(row.getCell(def.columns.get("registration")).getDateCellValue().getTime())
                        .atZone(branchDetails.getZoneIdFromBranchTimeZone()).plusMinutes(minutesToAdd)
                        .plusSeconds(secondsToAdd++);

                catalogCount.setRegistration(zonedDateTime.toInstant());
//                catalogCount.setRegistration(zonedDateTime.toLocalDateTime());

                CatalogCountEnum ccEnum = new CatalogCountEnum();
                Cell catalogCountEnumId = row.getCell(def.columns.get("catalogCountEnum"));
                CellType cellType = catalogCountEnumId.getCellType();
                if (cellType.equals(CellType.STRING)) {
                    ccEnum = mapCatalogCountWithDB(catalogCountEnumId.getStringCellValue());
                } else if (cellType.equals(CellType.NUMERIC)) {
                    ccEnum = mapCatalogCountWithDB(String.valueOf(catalogCountEnumId.getNumericCellValue()));
                }
                catalogCount.setCatalogcountenumid(ccEnum.getId());

                Cell descriptionDetailsCell = null;
                if (def.columns.containsKey("descriptionDetails")) {
                    Integer descriptionDetails = def.columns.get("descriptionDetails");
                    descriptionDetailsCell = row.getCell(descriptionDetails);
                }
                Cell descriptionCell = row.getCell(def.columns.get("description"));
                String movementDetails =  descriptionDetailsCell == null ? "" : descriptionDetailsCell.getStringCellValue();
                String movementDescription = descriptionCell.getStringCellValue();
                catalogCount.setDetails(movementDetails.isEmpty() ? movementDescription : movementDetails);

                Boolean expensesIdentifier = true;
                if (ccEnum.getType() != expensesIdentifier) {
                    catalogCount.setAmount(row.getCell(def.columns.get("income")).getNumericCellValue());
                } else {
                    catalogCount.setAmount(row.getCell(def.columns.get("outcome")).getNumericCellValue());
                }
                catalogCount.setIsdeleted(false);
                catalogCount.setBranchid(def.account);

                if (def.commit) {
                    repository.insert(catalogCount);
                }
                catalogCountStringBuilder.append(createInsertStatement(catalogCount));
            }

            writeToFile(def.outputPath, catalogCountStringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcelImportException("Something went wrong during ExcelImport", e);
        }
    }

    private void writeToFile(String filePath, StringBuilder statements) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(statements.toString());
            System.out.println("File written successfully to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createInsertStatement(CatalogCount cc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
        return "insert into catalog_count(registration, catalogCountEnumId, amount, details, isDeleted, branchId) " +
                "values('%s', %d, %.2f, '%s', %b, %d);".formatted(formatter.format(cc.getRegistration()), cc.getCatalogcountenumid(),
                        cc.getAmount(), cc.getDetails(), cc.getIsdeleted(), cc.getBranchid()) + "\n";
    }

    private CatalogCountEnum mapCatalogCountWithDB(String catalogCountIdentifier) {
        return list.stream().filter(e -> e.getIdentifier().equals(catalogCountIdentifier)).findFirst().orElse(null);
    }

    private boolean skipFirstTwoRows(Row row) {
        int headersIndex = 0;
        int previousTotal = 1;

        return row.getRowNum() == headersIndex || row.getRowNum() == previousTotal;
    }

    public static class CatalogCountExcelDefinition {
        public Map<String, Integer> columns;
        public int account;
        public int startRow;
        public int endRow;
        public boolean commit;
        public String outputPath;
    }
}
