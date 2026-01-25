package com.jtmc.apps.reforma.api.v1.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeGenericExceptionMapper implements ExceptionMapper<RuntimeException> {
    private final Logger logger = LoggerFactory.getLogger(RuntimeGenericExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException e) {

        GenericResponseErrorMessage errorMessage;

        if (e instanceof IllegalArgumentException || e instanceof NullPointerException) {
            errorMessage = new GenericResponseErrorMessage(
                    400, e.getMessage(), e.getClass().getSimpleName()
            );
        } else {
            logger.error("", e);
            errorMessage = new GenericResponseErrorMessage(
                    500, "Unmapped Exception in Catalog Count Service","UnmappedException"
            );
        }

        return  Response.status(errorMessage.getStatus()).type(MediaType.APPLICATION_JSON_TYPE).entity(errorMessage).build();
    }
}
