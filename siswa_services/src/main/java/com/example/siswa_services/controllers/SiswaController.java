package com.example.siswa_services.controllers;

import com.example.siswa_services.ExceptionHandler.DataTidakDitemukanException;
import com.example.siswa_services.ExceptionHandler.GuruTidakAktifatauTidakAdaException;
import com.example.siswa_services.SiswaServicesImpl.SiswaServiceImpl;
import com.example.siswa_services.entities.Siswa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/siswa")
public class SiswaController {
    private final SiswaServiceImpl siswaService;

    public SiswaController(SiswaServiceImpl siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping
    public ResponseEntity<List<Siswa>> getAllSiswa() throws DataTidakDitemukanException {
        return ResponseEntity.ok(siswaService.getAllSiswa());
    }

    @GetMapping("/aktif")
    public ResponseEntity<List<Siswa>> getAllSiswaAktif() throws DataTidakDitemukanException {
        return ResponseEntity.ok(siswaService.getAllSiswaAktif());
    }

    @GetMapping("/tidak-aktif")
    public ResponseEntity<List<Siswa>> getAllSiswaTidakAktif() throws DataTidakDitemukanException {
        return ResponseEntity.ok(siswaService.getAllSiswaTidakAktif());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Siswa>> getSiswaById(@PathVariable("id") String id) throws DataTidakDitemukanException {;
        return ResponseEntity.ok(siswaService.getSiswaById(id));
    }

    @PostMapping()
    public ResponseEntity<Siswa> tambahSiswa(@RequestBody Siswa siswa) throws GuruTidakAktifatauTidakAdaException {
        Siswa simpanSiswa = siswaService.save(siswa);
        return ResponseEntity.ok(simpanSiswa);
    }
}
