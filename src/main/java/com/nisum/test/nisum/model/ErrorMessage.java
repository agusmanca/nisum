package com.nisum.test.nisum.model;

public class ErrorMessage {
    private String exception;
    private String message;

    public ErrorMessage(Exception exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage());
    }

    public ErrorMessage(String exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorMessage: [exception: " + exception + ", message: " + message +"]";
    }
}
