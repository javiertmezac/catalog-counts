package com.jtmc.apps.reforma.api.v1.report;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/branch")
public interface ReportApi {

    @GET
    @Path("/{branchId}/report")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    PeriodReportResponseList periodReportStatus(@PathParam("branchId") int branchId);

    @POST
    @Path("/{branchId}/report/default")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ReportResponse createReport(@PathParam("branchId") int branchId, ReportRequest reportRequest);

}
