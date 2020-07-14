package com.jtmc.apps.reforma.api.v1.healthcheck;


import javax.ws.rs.core.Response;

public class HealthcheckImpl implements HealthcheckApi {

    @Override
    public Response checkStatus() {
        HealthcheckStatus status = new HealthcheckStatus();
        status.setStatus("Pass");
        return Response.status(200).entity(status).build();
    }
}


