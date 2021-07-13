package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.mybatis.exception.MyBatisRepositoryMapperException;

import java.util.Collection;

public class CatalogCountRepository implements ICatalogCountRepository {

    @Inject
    private CatalogCountMapper mapper;

    @Override
    public void insert(CatalogCount catalogCount) {
        if(catalogCount == null) {
            throw new MyBatisRepositoryMapperException("CatalogCount should not be null", 500);
        }
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
