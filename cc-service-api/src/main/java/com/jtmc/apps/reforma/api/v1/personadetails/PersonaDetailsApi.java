package com.jtmc.apps.reforma.api.v1.personadetails;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/personadetails")
public interface PersonaDetailsApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PersonaDetailsResponseList selectAll();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response insert(PersonaDetailsRequest request);
}
