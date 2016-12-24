package com.rajesh.java8.cars;

/**
 * Created by E797240 on 27/11/2016.
 */
public class InvalidMoveException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidMoveException(String message) {
        super(message);
    }
}
