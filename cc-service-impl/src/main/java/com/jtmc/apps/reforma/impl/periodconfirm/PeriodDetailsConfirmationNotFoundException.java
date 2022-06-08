package com.jtmc.apps.reforma.impl.periodconfirm;

import com.jtmc.apps.reforma.impl.exception.ImplementationException;

public class PeriodDetailsConfirmationNotFoundException extends ImplementationException {
    public PeriodDetailsConfirmationNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }
}
