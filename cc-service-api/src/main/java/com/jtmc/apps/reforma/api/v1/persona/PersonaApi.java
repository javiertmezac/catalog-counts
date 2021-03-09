package com.jtmc.apps.reforma.api.v1.persona;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/personas")
public interface PersonaApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PersonaResponseList selectPersonas();
}
