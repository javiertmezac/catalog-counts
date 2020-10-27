package com.jtmc.apps.reforma.api.v1.excelimport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/v1/excelimport")
public interface ExcelImportApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response excelImportStatus(@QueryParam("personProfileId") UUID personProfileId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response startExcelImportProcess(ExcelImportProcessRequest importProcessRequest);

}
