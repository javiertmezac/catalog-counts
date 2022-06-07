package com.jtmc.apps.reforma.api.v1.period;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/v1/period")
public interface PeriodApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PeriodResponse getPeriod(@QueryParam("toMonth") int toMonth, @QueryParam("year") int year);
}
