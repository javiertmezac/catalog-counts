package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.GenericResponseMessage;
import com.jtmc.apps.reforma.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        responseList.setCatalogCountResponseCollection(new ArrayList<>());
        responseList.setSaldoAnterior(1500);

        Collection<CatalogCount> catalogCounts = catalogCountMapper.selectAllRecords();

        double total = responseList.getSaldoAnterior();
        for (CatalogCount next : catalogCounts) {
            total = getTotal(next, total);
            responseList.getCatalogCountResponseCollection().add(new CatalogCountResponse(
                    next.getId(),
                    next.getRegistrationDate(),
                    next.getCatalogCountEnumId(),
                    next.getAmount(),
                    next.getDetails(),
                    total
            ));
        }
        return responseList;
    }

    private double getTotal(CatalogCount catalogCount, double saldo) {
       if (catalogCount.getCatalogCountEnumId() <= 3)  {
          saldo = saldo + catalogCount.getAmount();
       } else {
           saldo = saldo - catalogCount.getAmount();
       }
       return saldo;
    }

    @Override
    @Transactional
    public Response insert(CatalogCountRequest catalogCountRequest) {

        CatalogCount catalogCount = new CatalogCount();
        Date registration = new Date();

        checkNotNull(catalogCountRequest, "request object cannot be null");
        catalogCount.setAmount(catalogCountRequest.getAmount());
        catalogCount.setDetails(catalogCountRequest.getDetails());
        catalogCount.setCatalogCountEnumId(catalogCountRequest.getCatalogCountEnumId());
        catalogCount.setDeleted(false);
        catalogCount.setRegistrationDate(registration);

        catalogCountMapper.insertIntoCatalogCount(catalogCount);
        //todo: this is not Json type
        return Response.ok().build();
    }

    public CatalogCountResponse getCatalogCount(int id) {
        LOGGER.info("CatalogCountId payload: " + id);

        CatalogCount catalogCount = catalogCountMapper.selectOneRecord(id);
        if (catalogCount == null) {
           throw new NotFoundException("Catalog Count id: " + id + " not found");
        }

        return new CatalogCountResponse(
                catalogCount.getId(),
                catalogCount.getRegistrationDate(),
                catalogCount.getCatalogCountEnumId(),
                catalogCount.getAmount(),
                catalogCount.getDetails(),
                1
        );
    }

    //todo: should have a test to verify logicalDelete was done correctly
    @Transactional
    public Response logicalDeleteRecord(int id) {
        catalogCountMapper.logicalDeleteRecord(id);
        return Response.noContent().build();
    }
}
