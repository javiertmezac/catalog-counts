package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class CatalogCountResponse {
    private int id;

    @JsonSerialize(as = Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
    private Date registrationDate;

    private int catalogCountEnumId;
    private double amount;
    private String details;
    private double total;

    public CatalogCountResponse(int id,
                                Date registrationDate,
                                int catalogCountEnumId,
                                double amount,
                                String details,
                                double total) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.catalogCountEnumId = catalogCountEnumId;
        this.amount = amount;
        this.details = details;
        this.total = total;
    }

    //todo: should we have another Response Class for single CatalogCount ("no total column")?
    public CatalogCountResponse(int id,
                                Date registrationDate,
                                int catalogCountEnumId,
                                double amount,
                                String details) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
