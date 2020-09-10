package com.jtmc.apps.reforma.api.v1.excelimport;

import javax.ws.rs.core.Response;
import java.util.UUID;

public class ExcelImportImpl implements ExcelImportApi {

    @Override
    public Response excelImportStatus(UUID personProfileId) {
        return null;
    }

    @Override
    public Response startExcelImportProcess(ExcelImportProcessRequest importProcessRequest) {

        //personProfileId
        //fileStorageKey

//        handler.importRowsIntoDB();
        return null;
    }
}
