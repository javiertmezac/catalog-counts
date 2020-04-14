package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.jtmc.apps.reforma.api.v1.BadRequestException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/catalog-count")
public interface CatalogCountApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    void getList();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    String insert(CatalogCountRequest catalogCountRequest) throws BadRequestException;
}
