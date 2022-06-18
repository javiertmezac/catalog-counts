package com.jtmc.apps.reforma.api.v1.period;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/period")
public interface PeriodApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PeriodResponseList getPeriod(@QueryParam("toMonth") int toMonth, @QueryParam("year") int year);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response insert(PeriodRequest request);
}
