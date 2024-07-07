package com.jtmc.apps.reforma.api.v1.catalogcount;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/branch")
public interface CatalogCountApi {

    @GET
    @Path("/{branchId}/catalog-count")
    @Produces(MediaType.APPLICATION_JSON)
    CatalogCountResponseList getList(@PathParam("branchId") Integer branchId);

    @POST
    @Path("/{branchId}/catalog-count")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response insert(@PathParam("branchId") Integer branchId, CatalogCountRequest catalogCountRequest);

    @PUT
    @Path("/{branchId}/catalog-count")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response updateCatalogCount(@PathParam("branchId") Integer branchId, CatalogCountRequest catalogCountRequest);

    @GET
    @Path("/{branchId}/catalog-count/{catalogCountId}")
    @Produces(MediaType.APPLICATION_JSON)
    CatalogCountResponse getCatalogCount(@PathParam("branchId") Integer branchId, @PathParam("catalogCountId") int id);

    @DELETE
    @Path("/{branchId}/catalog-count/{catalogCountId}")
    @Produces(MediaType.APPLICATION_JSON)
    Response logicalDeleteRecord(@PathParam("branchId") Integer branchId, @PathParam("catalogCountId") int id);
}
