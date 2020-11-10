package com.jtmc.apps.reforma.repository.mybatis;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;

import java.util.Collection;

public class MyBatisCatalogCountRepository implements CatalogCountRepository {

    @Inject
    private CatalogCountMapper mapper;

    @Override
    public void insert(CatalogCount catalogCount) {
        mapper.insertIntoCatalogCount(catalogCount);
    }

    @Override
    public Collection<CatalogCount> selectAll() {
        return mapper.selectAllRecords();
    }

    @Override
    public void logicalDelete(int id) {
        mapper.logicalDeleteRecord(id);
    }

    @Override
    public CatalogCount selectOneRecord(int id) {
        return mapper.selectOneRecord(id);
    }
}
