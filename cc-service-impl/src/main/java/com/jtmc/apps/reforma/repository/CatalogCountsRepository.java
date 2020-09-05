package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCounts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    Stores CatalogCounts in Memory
 */
class CatalogCountsRepository implements  ICrudActionsRepository {

    private List<CatalogCounts> countsRegistry;

    public CatalogCountsRepository() {
        this.countsRegistry = new ArrayList<>();
    }

    @Override
    public void saveCatalogCounts(CatalogCounts catalogCounts) throws  Exception {

        if (catalogCounts == null) {
            throw new RuntimeException("cannot store a null object");
        }

        this.countsRegistry.add(catalogCounts);
    }

    @Override
    public CatalogCounts getCatalogCount(CatalogCounts catalogCounts) {
        return null;
    }

    @Override
    public List<CatalogCounts> getAllCatalogCounts() {
        return null;
    }

    @Override
    public List<CatalogCounts> getRangeDateRegisteredCatalogCounts(Date from, Date to) {
        return null;
    }
}
