package com.jtmc.apps.reforma.impl.exception;

public class PersonaNotFoundException extends ImplementationException {
    public PersonaNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }
}
