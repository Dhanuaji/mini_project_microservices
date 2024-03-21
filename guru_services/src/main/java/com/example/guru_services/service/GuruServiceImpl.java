package com.example.guru_services.service;

import com.example.guru_services.ExceptionHandler.DataTidakDitemukanException;
import com.example.guru_services.ExceptionHandler.GagalMenyimpanDataException;
import com.example.guru_services.entities.Guru;
import com.example.guru_services.interfaces.GuruInterface;
import com.example.guru_services.repositories.GuruRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GuruServiceImpl implements GuruInterface {

    private final GuruRepository guruRepository;

    public GuruServiceImpl(GuruRepository guruRepository) {
        this.guruRepository = guruRepository;
    }

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Guru entity = (Guru) context.getBean("guru");

    @Override
    public List<Guru> getAllGuru() throws DataTidakDitemukanException {
        List<Guru> getAllGuru = guruRepository.findAll()
                .stream()
                .map(g -> g)
                .toList();
        if (getAllGuru.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getAllGuru;
    }

    @Override
    public List<Guru> getAllGuruAktif() throws DataTidakDitemukanException {
        List<Guru> getAllGuruAktif = guruRepository.getAllGuruAktif()
                .stream()
                .map(g -> g)
                .toList();
        if (getAllGuruAktif.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getAllGuruAktif;
    }

    @Override
    public List<Guru> getAllGuruTidakAktif() throws DataTidakDitemukanException {
        List<Guru> getALlGuruTidakAktif = guruRepository.getAllGuruTidakAktif()
                .stream()
                .map(g -> g)
                .toList();
        if (getALlGuruTidakAktif.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getALlGuruTidakAktif;
    }

    @Override
    public Optional<Guru> getGuruById(String id) throws DataTidakDitemukanException {
        Optional<Guru> getGuruById = guruRepository.findById(id);
        if (getGuruById.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getGuruById;
    }

    @Override
    public boolean getGuruAktifByNik(String nikgurubertugas) {
        Optional<Guru> getGuru = guruRepository.getGuruAktifByNik(nikgurubertugas);
        return getGuru.isPresent();
    }

    @Transactional
    @Override
    public Guru save(Guru guru) throws GagalMenyimpanDataException {
        entity = new Guru();
        entity.setnikGurubertugas(guru.getnikGurubertugas());
        entity.setNamalengkap(guru.getNamalengkap());
        entity.setIsactive(true);
        return guruRepository.save(entity);
    }

    @Override
    public Guru editById(Guru guru) throws GagalMenyimpanDataException {
        entity = guruRepository.getById(guru.getId());
        entity.setnikGurubertugas(guru.getnikGurubertugas());
        entity.setNamalengkap(guru.getNamalengkap());
        return guruRepository.save(entity);
    }
}
