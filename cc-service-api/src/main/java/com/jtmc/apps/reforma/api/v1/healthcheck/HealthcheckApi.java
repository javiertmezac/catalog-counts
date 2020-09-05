package com.jtmc.apps.reforma.api.v1.healthcheck;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/public/v1")
public interface HealthcheckApi {

        @GET
        @Path("/status")
        @Produces(MediaType.APPLICATION_JSON)
        Response checkStatus();
}
