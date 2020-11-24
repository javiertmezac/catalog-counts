package com.jtmc.apps.reforma.api.v1.excelimport;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.service.excelimport.ExcelImportService;

import javax.ws.rs.core.Response;
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

        //personProfileId
        //fileStorageKey

//        handler.importRowsIntoDB();
        return null;
    }
}
