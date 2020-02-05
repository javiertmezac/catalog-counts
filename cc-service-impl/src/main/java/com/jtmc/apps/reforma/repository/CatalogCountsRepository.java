package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCounts;

import java.util.ArrayList;
import java.util.List;

class CatalogCountsRepository {

    private List<CatalogCounts> countsRegistry;

    public CatalogCountsRepository() {
        this.countsRegistry = new ArrayList<>();
    }

    void saveNewRecord(CatalogCounts catalogCounts) throws Exception {
        if (catalogCounts == null) {
            throw new Exception("cannot store a null object");
        }

        if (catalogCounts.getAmount() <= 0.0) {
            throw new Exception("Amount cannot be less or equals to zero");
        }

        this.countsRegistry.add(catalogCounts);
    }

    List<CatalogCounts> getAllCountsRegistered() {
        return this.countsRegistry;
    }
}
