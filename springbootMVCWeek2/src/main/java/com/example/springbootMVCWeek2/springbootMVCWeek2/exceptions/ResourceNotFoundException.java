package com.example.springbootMVCWeek2.springbootMVCWeek2.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
