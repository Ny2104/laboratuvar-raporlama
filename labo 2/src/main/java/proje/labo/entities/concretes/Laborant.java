package proje.labo.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Laborantlar")
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laborant_id")
    private int laborant_id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "hastane_kimlik_numarasi")
    private String hastane_kimlik_numarasi;

    public Laborant() {

    }

    public Laborant(String ad, String soyad, String hastane_kimlik_numarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.hastane_kimlik_numarasi = hastane_kimlik_numarasi;
    }

    public int getLaborant_id() {
        return laborant_id;
    }

    public void setLaborant_id(int laborant_id) {
        this.laborant_id = laborant_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getHastane_kimlik_numarasi() {
        return hastane_kimlik_numarasi;
    }

    public void setHastane_kimlik_numarasi(String hastane_kimlik_numarasi) {
        this.hastane_kimlik_numarasi = hastane_kimlik_numarasi;
    }
}
