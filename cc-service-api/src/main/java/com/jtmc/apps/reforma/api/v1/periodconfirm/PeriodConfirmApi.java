package com.jtmc.apps.reforma.api.v1.periodconfirm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/branch/{branchId}/period/{periodId}")
public interface PeriodConfirmApi {

    @POST
    @Path("/confirm")
    @Produces(MediaType.APPLICATION_JSON)
    void confirmPeriodForBranch(@PathParam("branchId") int branchId, @PathParam("periodId") int periodId);
}
