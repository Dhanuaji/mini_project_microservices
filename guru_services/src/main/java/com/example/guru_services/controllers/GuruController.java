package com.example.guru_services.controllers;

import com.example.guru_services.ExceptionHandler.DataTidakDitemukanException;
import com.example.guru_services.ExceptionHandler.GagalMenyimpanDataException;
import com.example.guru_services.entities.Guru;
import com.example.guru_services.service.GuruServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/guru")
public class GuruController {

    private final GuruServiceImpl guruServiceImpl;

    public GuruController(GuruServiceImpl guruServiceImpl) {
        this.guruServiceImpl = guruServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<Guru>> getAllGuru() throws DataTidakDitemukanException {
        return ResponseEntity.ok(guruServiceImpl.getAllGuru());
    }

    @GetMapping("/aktif")
    public ResponseEntity<List<Guru>> getAllGuruAktif() throws DataTidakDitemukanException {
        return ResponseEntity.ok(guruServiceImpl.getAllGuruAktif());
    }

    @GetMapping("/tidak-aktif")
    public ResponseEntity<List<Guru>> getAllGuruTidakAktif() throws DataTidakDitemukanException {
        return ResponseEntity.ok(guruServiceImpl.getAllGuruTidakAktif());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Guru>> getGuruById(@PathVariable("id") String id) {
        return ResponseEntity.ok(guruServiceImpl.getGuruById(id));
    }

    @GetMapping("/get-guru-bertugas/{nikgurubertugas}")
    public boolean getGuruAktifByNik(@PathVariable("nikgurubertugas") String nikgurubertugas) throws GagalMenyimpanDataException {
        return guruServiceImpl.getGuruAktifByNik(nikgurubertugas);
    }

    @PostMapping()
    public ResponseEntity<Guru> addGuru(@RequestBody Guru guru) {
        return new ResponseEntity<>(guruServiceImpl.save(guru), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Guru> editGuru(@RequestBody Guru guru) {
        return new ResponseEntity<>(guruServiceImpl.editById(guru), HttpStatus.OK);
    }
}
