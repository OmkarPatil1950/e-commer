package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for when an admin is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends RuntimeException {

    /**
     * Constructs an AdminNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public AdminNotFoundException(String message) {
        super(message);
    }
}
