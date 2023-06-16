package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for indicating that an orders resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrdersNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs an instance of OrdersNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public OrdersNotFoundException(String message) {
        super(message);
    }
}
