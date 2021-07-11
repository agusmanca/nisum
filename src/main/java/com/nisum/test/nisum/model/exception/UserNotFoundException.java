package com.nisum.test.nisum.model.exception;

public class UserNotFoundException extends Exception {
    public static final String DESCRIPTION = "Usuario no encontrado";

    public UserNotFoundException() {
        super(DESCRIPTION);
    }

    public UserNotFoundException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}
