package com.jtmc.apps.reforma.impl.exception;

public class CatalogCountNotFoundException extends RuntimeException {
    public CatalogCountNotFoundException(String catalogCount_not_found) {
        super(catalogCount_not_found);
    }
}
