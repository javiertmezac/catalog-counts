package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.dbmapper.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import org.mybatis.guice.transactional.Transactional;

public class CatalogCountImpl implements CatalogCountApi {
    @Inject
    private CatalogCountMapper catalogCountMapper;

    @Override
    public void getList() {

    }

    @Override
    @Transactional
    public String insert(CatalogCountRequest catalogCountRequest) {
        CatalogCount catalogCount = new CatalogCount();
        catalogCount.setCatalogCountEnumId(catalogCountRequest.getCatalogCountEnumId());
        catalogCount.setAmount(catalogCountRequest.getAmount());
        catalogCount.setDetails(catalogCountRequest.getDetails());
        catalogCount.setDeleted(false);

        catalogCountMapper.insertIntoCatalogCount(catalogCount);
        return "All good!";
    }
}
