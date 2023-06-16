package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a product detail is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductDetailsNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ProductDetailsNotFoundException with the specified error message.
     * @param message the error message
     */
    public ProductDetailsNotFoundException(String message) {
        super(message);
    }
}
