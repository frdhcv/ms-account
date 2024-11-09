package com.example.msaccount.exception;

public class InvalidCartNumberException extends RuntimeException {
    public InvalidCartNumberException(String message) {
        super(message);
    }
}