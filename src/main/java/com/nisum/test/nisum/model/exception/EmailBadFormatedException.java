package com.nisum.test.nisum.model.exception;

public class EmailBadFormatedException extends Exception {
    public static final String DESCRIPTION = "El email presenta un formato incorrecto";

    public EmailBadFormatedException() {
        super(DESCRIPTION);
    }

    public EmailBadFormatedException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}
