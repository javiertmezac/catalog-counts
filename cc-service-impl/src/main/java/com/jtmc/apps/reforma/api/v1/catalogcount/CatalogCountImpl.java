package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.BadRequestException;
import com.jtmc.apps.reforma.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import org.mybatis.guice.transactional.Transactional;

import java.time.Instant;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

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
        Date registration = Date.from(Instant.EPOCH);

        try {
            checkNotNull(catalogCountRequest, "request object cannot be null");
            catalogCount.setAmount(catalogCountRequest.getAmount());
            catalogCount.setDetails(catalogCountRequest.getDetails());
            catalogCount.setCatalogCountEnumId(catalogCountRequest.getCatalogCountEnumId());
            catalogCount.setDeleted(false);
            catalogCount.setRegistrationDate(registration);

        } catch (NullPointerException | IllegalArgumentException e) {
            throw new BadRequestException(e.getMessage());
        }

        catalogCountMapper.insertIntoCatalogCount(catalogCount);
        return "All good!";
    }

}
