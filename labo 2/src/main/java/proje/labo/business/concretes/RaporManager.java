package proje.labo.business.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import proje.labo.business.abstracts.RaporService;
import proje.labo.dao.abstracts.raporDao;
import proje.labo.entities.concretes.Rapor;

import java.util.List;

@Service
public class RaporManager implements RaporService {

    private final raporDao raporDao;

    public RaporManager(raporDao raporDao) {
        this.raporDao = raporDao;
    }

    @Override
    public void raporEkle(Rapor rapor) {
        raporDao.save(rapor);
    }

    @Override
    public void raporGuncelle(Rapor rapor) {
        raporDao.save(rapor);
    }

    @Override
    public void raporSil(int id) {
        raporDao.deleteById(id);
    }

    @Override
    public Rapor raporGetirById(int id) {
        return raporDao.findById(id).orElse(null);
    }

    @Override
    public List<Rapor> tumRaporlariGetir() {
        return raporDao.findAll();
    }

    @Override
    public List<Rapor> raporAraByHastaAdSoyad(String ad, String soyad) {
        return raporDao.findByHastaAdAndHastaSoyad(ad, soyad);
    }

    @Override
    public List<Rapor> raporAraByHastaTc(String tc) {
        return raporDao.findByHastaTcNumarasi(tc);
    }

    @Override
    public List<Rapor> raporAraByLaborant(String laborantAd, String laborantSoyad) {
        return raporDao.findByLaborantAdAndLaborantSoyad(laborantAd, laborantSoyad);
    }

    @Override
    public List<Rapor> raporlariTariheGoreSirala() {
        return raporDao.findByOrderByRaporunVerildigiTarihAsc();
    }

    @Override
    public void fotoYukle(MultipartFile file, int raporNumarasi) {
    }
}


