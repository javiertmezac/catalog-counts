package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

public class CatalogCountImpl implements CatalogCountApi {
    private Logger LOGGER = LoggerFactory.getLogger(CatalogCountImpl.class);

    @Inject
    private CatalogCountMapper catalogCountMapper;

    @Override
    public CatalogCountResponseList getList() {
        CatalogCountResponseList responseList = new CatalogCountResponseList();
        responseList.catalogCountResponseCollection = new ArrayList<>();

        Collection<CatalogCount> catalogCounts = catalogCountMapper.selectAllRecords();
        for (CatalogCount next : catalogCounts) {
            responseList.catalogCountResponseCollection.add(new CatalogCountResponse(
                    next.getId(),
                    next.getRegistrationDate(),
                    next.getCatalogCountEnumId(),
                    next.getAmount(),
                    next.getDetails()
            ));
        }
        return responseList;
    }

    @Override
    @Transactional
    public String insert(CatalogCountRequest catalogCountRequest) {

        CatalogCount catalogCount = new CatalogCount();
        Date registration = new Date();

        try {
            checkNotNull(catalogCountRequest, "request object cannot be null");
            catalogCount.setAmount(catalogCountRequest.getAmount());
            catalogCount.setDetails(catalogCountRequest.getDetails());
            catalogCount.setCatalogCountEnumId(catalogCountRequest.getCatalogCountEnumId());
            catalogCount.setDeleted(false);
            catalogCount.setRegistrationDate(registration);

        } catch (NullPointerException | IllegalArgumentException e) {
            throw new javax.ws.rs.BadRequestException(e.getMessage());
        }

        catalogCountMapper.insertIntoCatalogCount(catalogCount);
        return "All good!";
    }

    public CatalogCountResponse getCatalogCount(int id) {
        LOGGER.info("CatalogCountId payload: " + id);

        CatalogCount catalogCount = catalogCountMapper.selectOneRecord(id);
        if (catalogCount == null) {
           throw new NotFoundException("Catalog Count id:" + id + " not found");
        }

        return new CatalogCountResponse(
                catalogCount.getId(),
                catalogCount.getRegistrationDate(),
                catalogCount.getCatalogCountEnumId(),
                catalogCount.getAmount(),
                catalogCount.getDetails()
        );
    }


    //todo: should have a test to verify logicalDelete was done correctly
    @Transactional
    public String logicalDeleteRecord(int id) {
        catalogCountMapper.logicalDeleteRecord(id);
        return "All good!";
    }
}
