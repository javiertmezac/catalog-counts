package com.jtmc.apps.reforma.api.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericExceptionMapper implements ExceptionMapper<RuntimeException> {

    private Logger LOOGER = LoggerFactory.getLogger(GenericExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException e) {
        GenericResponseMessage message;

        if (e instanceof IllegalArgumentException ||
                e instanceof NullPointerException) {

            message = new GenericResponseMessage(400, e.getMessage(), e.getClass().getSimpleName());
        } else {
            LOOGER.error("Error: " , e);
           message = new GenericResponseMessage(500, e.getMessage(), e.getClass().getSimpleName());
        }

        return Response.status(message.getStatus())
                .entity(message).build();
    }
}
