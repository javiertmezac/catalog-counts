package com.jtmc.apps.reforma.api.v1.excelimport;

import java.util.Map;
import java.util.UUID;

public class ExcelImportProcessRequest {

    private UUID personProfileId;
    private String fileStorageKey;
    private String tabName;

    public Map<String, Integer> columns;
    public int account;
    public int startRow;
    public int endRow;
    public boolean commit = false;
    public String outputPath;

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
