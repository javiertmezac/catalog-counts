package com.jtmc.apps.reforma.api.v1.catalogcountenum;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/catalog-count-enum")
public interface CatalogCountEnumApi {

   @GET
   @Path("/")
   @Produces(MediaType.APPLICATION_JSON)
   CatalogCountEnumResponseList getCatalogCountEnums();
}
