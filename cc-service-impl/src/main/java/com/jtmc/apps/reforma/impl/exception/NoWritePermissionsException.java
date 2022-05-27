package com.jtmc.apps.reforma.impl.exception;

public class NoWritePermissionsException extends ImplementationException {
    public NoWritePermissionsException(String message, int statusCode) {
        super(message, statusCode);
    }
}
