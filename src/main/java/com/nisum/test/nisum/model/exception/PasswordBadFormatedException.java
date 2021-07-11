package com.nisum.test.nisum.model.exception;

public class PasswordBadFormatedException extends Exception {
    public static final String DESCRIPTION = "El password presenta un formato incorrecto";

    public PasswordBadFormatedException() {
        super(DESCRIPTION);
    }

    public PasswordBadFormatedException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}