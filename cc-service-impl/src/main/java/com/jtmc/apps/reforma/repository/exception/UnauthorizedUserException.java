package com.jtmc.apps.reforma.repository.exception;

import com.jtmc.apps.reforma.impl.exception.ImplementationException;

public class UnauthorizedUserException extends ImplementationException {
    public UnauthorizedUserException(String message, int statusCode) {
        super(message, statusCode);
    }
}
