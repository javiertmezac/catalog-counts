package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCounts;

import java.util.Date;
import java.util.List;

public interface ICrudActionsRepository {

    void saveCatalogCounts(CatalogCounts catalogCounts) throws Exception;
    CatalogCounts getCatalogCount(CatalogCounts catalogCounts);
    List<CatalogCounts> getAllCatalogCounts();
    List<CatalogCounts> getRangeDateRegisteredCatalogCounts(Date from, Date to);
}
