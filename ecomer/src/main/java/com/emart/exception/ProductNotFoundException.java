package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for indicating that a product resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    /**
     * Constructs an instance of ProductNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
}
