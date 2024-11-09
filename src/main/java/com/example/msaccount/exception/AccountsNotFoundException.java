package com.example.msaccount.exception;

public class AccountsNotFoundException extends RuntimeException {
    public AccountsNotFoundException(String message) {
        super(message);
    }
}
