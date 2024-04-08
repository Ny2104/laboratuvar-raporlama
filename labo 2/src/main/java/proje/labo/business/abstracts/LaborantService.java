package proje.labo.business.abstracts;

import proje.labo.entities.concretes.Laborant;

import java.util.List;

public interface LaborantService {

    void laborantEkle(Laborant laborant);

    void laborantGuncelle(Laborant laborant);

    void laborantSil(int id);

    Laborant laborantGetirById(int id);

    List<Laborant> tumLaborantlariGetir();

    List<Laborant> laborantAra(String ad, String soyad, String hastane_kimlik_numarasi);
}
