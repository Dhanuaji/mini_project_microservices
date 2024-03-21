package com.example.siswa_services.repositories;

import com.example.siswa_services.entities.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, String> {
    @Query(value = "select * from siswa s where s.isactive=1", nativeQuery = true)
    List<Siswa> getAllSiswaAktif();

    @Query(value = "select * from siswa s where s.isactive=0", nativeQuery = true)
    List<Siswa> getAllSiswaTidakAktif();
}
