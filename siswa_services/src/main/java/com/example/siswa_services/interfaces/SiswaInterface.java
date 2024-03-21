package com.example.siswa_services.interfaces;

import com.example.siswa_services.ExceptionHandler.DataTidakDitemukanException;
import com.example.siswa_services.ExceptionHandler.GuruTidakAktifatauTidakAdaException;
import com.example.siswa_services.entities.Siswa;

import java.util.List;
import java.util.Optional;

public interface SiswaInterface {
    List<Siswa> getAllSiswa() throws DataTidakDitemukanException;
    List<Siswa> getAllSiswaAktif() throws DataTidakDitemukanException;
    List<Siswa> getAllSiswaTidakAktif() throws DataTidakDitemukanException;
    Optional<Siswa> getSiswaById(String id) throws DataTidakDitemukanException;
    Siswa save (Siswa siswa) throws GuruTidakAktifatauTidakAdaException;
}
