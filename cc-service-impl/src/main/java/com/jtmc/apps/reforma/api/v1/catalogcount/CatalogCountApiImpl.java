package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class CatalogCountApiImpl implements CatalogCountApi {
    private Logger LOGGER = LoggerFactory.getLogger(CatalogCountApiImpl.class);

    @Inject
    private CatalogCountImpl catalogCountImpl;

    @Override
    public CatalogCountResponseList getList() {
        CatalogCountResponseList responseList = new CatalogCountResponseList();
        responseList.setCatalogCountResponseCollection(new ArrayList<>());

        responseList.setSaldoAnterior(catalogCountImpl.getCorrespondingTotal());

        double total = responseList.getSaldoAnterior();
        responseList.setCatalogCountResponseCollection(catalogCountImpl.selectAllRecordsWithTotalColumn(total));

        return responseList;
    }


    @Override
    public Response insert(CatalogCountRequest catalogCountRequest) {

        checkNotNull(catalogCountRequest, "request object cannot be null");
        checkNotNull(catalogCountRequest.getRegistrationDate(), "registrationDate is not provided");
        checkArgument(StringUtils.isNotBlank(catalogCountRequest.getDetails()), "please provide some details");


        CatalogCount catalogCount = new CatalogCount();
        catalogCount.setAmount(catalogCountRequest.getAmount());
        catalogCount.setDetails(catalogCountRequest.getDetails());
        catalogCount.setCatalogCountEnumId(catalogCountRequest.getCatalogCountEnumId());
        catalogCount.setDeleted(false);

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            catalogCount.setRegistrationDate(simpleDateFormat.parse(catalogCountRequest.getRegistrationDate()));
        } catch (ParseException exception) {
           throw new WebApplicationException(exception.getCause().getMessage(), Response.Status.BAD_REQUEST);
        }

        catalogCountImpl.insertIntoCatalogCount(catalogCount);
        //todo: this is not Json type
        return Response.ok().build();
    }

    public CatalogCountResponse getCatalogCount(int id) {
        LOGGER.info("CatalogCountId payload: {} ", id);

        CatalogCount catalogCount = catalogCountImpl.selectOneRecord(id);
        if (catalogCount == null) {
            //todo: bad exception handling here
           throw new RuntimeException("Catalog Count id: " + id + " not found");
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
    public Response logicalDeleteRecord(int id) {
        LOGGER.info("CatalogCountId to be deleted: {}", id);

        catalogCountImpl.logicalDeleteRecord(id);
        return Response.noContent().build();
    }
}
