package com.jtmc.apps.reforma.api.v1.service;

import java.time.Instant;

public class ServiceRequest {

    private Instant date;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
