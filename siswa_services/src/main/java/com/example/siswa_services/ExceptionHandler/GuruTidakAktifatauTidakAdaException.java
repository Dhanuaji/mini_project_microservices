package com.example.siswa_services.ExceptionHandler;

public class GuruTidakAktifatauTidakAdaException extends RuntimeException {

    private String message;

    public GuruTidakAktifatauTidakAdaException(String message) {
        super(message);
        this.message = message;
    }

    public GuruTidakAktifatauTidakAdaException(){}
}
