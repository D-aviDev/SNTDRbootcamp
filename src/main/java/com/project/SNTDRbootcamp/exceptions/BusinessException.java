package com.project.SNTDRbootcamp.exceptions;

public class BusinessException extends RuntimeException{

    private final String message;

    public BusinessException(String message){
        super(message);
        this.message = message;
    }
}
