package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to indicate that a cart resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    /**
     * Constructs an instance of CartNotFoundException.
     *
     * @param resourceName The name of the resource.
     * @param fieldName    The name of the field.
     * @param fieldValue   The value of the field.
     */
    public CartNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    /**
     * Gets the name of the resource.
     *
     * @return The resource name.
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Gets the name of the field.
     *
     * @return The field name.
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Gets the value of the field.
     *
     * @return The field value.
     */
    public Object getFieldValue() {
        return fieldValue;
    }
}
