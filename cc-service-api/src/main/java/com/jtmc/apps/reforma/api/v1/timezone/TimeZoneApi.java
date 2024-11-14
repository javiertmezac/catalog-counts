package com.jtmc.apps.reforma.api.v1.timezone;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/timezone")
public interface TimeZoneApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    TimeZoneResponseList getTimezones();
}
