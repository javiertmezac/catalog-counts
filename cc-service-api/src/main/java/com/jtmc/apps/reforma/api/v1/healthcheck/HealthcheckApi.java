package com.jtmc.apps.reforma.api.v1.healthcheck;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/public/v1")
public interface HealthcheckApi {

        @GET
        @Path("/status")
        @Produces(MediaType.APPLICATION_JSON)
        Response checkStatus();
}
