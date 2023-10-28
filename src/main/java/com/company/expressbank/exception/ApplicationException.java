package com.company.expressbank.exception;

import com.company.expressbank.model.enums.Exceptions;
public class ApplicationException extends RuntimeException {
    private final Exceptions exceptions;

    public ApplicationException(Exceptions exceptions) {
        super(exceptions.getMessage());
        this.exceptions = exceptions;
    }

    public Exceptions getExceptions() {
        return exceptions;
    }
}



