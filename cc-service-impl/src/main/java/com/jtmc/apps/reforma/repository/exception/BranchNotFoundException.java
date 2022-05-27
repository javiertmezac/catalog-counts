package com.jtmc.apps.reforma.repository.exception;

import com.jtmc.apps.reforma.impl.exception.ImplementationException;

public class BranchNotFoundException extends ImplementationException {
    public BranchNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }
}
