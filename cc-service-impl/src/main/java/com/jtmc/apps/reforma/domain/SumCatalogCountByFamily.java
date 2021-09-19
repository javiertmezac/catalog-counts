package com.jtmc.apps.reforma.domain;

public class SumCatalogCountByFamily {

    private int catalogCountEnumId;
    private double sumAmount;
    private String family;

    public double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public int getCatalogCountEnumId() {
        return catalogCountEnumId;
    }

    public void setCatalogCountEnumId(int catalogCountEnumId) {
        this.catalogCountEnumId = catalogCountEnumId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
