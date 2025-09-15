package com.jtmc.apps.reforma.api.v2.catalogcount;

import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.api.v2.Pagination;

import java.util.List;

public class PaginatedCatalogCount {
    private List<CatalogCountResponse> catalogCountResponseCollection;
    private Pagination pagination;

    public List<CatalogCountResponse> getCatalogCountResponseCollection() {
        return catalogCountResponseCollection;
    }

    public void setCatalogCountResponseCollection(List<CatalogCountResponse> catalogCountResponseCollection) {
        this.catalogCountResponseCollection = catalogCountResponseCollection;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
