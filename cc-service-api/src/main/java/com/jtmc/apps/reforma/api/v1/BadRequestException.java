package com.jtmc.apps.reforma.api.v1;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
