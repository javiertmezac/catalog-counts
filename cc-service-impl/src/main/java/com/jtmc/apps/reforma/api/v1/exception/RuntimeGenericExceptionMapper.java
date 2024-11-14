package com.jtmc.apps.reforma.api.v1.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class RuntimeGenericExceptionMapper implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException e) {

        GenericResponseErrorMessage errorMessage;

        if (e instanceof IllegalArgumentException || e instanceof NullPointerException) {
            errorMessage = new GenericResponseErrorMessage(
                    400, e.getMessage(), e.getClass().getSimpleName()
            );
        } else {
            e.printStackTrace();
            errorMessage = new GenericResponseErrorMessage(
                    500, "Unmapped Exception in Catalog Count Service","UnmappedException"
            );
        }

        return  Response.status(errorMessage.getStatus()).entity(errorMessage).build();
    }
}
