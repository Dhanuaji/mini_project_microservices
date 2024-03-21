package com.example.siswa_services.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "siswa")
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nisn", length = 25, unique = true)
    private String nisn;

    @Column(name = "namalengkap", length = 100)
    private String namalengkap;

    @Column(name = "kelas", length = 50)
    private String kelas;

    @Column(name = "nikgurubertugas")
    private String nikgurubertugas;

    @Column(name = "isactive")
    private boolean isactive;

    public Siswa() {
    }

    public Siswa(String nisn, String namalengkap, String kelas, String nikgurubertugas, boolean isactive) {
        this.nisn = nisn;
        this.namalengkap = namalengkap;
        this.kelas = kelas;
        this.nikgurubertugas = nikgurubertugas;
        this.isactive = isactive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nik) {
        this.nisn = nik;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getnikGurubertugas() {
        return nikgurubertugas;
    }

    public void setnikGurubertugas(String nikgurubertugas) {
        this.nikgurubertugas = nikgurubertugas;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}
