package com.jtmc.apps.reforma.api.v1.catalogcount;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/catalog-count")
public interface CatalogCountApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    CatalogCountResponseList getList();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response insert(CatalogCountRequest catalogCountRequest);

    @GET
    @Path("/{catalogCountId}")
    @Produces(MediaType.APPLICATION_JSON)
    CatalogCountResponse getCatalogCount(@PathParam("catalogCountId") int id);

    @DELETE
    @Path("/{catalogCountId}")
    Response logicalDeleteRecord(@PathParam("catalogCountId") int id);
}
