package com.jtmc.apps.reforma.api.v1.periodconfirm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/branch/{branchId}/period/{periodId}")
public interface PeriodConfirmApi {

    @POST
    @Path("/confirm")
    @Produces(MediaType.APPLICATION_JSON)
    Response confirmPeriodForBranch(@PathParam("branchId") int branchId, @PathParam("periodId") int periodId);

    @GET
    @Path("/confirm")
    @Produces(MediaType.APPLICATION_JSON)
    ConfirmResponse selectOne(@PathParam("branchId") int branchId,
                              @PathParam("periodId") int periodId);
}
