package com.jtmc.apps.reforma.api.v1.excelimport;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/v1/excelimport")
public interface ExcelImportApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response excelImportStatus(@QueryParam("personProfileId") UUID personProfileId);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response startExcelImportProcess(ExcelImportProcessRequest importProcessRequest);

}
