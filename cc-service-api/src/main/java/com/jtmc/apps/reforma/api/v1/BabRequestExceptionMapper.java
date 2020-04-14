package com.jtmc.apps.reforma.api.v1;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BabRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException e) {
        return Response.status(404)
                .entity(e.getMessage())
                .build();
    }
}
