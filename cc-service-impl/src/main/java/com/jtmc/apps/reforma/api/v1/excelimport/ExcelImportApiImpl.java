package com.jtmc.apps.reforma.api.v1.excelimport;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.service.excelimport.ExcelImportService;

import jakarta.ws.rs.core.Response;
import java.util.UUID;

public class ExcelImportApiImpl implements ExcelImportApi {


    @Inject
    private ExcelImportService excelImportService;

    @Override
    public Response excelImportStatus(UUID personProfileId) {
        return null;
    }

    @Override
    public Response startExcelImportProcess(ExcelImportProcessRequest importProcessRequest) {

        excelImportService.execute(importProcessRequest.getFileStorageKey(), importProcessRequest.getTabName());
        return Response.noContent().build();

        /*
        todo: (future)
          who is doing the request?
          validation to know is same request is being done? (who to validate data transferred?)
          how is this affecting DB? maybe add a checksum per tab?, or have a pre-table for validation?
         */
    }
}
