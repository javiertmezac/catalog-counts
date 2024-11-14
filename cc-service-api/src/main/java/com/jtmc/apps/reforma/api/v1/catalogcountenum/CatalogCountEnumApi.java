package com.jtmc.apps.reforma.api.v1.catalogcountenum;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/catalog-count-enum")
public interface CatalogCountEnumApi {

   @GET
   @Path("/")
   @Produces(MediaType.APPLICATION_JSON)
   CatalogCountEnumResponseList getCatalogCountEnums();
}
