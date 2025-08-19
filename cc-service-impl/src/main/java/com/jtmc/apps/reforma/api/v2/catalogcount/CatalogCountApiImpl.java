package com.jtmc.apps.reforma.api.v2.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponseList;
import com.jtmc.apps.reforma.api.v2.Pagination;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.math3.util.MathUtils.checkNotNull;

@JwtRequired
public class CatalogCountApiImpl implements CatalogCountApi {
    final private Logger logger = LoggerFactory.getLogger(CatalogCountApiImpl.class);

    @Inject
    private CatalogCountImpl catalogCountImpl;

    @Override
    public PaginatedCatalogCount getList(Integer branchId, Integer page, Integer size, Integer filterYear) {
        checkNotNull(branchId);
        checkArgument(branchId > 0, "Invalid BranchId");
        checkArgument(page > 0, "Invalid page number");
        checkArgument(size > 0, "Invalid page size number");
        checkArgument(filterYear > 2022, "Invalid Filter Year (minimum 2022)");


        List<CatalogCountResponse> list = catalogCountImpl.selectAllWithTotalColumn(branchId, page, size, filterYear);
        long totalItems = catalogCountImpl.selectCountPagination(branchId, page, size, filterYear);
        Pagination pagination = new Pagination(page, size, totalPages(totalItems, size), totalItems );

        PaginatedCatalogCount response = new PaginatedCatalogCount();
        response.setCatalogCountResponseCollection(list);
        response.setPagination(pagination);
        return response;
    }

    public int totalPages(long totalItems, int size) {
        return (int) Math.ceil((double) totalItems / size);
    }

}
