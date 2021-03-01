package com.jtmc.apps.reforma.repository.exception;

public class RepositoryException extends RuntimeException {
    private int statusCode;
    private String message;

    public RepositoryException(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public RepositoryException () {}

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }
}
