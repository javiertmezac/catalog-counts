package com.jtmc.apps.reforma.api.v2.catalogcount;

import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountCumulativeSumResponse;
import com.jtmc.apps.reforma.api.v2.Pagination;

import java.util.List;

public class PaginatedCatalogCount {
    private List<CatalogCountCumulativeSumResponse> catalogCountCumulativeSumResponseCollection;
    private Pagination pagination;

    public List<CatalogCountCumulativeSumResponse> getCatalogCountResponseCollection() {
        return catalogCountCumulativeSumResponseCollection;
    }

    public void setCatalogCountResponseCollection(List<CatalogCountCumulativeSumResponse> catalogCountCumulativeSumResponseCollection) {
        this.catalogCountCumulativeSumResponseCollection = catalogCountCumulativeSumResponseCollection;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
