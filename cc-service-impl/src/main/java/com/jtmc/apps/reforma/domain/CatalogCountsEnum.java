package com.jtmc.apps.reforma.domain;

public enum CatalogCountsEnum {

    OFRENDA (1.1, CatalogCountsEnum.CARGO),
    DIEZMO (1.3, CatalogCountsEnum.CARGO),
    COMIDA_NINOS (5.2, CatalogCountsEnum.ABONO);

    private static final String ABONO = "ABONO";
    private static final String CARGO = "CARGO";

    private final double value;
    private final String type;

    CatalogCountsEnum(double value, String type) {
       this.value = value;
       this.type = type;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
