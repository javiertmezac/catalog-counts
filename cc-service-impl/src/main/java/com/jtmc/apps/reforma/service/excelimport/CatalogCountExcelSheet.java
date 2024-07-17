package com.jtmc.apps.reforma.service.excelimport;


import com.jtmc.apps.reforma.domain.CatalogCount;

public class CatalogCountExcelSheet extends CatalogCount  {

    public String printInsertSqlStatement() {
        return String.format("'%s', %d, %s, '%s', '%s', '%s'", this.getRegistration(),
                this.getCatalogcountenumid(), this.getAmount(), this.getDetails(),
                this.getIsdeleted(), this.getBranchid());
    }
}
