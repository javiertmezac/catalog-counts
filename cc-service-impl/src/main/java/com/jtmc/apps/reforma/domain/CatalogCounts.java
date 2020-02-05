package com.jtmc.apps.reforma.domain;

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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CatalogCountsEnum getCountsEnum() {
        return countsEnum;
    }

    public void setCountsEnum(CatalogCountsEnum countsEnum) {
        this.countsEnum = countsEnum;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }
}
