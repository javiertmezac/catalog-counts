package com.jtmc.apps.reforma.domain;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;

public class CatalogCount {
    private int id;
    private Instant registrationDate;
    private int catalogCountEnumId;
    private CatalogCountEnum catalogCountEnum;
    private double amount;
    private String details;
    private boolean isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
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
        checkArgument(StringUtils.isNotBlank(details), "Missing details");
        this.details = details;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isValidCatalogCountEnum() {
       return false;
    }

    public CatalogCountEnum getCatalogCountEnum() {
        return catalogCountEnum;
    }

    public void setCatalogCountEnum(CatalogCountEnum catalogCountEnum) {
        this.catalogCountEnum = catalogCountEnum;
    }
}
