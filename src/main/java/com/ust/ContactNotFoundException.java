package com.ust;

public class ContactNotFoundException extends Exception {

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
