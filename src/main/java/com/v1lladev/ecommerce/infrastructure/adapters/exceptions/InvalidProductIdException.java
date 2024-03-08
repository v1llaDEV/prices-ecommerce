package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

/**
 * The type Invalid product id exception.
 */
public class InvalidProductIdException extends CustomInvalidParameterException{
    /**
     * Instantiates a new Invalid product id exception.
     *
     * @param message the message
     */
    public InvalidProductIdException(String message) {
        super(message);
    }
}
