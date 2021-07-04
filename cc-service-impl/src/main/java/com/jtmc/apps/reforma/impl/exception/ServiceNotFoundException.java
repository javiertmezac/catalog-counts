package com.jtmc.apps.reforma.impl.exception;

public class ServiceNotFoundException extends ImplementationException {
    public ServiceNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }
}
