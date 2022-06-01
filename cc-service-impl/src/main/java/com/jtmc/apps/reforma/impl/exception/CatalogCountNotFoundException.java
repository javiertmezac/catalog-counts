package com.jtmc.apps.reforma.impl.exception;

public class CatalogCountNotFoundException extends ImplementationException {
    public CatalogCountNotFoundException(String catalogCount_not_found, int status_code) {
        super(catalogCount_not_found, status_code);
    }
}
