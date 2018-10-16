package com.company;

public class WrongDateException extends Exception {

    public WrongDateException() {
    }

    public WrongDateException(String message) {
        super(message);
    }
}
