package com.jtmc.apps.reforma.api.v1.catalogcount;

import java.util.List;

public class CatalogCountResponseList {

    private List<CatalogCountCumulativeSumResponse> catalogCountCumulativeSumResponseCollection;

    public List<CatalogCountCumulativeSumResponse> getCatalogCountResponseCollection() {
        return catalogCountCumulativeSumResponseCollection;
    }

    public void setCatalogCountResponseCollection(List<CatalogCountCumulativeSumResponse> catalogCountCumulativeSumResponseCollection) {
        this.catalogCountCumulativeSumResponseCollection = catalogCountCumulativeSumResponseCollection;
    }
}
