package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

public class InvalidProductIdException extends CustomInvalidParameterException{
    public InvalidProductIdException(String message) {
        super(message);
    }
}
