package com.example.siswa_services.SiswaServicesImpl;

import com.example.siswa_services.ExceptionHandler.DataTidakDitemukanException;
import com.example.siswa_services.ExceptionHandler.GuruTidakAktifatauTidakAdaException;
import com.example.siswa_services.entities.Siswa;
import com.example.siswa_services.interfaces.SiswaInterface;
import com.example.siswa_services.repositories.SiswaRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaServiceImpl implements SiswaInterface {

    private final SiswaRepository siswaRepository;
    private final WebClient webClient;

    public SiswaServiceImpl(SiswaRepository siswaRepository, WebClient webClient) {
        this.siswaRepository = siswaRepository;
        this.webClient = webClient;
    }

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Siswa entity = (Siswa) context.getBean("siswa");

    @Override
    public List<Siswa> getAllSiswa() throws DataTidakDitemukanException{
        List<Siswa> getAllSiswa = siswaRepository.findAll()
                .stream()
                .map(s -> s).toList();
        if(getAllSiswa.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getAllSiswa;
    }

    @Override
    public List<Siswa> getAllSiswaAktif() throws DataTidakDitemukanException{
        List<Siswa> getAllSiswaAktif = siswaRepository.getAllSiswaAktif()
                .stream()
                .map(s -> s)
                .toList();
        if (getAllSiswaAktif.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getAllSiswaAktif;
    }

    @Override
    public List<Siswa> getAllSiswaTidakAktif() throws DataTidakDitemukanException{
        List<Siswa> getAllSiswaTidakAktif = siswaRepository.getAllSiswaTidakAktif()
                .stream()
                .map(s -> s)
                .toList();
        if (getAllSiswaTidakAktif.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getAllSiswaTidakAktif;
    }

    @Override
    public Optional<Siswa> getSiswaById(String id) throws DataTidakDitemukanException{
        Optional<Siswa> getSiswaById = siswaRepository.findById(id);
        if (getSiswaById.isEmpty()) {
            throw new DataTidakDitemukanException();
        }
        return getSiswaById;
    }

    @Transactional
    @Override
    public Siswa save(Siswa siswa) throws GuruTidakAktifatauTidakAdaException  {
        entity = new Siswa();
        String nikgurubertugas = siswa.getnikGurubertugas();
        entity.setNisn(siswa.getNisn());
        entity.setNamalengkap(siswa.getNamalengkap());
        entity.setKelas(siswa.getKelas());
        entity.setnikGurubertugas(siswa.getnikGurubertugas());
        entity.setIsactive(true);

        boolean resultGetGuruBertugas = webClient.get()
                .uri("http://localhost:8082/guru-service/guru/get-guru-bertugas/"+nikgurubertugas)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (resultGetGuruBertugas) {
            return siswaRepository.save(entity);
        } else {
            throw new GuruTidakAktifatauTidakAdaException();
        }
    }

}
