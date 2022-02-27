package com.paycore.CreditSystem.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message + " not found!");
    }

}
