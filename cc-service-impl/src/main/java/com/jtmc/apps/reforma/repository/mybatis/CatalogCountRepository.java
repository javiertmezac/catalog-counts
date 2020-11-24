package com.jtmc.apps.reforma.repository.mybatis;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;

public class CatalogCountRepository {

    @Inject
    private CatalogCountMapper mapper;

    public void insert(CatalogCount record) {
        mapper.insertIntoCatalogCount(record);
    }
}
