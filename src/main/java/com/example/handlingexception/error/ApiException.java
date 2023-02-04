package com.example.handlingexception.error;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
