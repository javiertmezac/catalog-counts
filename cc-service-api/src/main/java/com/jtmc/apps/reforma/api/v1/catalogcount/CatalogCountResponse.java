package com.jtmc.apps.reforma.api.v1.catalogcount;

public class CatalogCountResponse  {
    private int id;
    private String registrationDate;
    private String catalogCountEnum;
    private double amount;
    private String details;
    private double total;
    private boolean editable;

    public CatalogCountResponse(int id,
                                String registrationDate,
                                String catalogCountEnum,
                                double amount,
                                String details,
                                double total,
                                boolean editable) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.catalogCountEnum = catalogCountEnum;
        this.amount = amount;
        this.details = details;
        this.total = total;
        this.editable = editable;
    }

    //todo: should we have another Response Class for single CatalogCount ("no total column")?
    public CatalogCountResponse(int id,
                                String registrationDate,
                                String catalogCountEnum,
                                double amount,
                                String details) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.catalogCountEnum = catalogCountEnum;
        this.amount = amount;
        this.details = details;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCatalogCountEnum() {
        return catalogCountEnum;
    }

    public void setCatalogCountEnum(String catalogCountEnum) {
        this.catalogCountEnum = catalogCountEnum;
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
