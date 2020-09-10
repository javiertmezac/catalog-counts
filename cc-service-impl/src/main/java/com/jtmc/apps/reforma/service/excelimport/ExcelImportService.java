package com.jtmc.apps.reforma.service.excelimport;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.mybatis.CatalogCountRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import static java.lang.String.format;

public class ExcelImportService {

    @Inject
    private CatalogCountRepository repository;


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
                throw new ExcelImportServiceSheetNotValidException(format("Excel '%s' on TabSheet '%s' didn't pass validations: ", fileStorageKey, tabSheetName));
            }

            XSSFSheet sheet = wb.getSheet(tabSheetName);

            Iterator<Row> itr = sheet.iterator();
            int totalRowIndex = sheet.getTables().get(0).getEndRowIndex();

            while (itr.hasNext()) {
                Row row = itr.next();
                if (skipFirstTwoRows(row) || row.getRowNum() == totalRowIndex) {
                    continue;
                }

                CatalogCount catalogCount = new CatalogCount();
                catalogCount.setRegistrationDate(row.getCell(1).getDateCellValue());

                //todo: map internally the catalog value with an enum  ( id from db )
                catalogCount.setCatalogCountEnumId(1);
                catalogCount.setDetails(row.getCell(3).getStringCellValue());

                if (catalogCount.isIncoming()) {
                    catalogCount.setAmount(row.getCell(4).getNumericCellValue());
                } else {
                    catalogCount.setAmount(row.getCell(5).getNumericCellValue());
                }
                catalogCount.setDeleted(false);

               repository.insert(catalogCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean skipFirstTwoRows(Row row) {
        int headersIndex = 1;
        int previousTotal = 2;

        return row.getRowNum() == headersIndex || row.getRowNum() == previousTotal;
    }
}
