package com.jtmc.apps.reforma.api.v1.timezone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/timezone")
public interface TimeZoneApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    TimeZoneResponseList getTimezones();
}
