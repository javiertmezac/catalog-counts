package com.jtmc.apps.reforma.api.v1.excelimport;

import java.util.UUID;

public class ExcelImportProcessRequest {

    private UUID personProfileId;
    private String fileStorageKey;
    private String tabName;

    public UUID getPersonProfileId() {
        return personProfileId;
    }

    public void setPersonProfileId(UUID personProfileId) {
        this.personProfileId = personProfileId;
    }

    public String getFileStorageKey() {
        return fileStorageKey;
    }

    public void setFileStorageKey(String fileStorageKey) {
        this.fileStorageKey = fileStorageKey;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
}
