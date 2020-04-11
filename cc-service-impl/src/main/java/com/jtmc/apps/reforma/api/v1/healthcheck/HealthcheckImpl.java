package com.jtmc.apps.reforma.api.v1.healthcheck;

public class HealthcheckImpl implements HealthcheckApi {

    @Override
    public String checkHealth() {
        return "Health check: OK";
    }

    @Override
    public String checkStatus() {
        return "Status: OK";
    }
}


