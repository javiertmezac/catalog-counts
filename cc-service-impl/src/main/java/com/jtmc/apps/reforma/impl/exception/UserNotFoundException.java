package com.jtmc.apps.reforma.impl.exception;

import com.jtmc.apps.reforma.repository.exception.RepositoryException;

public class UserNotFoundException extends RepositoryException {
    public UserNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }
}
