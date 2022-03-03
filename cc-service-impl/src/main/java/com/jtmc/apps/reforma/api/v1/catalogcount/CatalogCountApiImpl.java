package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class CatalogCountApiImpl implements CatalogCountApi {
    final private Logger LOGGER = LoggerFactory.getLogger(CatalogCountApiImpl.class);

    @Inject
    private CatalogCountImpl catalogCountImpl;

    @Override
    public CatalogCountResponseList getList() {
        CatalogCountResponseList responseList = new CatalogCountResponseList();
        responseList.setCatalogCountResponseCollection(new ArrayList<>());

        responseList.setSaldoAnterior(catalogCountImpl.getCorrespondingTotal());

        double total = responseList.getSaldoAnterior();
//        responseList.setCatalogCountResponseCollection(catalogCountImpl.selectAllRecordsWithTotalColumn(total));
        responseList.setCatalogCountResponseCollection(catalogCountImpl.selectAllWithTotalColumn());

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
        catalogCount.setRegistrationDate(catalogCountRequest.getRegistrationDate());

        catalogCountImpl.insertIntoCatalogCount(catalogCount);
        //todo: this is not Json type
        return Response.noContent().build();
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
                catalogCount.getRegistrationDate().toString(),
                catalogCount.getCatalogCountEnum().getCatalogCountEnumDisplay(),
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
