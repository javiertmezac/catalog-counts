package com.jtmc.apps.reforma.api.v1.catalogcount;

import java.util.Date;

public class CatalogCountResponse {
    private int id;
    private Date registrationDate;
    private int catalogCountEnumId;
    private double amount;
    private String details;

    public CatalogCountResponse(int id, Date registrationDate, int catalogCountEnumId, double amount, String details) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.catalogCountEnumId = catalogCountEnumId;
        this.amount = amount;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

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
}
