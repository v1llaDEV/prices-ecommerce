package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

/**
 * The type Custom invalid parameter exception.
 */
public class CustomInvalidParameterException extends RuntimeException{
    /**
     * Instantiates a new Custom invalid parameter exception.
     *
     * @param message the message
     */
    public CustomInvalidParameterException(String message){
        super(message);
    };
}
