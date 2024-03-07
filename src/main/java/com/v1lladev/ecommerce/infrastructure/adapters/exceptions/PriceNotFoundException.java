package com.v1lladev.ecommerce.infrastructure.adapters.exceptions;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String message) {
        super(message);
    }
}

