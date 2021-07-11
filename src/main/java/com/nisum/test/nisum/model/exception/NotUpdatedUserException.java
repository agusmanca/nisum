package com.nisum.test.nisum.model.exception;

public class NotUpdatedUserException extends Exception {
    public static final String DESCRIPTION = "Error: El usuario no fue modificado";

    public NotUpdatedUserException() {
        super(DESCRIPTION);
    }

    public NotUpdatedUserException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}
