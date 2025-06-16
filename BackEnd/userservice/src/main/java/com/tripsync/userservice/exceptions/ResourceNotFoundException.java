package com.tripsync.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    String field;
    String fieldId;

    public ResourceNotFoundException(){
    }

    public ResourceNotFoundException(String message, Throwable cause, String resourceName,String field, String fieldName){
        super(String.format("%s not found with %s: %s", resourceName, field, fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }

    public ResourceNotFoundException(String resourceName,String field, String fieldId){
        super(String.format("%s not found with %s: %s", resourceName, field, fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }
}
