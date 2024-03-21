package com.example.guru_services.ExceptionHandler;

public class GagalMenyimpanDataException extends RuntimeException{
    private String message;

    public GagalMenyimpanDataException(String message) {
        this.message = message;
    }

    public GagalMenyimpanDataException(){}
}
