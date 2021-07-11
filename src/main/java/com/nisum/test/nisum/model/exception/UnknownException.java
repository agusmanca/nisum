package com.nisum.test.nisum.model.exception;

public class UnknownException extends Exception {
    public static final String DESCRIPTION = "Unknown exception has occurred";

    public UnknownException() {
        super(DESCRIPTION);
    }

    public UnknownException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}
