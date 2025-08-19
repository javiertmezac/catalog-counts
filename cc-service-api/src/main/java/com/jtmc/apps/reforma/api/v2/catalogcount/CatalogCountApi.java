package com.jtmc.apps.reforma.api.v2.catalogcount;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/v2/branch")
public interface CatalogCountApi {

    @GET
    @Path("/{branchId}/catalog-count")
    @Produces(MediaType.APPLICATION_JSON)
    PaginatedCatalogCount getList(@PathParam("branchId") Integer branchId, @QueryParam("page") Integer page,
                                     @QueryParam("pageSize") Integer size, @QueryParam("filterYear") Integer filterYear);

}
