package com.example.guru_services.repositories;

import com.example.guru_services.entities.Guru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuruRepository extends JpaRepository<Guru, String> {
    @Query(value = "select * from guru g where g.isactive = 1", nativeQuery = true)
    List<Guru> getAllGuruAktif();

    @Query(value = "select * from guru g where g.isactive = 0", nativeQuery = true)
    List<Guru> getAllGuruTidakAktif();

    @Query(value = "select * from guru g where g.isactive = 1 and g.nikgurubertugas = ?1", nativeQuery = true)
    Optional<Guru> getGuruAktifByNik(String nikgurubertugas);
}
