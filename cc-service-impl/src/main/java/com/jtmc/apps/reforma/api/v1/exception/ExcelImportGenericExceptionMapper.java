package com.jtmc.apps.reforma.api.v1.exception;

import com.jtmc.apps.reforma.service.excelimport.ExcelImportException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ExcelImportGenericExceptionMapper implements ExceptionMapper<ExcelImportException> {

    @Override
    public Response toResponse(ExcelImportException e) {
            String message = e.getCause() != null ? String.format("Exception: %s, Cause: %s", e.getMessage(), e.getCause().getMessage()) : e.getMessage();
        GenericResponseErrorMessage errorMessage =
                new GenericResponseErrorMessage(500, message, e.getClass().getSimpleName());
        return Response.status(errorMessage.getStatus()).entity(errorMessage).build();
    }
}
