package com.rajesh.java8.cars;

public class InvalidStartException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidStartException(String message) {
        super(message);
    }
}
