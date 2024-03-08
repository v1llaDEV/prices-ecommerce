package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

/**
 * The type Price not found exception.
 */
public class PriceNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Price not found exception.
     *
     * @param message the message
     */
    public PriceNotFoundException(String message) {
        super(message);
    }
}

