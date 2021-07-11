package com.nisum.test.nisum.model.exception;

public class UserByEmailNotFoundException extends Exception {
    public static final String DESCRIPTION = "Usuario no encontrado";

    public UserByEmailNotFoundException() {
        super(DESCRIPTION);
    }

    public UserByEmailNotFoundException(String detail) {
        super(DESCRIPTION + " " + detail);
    }
}
