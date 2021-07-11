package com.nisum.test.nisum.model.exception;

public class EmailExistException extends Exception {
    public static final String DESCRIPTION = "El email ya existe";

    public EmailExistException() {
        super(DESCRIPTION);
    }

    public EmailExistException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}