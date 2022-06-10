package com.jtmc.apps.reforma.repository.exception;

public class UnauthorizedUserException extends RepositoryException {
    public UnauthorizedUserException(String message, int statusCode) {
        super(message, statusCode);
    }
}
