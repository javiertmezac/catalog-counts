package com.jtmc.apps.reforma.repository.mybatis;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.mybatis.exception.MyBatisRepositoryException;

import java.util.Collection;

public class MyBatisCatalogCountRepository implements CatalogCountRepository {

    @Inject
    private CatalogCountMapper mapper;

    @Override
    public void insert(CatalogCount catalogCount) {
        if(catalogCount == null) {
            throw new MyBatisRepositoryException("CatalogCount should not be null", 500);
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
