package com.example.guru_services.ExceptionHandler;

public class DataTidakDitemukanException extends RuntimeException{
    private String message;

    public DataTidakDitemukanException(String message) {
        super(message);
        this.message = message;
    }

    public DataTidakDitemukanException(){}
}
