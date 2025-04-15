package com.example.jpa.ApiResponse;

public class ApiException extends RuntimeException{

    // constructor
    public ApiException(String message){
        super(message); // super to RunTimeException
    }

}
