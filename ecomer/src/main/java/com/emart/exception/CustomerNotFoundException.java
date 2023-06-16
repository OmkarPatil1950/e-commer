package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for indicating that a customer resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    /**
     * Constructs an instance of CustomerNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
