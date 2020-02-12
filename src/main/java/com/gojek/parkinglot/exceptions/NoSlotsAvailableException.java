package com.gojek.parkinglot.exceptions;

public class NoSlotsAvailableException extends Exception {

    public NoSlotsAvailableException(String message) {
        super(message);
    }
}