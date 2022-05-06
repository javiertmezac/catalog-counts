package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JwtRequired
public class CatalogCountApiImpl implements CatalogCountApi {
    final private Logger LOGGER = LoggerFactory.getLogger(CatalogCountApiImpl.class);

    @Inject
    private CatalogCountImpl catalogCountImpl;

    @Override
    public CatalogCountResponseList getList(Integer branchId) {
        checkNotNull(branchId);
        checkArgument(branchId > 0, "Invalid BranchId");

        CatalogCountResponseList responseList = new CatalogCountResponseList();
        responseList.setCatalogCountResponseCollection(catalogCountImpl.selectAllWithTotalColumn(branchId));

        return responseList;
    }


    @Override
    public Response insert(Integer branchId, CatalogCountRequest catalogCountRequest) {

        checkNotNull(catalogCountRequest, "request object cannot be null");
        checkNotNull(catalogCountRequest.getRegistrationDate(), "registration is not provided");
        checkNotNull(branchId, "branch is not provided");
        checkArgument(StringUtils.isNotBlank(catalogCountRequest.getDetails()), "please provide some details");

        CatalogCount catalogCount = new CatalogCount();
        catalogCount.setAmount(catalogCountRequest.getAmount());
        catalogCount.setDetails(catalogCountRequest.getDetails());
        catalogCount.setCatalogcountenumid(catalogCountRequest.getCatalogCountEnumId());
        catalogCount.setIsdeleted(false);
        catalogCount.setRegistration(catalogCountRequest.getRegistrationDate());
        catalogCount.setBranchid(branchId);

        catalogCountImpl.insertIntoCatalogCount(catalogCount);
        return Response.noContent().build();
    }

    @Override
    public Response updateCatalogCount(Integer branchId, CatalogCountRequest catalogCountRequest) {
        checkNotNull(catalogCountRequest, "invalid Catalog Count payload");
        checkArgument(branchId > 0, "invalid branchId");

        CatalogCount catalogCount = new CatalogCount();
        catalogCount.setId(catalogCountRequest.getId());
        catalogCount.setAmount(catalogCountRequest.getAmount());
        catalogCount.setDetails(catalogCountRequest.getDetails());
        catalogCount.setCatalogcountenumid(catalogCountRequest.getCatalogCountEnumId());
        catalogCount.setRegistration(catalogCountRequest.getRegistrationDate());
        //todo: maybe first to select existing item, then "update"?
        // make sure branchId and id are equals to provided values
//        catalogCount.setBranchid(branchId);

        catalogCountImpl.updateCatalogCount(catalogCount);
        return Response.noContent().build();
    }

    public CatalogCountResponse getCatalogCount(Integer branchId, int id) {
        checkArgument(id > 0, "CatalogCountId not valid");
        checkArgument(branchId > 0, "branchId not valid");

        CatalogCount catalogCount = catalogCountImpl.selectOneRecord(id);
        if (catalogCount == null || !catalogCount.getBranchid().equals(branchId)) {
            //todo: bad exception handling here
           throw new RuntimeException("Catalog Count id: " + id + " not found");
        }

        return new CatalogCountResponse(
                catalogCount.getId(),
                catalogCount.getRegistration().toString(),
                catalogCount.getCatalogcountenumid().toString(),
                catalogCount.getAmount(),
                catalogCount.getDetails()
        );
    }

    //todo: should have a test to verify logicalDelete was done correctly
    public Response logicalDeleteRecord(Integer branchId, int id) {
        LOGGER.info("CatalogCountId to be deleted: {}", id);

        catalogCountImpl.logicalDeleteRecord(id);
        return Response.noContent().build();
    }
}
