package com.restapi.bookrestapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    long fiedValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fiedValue) {
        super(String.format("%s not found %s : %s", resourceName, fieldName, fiedValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fiedValue = fiedValue;
    }
}
