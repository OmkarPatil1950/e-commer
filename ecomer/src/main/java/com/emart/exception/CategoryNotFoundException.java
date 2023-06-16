package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for indicating that a category resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

    /**
     * Constructs an instance of CategoryNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
