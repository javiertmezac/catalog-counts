package com.jtmc.apps.reforma.api.v1.catalogcount;


public class CatalogCountBase {
    private int id;
    private double amount;
    private String details;

    public CatalogCountBase(int id,
                            double amount,
                            String details) {
        this.id = id;
        this.amount = amount;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
