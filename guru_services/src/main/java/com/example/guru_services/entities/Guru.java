package com.example.guru_services.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "guru")
public class Guru {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nikgurubertugas", unique = true, length = 20)
    private String nikGurubertugas;

    @Column(name = "namalengkap", length = 100)
    private String namalengkap;

    @Column(name = "isactive")
    private boolean isactive;

    public Guru() {
    }

    public Guru(String nikGurubertugas, String namalengkap, boolean isactive) {
        this.nikGurubertugas = nikGurubertugas;
        this.namalengkap = namalengkap;
        this.isactive = isactive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getnikGurubertugas() {
        return nikGurubertugas;
    }

    public void setnikGurubertugas(String nikGurubertugas) {
        this.nikGurubertugas = nikGurubertugas;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}
