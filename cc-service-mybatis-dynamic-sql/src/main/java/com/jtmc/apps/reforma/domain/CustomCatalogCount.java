package com.jtmc.apps.reforma.domain;

public class CustomCatalogCount extends CatalogCount {
    private String identifier;
    private String name;
    private String catalogCountEnum;
    private double cumulativeSum;
    private int totalCountRows;

    private boolean editable;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public double getCumulativeSum() {
        return cumulativeSum;
    }

    public void setCumulativeSum(double cumulativeSum) {
        this.cumulativeSum = cumulativeSum;
    }

    public String getCatalogCountEnum() {
        return catalogCountEnum;
    }

    public void setCatalogCountEnum(String catalogCountEnum) {
        this.catalogCountEnum = catalogCountEnum;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCountRows() {
        return totalCountRows;
    }

    public void setTotalCountRows(int totalCountRows) {
        this.totalCountRows = totalCountRows;
    }
}
