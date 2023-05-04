package com.knoldus.microservice1.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not Found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
