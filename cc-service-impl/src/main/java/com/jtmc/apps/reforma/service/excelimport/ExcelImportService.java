package com.jtmc.apps.reforma.service.excelimport;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.mybatis.CatalogCountEnumRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.String.format;

public class ExcelImportService {

    @Inject
    private CatalogCountRepository repository;

    @Inject
    private CatalogCountEnumRepository ccEnumRepository;

    private List<CatalogCountEnum> list = new ArrayList<>();


    //todo: get file name from storage service. Current local file: excel-import/example1.xlsx
private FileInputStream getExcelFile(String fileStorageKey) throws Exception {
        File file = new File(getClass().getClassLoader().getResource(fileStorageKey).getFile());
        return new FileInputStream(file);
    }

    public void execute(String fileStorageKey, String tabSheetName) {

        try {

            XSSFWorkbook wb = new XSSFWorkbook(getExcelFile(fileStorageKey));

            ExcelSheet excelSheet = new ExcelSheet(wb, tabSheetName);
            if (!excelSheet.isValid()) {
                throw new ExcelImportServiceSheetNotValidException(format("Excel '%s' on TabSheet '%s' didn't pass validations", fileStorageKey, tabSheetName));
            }

            XSSFSheet sheet = wb.getSheet(tabSheetName);

            Iterator<Row> itr = sheet.iterator();
            int totalRowIndex = sheet.getTables().get(0).getEndRowIndex();

            list = ccEnumRepository.getList();

            /*
            todo:
              in the future keep track of the "row" that is written as a new record,
              if something goes wrong, process should be stopped and track of the
              process should be stored for reference  (return ExcelImportStatusResponse)
            */

            while (itr.hasNext()) {
                Row row = itr.next();
                if (skipFirstTwoRows(row) || row.getRowNum() == totalRowIndex) {
                    continue;
                }

                CatalogCount catalogCount = new CatalogCount();
                catalogCount.setRegistrationDate(row.getCell(1).getDateCellValue());

                CatalogCountEnum ccEnum = mapCatalogCountWithDB(row.getCell(2).getStringCellValue());

                catalogCount.setCatalogCountEnumId(ccEnum.getId());
                catalogCount.setDetails(row.getCell(3).getStringCellValue());

                if (ccEnum.isType()) {
                    catalogCount.setAmount(row.getCell(4).getNumericCellValue());
                } else {
                    catalogCount.setAmount(row.getCell(5).getNumericCellValue());
                }
                catalogCount.setDeleted(false);

               repository.insert(catalogCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcelImportException("Something went wrong during ExcelImport", e);
        }
    }

    private CatalogCountEnum mapCatalogCountWithDB(String catalogCountIdentifier) {
        return list.stream().filter(e -> e.getIdentifier().equals(catalogCountIdentifier)).findFirst().orElse(null);
    }

    private boolean skipFirstTwoRows(Row row) {
        int headersIndex = 1;
        int previousTotal = 2;

        return row.getRowNum() == headersIndex || row.getRowNum() == previousTotal;
    }
}
