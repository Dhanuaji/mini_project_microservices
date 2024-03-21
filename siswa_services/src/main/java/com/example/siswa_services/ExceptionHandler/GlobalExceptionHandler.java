package com.example.siswa_services.ExceptionHandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${PesanGuruTidakAktifAtauTidakAda}")
    private String pesanGuruTidakAktifAtauTidakAda;

    @Value(value = "${DataTidakDitemukan}")
    private String pesanDataTidakDitemukan;

    @ExceptionHandler(value = GuruTidakAktifatauTidakAdaException.class)
    public ResponseEntity guruTidakAktifAtauTidakAdaException(GuruTidakAktifatauTidakAdaException guruTidakAktifatauTidakAdaException) {
        return new ResponseEntity(pesanGuruTidakAktifAtauTidakAda, HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(value = DataTidakDitemukanException.class)
    public ResponseEntity dataTidakDitemukanException(DataTidakDitemukanException dataTidakDitemukanException) {
        return new ResponseEntity(pesanDataTidakDitemukan, HttpStatus.NOT_FOUND);
    }
}
