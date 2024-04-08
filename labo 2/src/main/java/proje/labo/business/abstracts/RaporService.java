package proje.labo.business.abstracts;

import proje.labo.entities.concretes.Rapor;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface RaporService {

    void raporEkle(Rapor rapor);

    void raporGuncelle(Rapor rapor);

    void raporSil(int id);
    void fotoYukle(MultipartFile file, int raporId); // Dosya yükleme işlevselliği


    Rapor raporGetirById(int id);

    List<Rapor> tumRaporlariGetir();

    List<Rapor> raporAraByHastaAdSoyad(String ad, String soyad);

    List<Rapor> raporAraByHastaTc(String tc);

    List<Rapor> raporAraByLaborant(String laborantAd, String laborantSoyad);

    List<Rapor> raporlariTariheGoreSirala();

}
