package com.jtmc.apps.reforma.api.v1.exception;

import com.jtmc.apps.reforma.impl.exception.ImplementationException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ImplementationGenericExceptionMapper implements
        ExceptionMapper<ImplementationException> {

    @Override
    public Response toResponse(ImplementationException e) {
        GenericResponseErrorMessage errorMessage =
                new GenericResponseErrorMessage(
                        e.getStatusCode(),
                        e.getMessage(),
                        e.getClass().getSimpleName()
                );
        return Response.status(errorMessage.getStatus()).entity(errorMessage).build();
    }
}
