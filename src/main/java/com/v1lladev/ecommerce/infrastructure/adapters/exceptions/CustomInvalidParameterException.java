package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

public class CustomInvalidParameterException extends RuntimeException{
    public CustomInvalidParameterException(String message){
        super(message);
    };
}
