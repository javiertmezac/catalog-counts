package com.jtmc.apps.reforma.api.v1.catalogcount;

import java.time.Instant;

public class CatalogCountRequest {
    private int id;
    private int catalogCountEnumId;
    private double amount;
    private String details;
    private Instant registrationDate;
    private int transferToAccountId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getTransferToAccountId() {
        return transferToAccountId;
    }

    public void setTransferToAccountId(int transferToAccountId) {
        this.transferToAccountId = transferToAccountId;
    }
}
