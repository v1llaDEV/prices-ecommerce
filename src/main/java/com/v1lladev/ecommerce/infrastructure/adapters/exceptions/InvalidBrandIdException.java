package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

/**
 * The type Invalid brand id exception.
 */
public class InvalidBrandIdException extends CustomInvalidParameterException{
    /**
     * Instantiates a new Invalid brand id exception.
     *
     * @param message the message
     */
    public InvalidBrandIdException(String message) {
        super(message);
    }
}
