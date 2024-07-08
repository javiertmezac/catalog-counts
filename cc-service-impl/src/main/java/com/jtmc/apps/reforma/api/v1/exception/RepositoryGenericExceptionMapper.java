package com.jtmc.apps.reforma.api.v1.exception;

import com.jtmc.apps.reforma.repository.exception.RepositoryException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class RepositoryGenericExceptionMapper implements ExceptionMapper<RepositoryException> {

    @Override
    public Response toResponse(RepositoryException e) {
        GenericResponseErrorMessage errorMessage =
                new GenericResponseErrorMessage(e.getStatusCode(), e.getMessage(), e.getClass().getSimpleName());
        return Response.status(errorMessage.getStatus()).entity(errorMessage).build();
    }
}
