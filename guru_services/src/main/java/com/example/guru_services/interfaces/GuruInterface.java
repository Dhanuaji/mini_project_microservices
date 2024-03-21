package com.example.guru_services.interfaces;

import com.example.guru_services.ExceptionHandler.DataTidakDitemukanException;
import com.example.guru_services.ExceptionHandler.GagalMenyimpanDataException;
import com.example.guru_services.entities.Guru;

import java.util.List;
import java.util.Optional;

public interface GuruInterface {
    List<Guru> getAllGuru() throws DataTidakDitemukanException;
    List<Guru> getAllGuruAktif() throws DataTidakDitemukanException;
    List<Guru> getAllGuruTidakAktif() throws DataTidakDitemukanException;
    Optional<Guru> getGuruById(String id) throws DataTidakDitemukanException;
    boolean getGuruAktifByNik(String nikgurubertugas);
    Guru save (Guru guru) throws GagalMenyimpanDataException;
    Guru editById(Guru guru) throws GagalMenyimpanDataException;
}
