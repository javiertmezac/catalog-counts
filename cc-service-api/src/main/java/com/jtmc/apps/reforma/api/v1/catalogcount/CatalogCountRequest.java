package com.jtmc.apps.reforma.api.v1.catalogcount;

public class CatalogCountRequest {
    private int catalogCountEnumId;
    private double amount;
    private String details;
    private String registrationDate;

    public int getCatalogCountEnumId() {
        return catalogCountEnumId;
    }

    public void setCatalogCountEnumId(int catalogCountEnumId) {
        this.catalogCountEnumId = catalogCountEnumId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
       this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
