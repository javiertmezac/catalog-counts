package com.jtmc.apps.reforma.api.v1.healthcheck;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/public/v1")
public interface HealthcheckApi {

        @GET
        @Path("/healthcheck")
        @Produces(MediaType.TEXT_PLAIN)
        String checkHealth();

        @GET
        @Path("/status")
        @Produces(MediaType.TEXT_PLAIN)
        String checkStatus();
}
