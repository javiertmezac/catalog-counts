package com.jtmc.apps.reforma.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;

public class CatalogCount {
    private int id;
    private Date registrationDate;
    private int catalogCountEnumId;
    private double amount;
    private String details;
    private boolean isDeleted;

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
        if (catalogCountEnumId == 0) {
            throw new IllegalArgumentException("catalogCountEnum should not be 0");
        }
        this.catalogCountEnumId = catalogCountEnumId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("amount should be greater than 0.0");
        }
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        checkArgument(StringUtils.isNotBlank(details), "Invalid arguments");
        this.details = details;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
