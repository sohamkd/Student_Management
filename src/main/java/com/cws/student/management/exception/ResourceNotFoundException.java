package com.cws.student.management.exception;

import lombok.Builder;

@Builder
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException()
    {
        super("Resource not found");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}