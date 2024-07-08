package com.jtmc.apps.reforma.api.v1.period;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/period")
public interface PeriodApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PeriodResponseList getPeriod(@QueryParam("toMonth") int toMonth, @QueryParam("year") int year);

    @GET
    @Path("/{periodId}")
    @Produces(MediaType.APPLICATION_JSON)
    PeriodResponse getPeriod(@PathParam("periodId") int periodId);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response insert(PeriodRequest request);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response update(PeriodRequest request);
}
