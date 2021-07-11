package com.nisum.test.nisum.model.exception;

public class NotDeletedUserException extends Exception {
    public static final String DESCRIPTION = "Error: el usuario no fue eliminado";

    public NotDeletedUserException() {
        super(DESCRIPTION);
    }

    public NotDeletedUserException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}