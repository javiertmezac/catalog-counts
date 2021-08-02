package com.jtmc.apps.reforma.api.v1.report.audit;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/report/audit")
public interface AuditReportApi {

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AuditReportResponse createAuditReport(AuditReportRequest auditReportRequest);
}
