package proje.labo.business.concretes;
import proje.labo.business.abstracts.LaborantService;
import proje.labo.dao.abstracts.laborantDao;
import proje.labo.entities.concretes.Laborant;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LaborantManager implements LaborantService {

    private final laborantDao laborantDao;

    public LaborantManager(laborantDao laborantDao) {
        this.laborantDao = laborantDao;
    }

    @Override
    public void laborantEkle(Laborant laborant) {
        laborantDao.save(laborant);
    }

    @Override
    public void laborantGuncelle(Laborant laborant) {
        laborantDao.save(laborant);
    }

    @Override
    public void laborantSil(int id) {
        laborantDao.deleteById(id);
    }

    @Override
    public Laborant laborantGetirById(int id) {
        return laborantDao.findById(id).orElse(null);
    }

    @Override
    public List<Laborant> tumLaborantlariGetir() {
        return laborantDao.findAll();
    }

    @Override
    public List<Laborant> laborantAra(String ad, String soyad, String hastane_kimlik_numarasi) {
        return null;
    }
}



