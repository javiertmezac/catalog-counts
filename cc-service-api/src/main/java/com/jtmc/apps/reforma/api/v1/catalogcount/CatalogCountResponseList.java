package com.jtmc.apps.reforma.api.v1.catalogcount;

import java.util.List;

public class CatalogCountResponseList {

    private double saldoAnterior;
    private List<CatalogCountResponse> catalogCountResponseCollection;

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public List<CatalogCountResponse> getCatalogCountResponseCollection() {
        return catalogCountResponseCollection;
    }

    public void setCatalogCountResponseCollection(List<CatalogCountResponse> catalogCountResponseCollection) {
        this.catalogCountResponseCollection = catalogCountResponseCollection;
    }
}
