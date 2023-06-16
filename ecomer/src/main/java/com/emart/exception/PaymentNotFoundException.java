package com.emart.exception;

/**
 * Custom exception class for indicating that a payment resource is not found.
 */
public class PaymentNotFoundException extends RuntimeException {

    /**
     * Constructs an instance of PaymentNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
