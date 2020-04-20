package com.jtmc.apps.reforma.api.v1;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericWebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException e) {
        Response.ResponseBuilder responseBuilder = Response.fromResponse(e.getResponse());
        if (e instanceof BadRequestException) {
            responseBuilder.entity(e.getMessage());
        }
        return responseBuilder.build();
    }
}
