package com.jtmc.apps.reforma.service.excelimport;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelSheet {

    private XSSFWorkbook wb;
    private String tabSheetName;
    private XSSFSheet sheet;
    private XSSFTable xssfTable;

    public ExcelSheet(XSSFWorkbook wb, String tabName) {
       this.wb = wb;
       this.tabSheetName = tabName;
    }

    private boolean hasOnlyOneTable() {
        if (sheet.getTables().size() == 1) {
            xssfTable = sheet.getTables().get(0);
            return true;
        }
        return false;
    }

    private boolean verifyFileVersion() {
        return this.wb.getSpreadsheetVersion() == SpreadsheetVersion.EXCEL2007;
    }

    private boolean areColumnsInOrder() {
        //todo: consider tilde on letter o
        String[] columns = new String[] { "Fecha", "Cuenta", "Descripción", "Cargo", "Abono", "Saldo" };
        List<XSSFTableColumn> tableColumns = sheet.getTables().get(0).getColumns();

        if (columns.length != tableColumns.size()) {
            return false;
        }

        for (int i = 0; i < columns.length; i++) {
            if (!columns[i].equals(tableColumns.get(i).getName())) {
                return false;
            }
        }

        return true;
    }

    private boolean hasEmptyRowsWithinTable() {
        //todo: how can this be validated?
        return true;
    }

    private boolean hasValidTabSheet() {
        boolean result = tabSheetName.startsWith("Registros")
                && this.wb.getSheet(tabSheetName) != null;

        if (result) {
            sheet = wb.getSheet(tabSheetName);
        }

        return result;
    }

    private boolean tableHasTotalRow() {
        return xssfTable.getTotalsRowCount() == 1;
    }

    public boolean isValid() {
       return verifyFileVersion()
               && hasValidTabSheet()
               && hasOnlyOneTable()
               && areColumnsInOrder()
               && tableHasTotalRow()
               && hasEmptyRowsWithinTable();
    }
}
