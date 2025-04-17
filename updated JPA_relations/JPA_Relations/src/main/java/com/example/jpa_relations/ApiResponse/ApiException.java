package com.example.jpa_relations.ApiResponse;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
}
