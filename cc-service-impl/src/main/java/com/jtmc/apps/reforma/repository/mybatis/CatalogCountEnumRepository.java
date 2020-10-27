package com.jtmc.apps.reforma.repository.mybatis;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.dbmapper.CatalogCountEnumMapper;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;

import java.util.List;

public class CatalogCountEnumRepository {
    @Inject
    private CatalogCountEnumMapper mapper;

    public List<CatalogCountEnum> getList() {
        return  mapper.getAllCatalogCountEnum();
    }
}
