package com.jtmc.apps.reforma.domain;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class CatalogCounts {

    private double amount;
    private CatalogCountsEnum countsEnum;
    private String details;
    private LocalDateTime registrationDateTime;

    public CatalogCounts() {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws Exception {
        if (amount <= 0.0) {
            throw new Exception("Amount cannot be less or equals zero");
        }
        this.amount = amount;
    }

    public CatalogCountsEnum getCountsEnum() {
        return countsEnum;
    }

    public void setCountsEnum(CatalogCountsEnum countsEnum) throws Exception {
        if ( countsEnum == null) {
            throw new Exception("counts cannot be null");
        }

        this.countsEnum = countsEnum;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) throws Exception {
        if (StringUtils.isBlank(details)) {
            throw new Exception("Details should not be blank");
        }

        this.details = details;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) throws Exception {
        if (registrationDateTime == null) {
            throw new Exception("registration DateTime shouldn't be null");
        }
        this.registrationDateTime = registrationDateTime;
    }
}
