package com.nisum.test.nisum.model.exception;

public class NotCreatedUserException extends Exception {
    public static final String DESCRIPTION = "Error: el usuario no fue creado";

    public NotCreatedUserException() {
        super(DESCRIPTION);
    }

    public NotCreatedUserException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}
