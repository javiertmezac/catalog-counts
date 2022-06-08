package com.jtmc.apps.reforma.api.v1.persona;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/persona")
public interface PersonaApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PersonaResponseList selectAll();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response insert(PersonaRequest request);
}
