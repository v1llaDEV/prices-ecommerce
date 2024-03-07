package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

public class InvalidBrandIdException extends CustomInvalidParameterException{
    public InvalidBrandIdException(String message) {
        super(message);
    }
}
