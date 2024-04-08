package proje.labo.entities.concretes;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Raporlar")
public class Rapor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dosya_numarasi")
    
    private Integer dosyaNumarasi;
   
    @Column(name = "hasta_ad")
    private String hastaAd;

    @Column(name = "hasta_soyad")
    private String hastaSoyad;

    @Column(name = "hasta_tc")
    private String hastaTcNumarasi;

    @Column(name = "tani_basligi")
    private String koyulanTaniBasligi;

    @Column(name = "tani_detaylari", columnDefinition = "TEXT")
    private String taniDetaylari;

    @Column(name = "rapor_tarihi")
    private Date raporunVerildigiTarih;

    @Column(name = "fiziksel_rapor_fotografi")
    private String fizikselFotografAdi;

    @ManyToOne
    @JoinColumn(name = "laborant_id")
    private Laborant laborant;

    public Integer getDosyaNumarasi() {
        return dosyaNumarasi;
    }

    public void setDosyaNumarasi(Integer dosyaNumarasi) {
        this.dosyaNumarasi = dosyaNumarasi;
    }

    public String getHastaAd() {
        return hastaAd;
    }

    public void setHastaAd(String hastaAd) {
        this.hastaAd = hastaAd;
    }

    public String getHastaSoyad() {
        return hastaSoyad;
    }

    public void setHastaSoyad(String hastaSoyad) {
        this.hastaSoyad = hastaSoyad;
    }

    public String getHastaTcNumarasi() {
        return hastaTcNumarasi;
    }

    public void setHastaTcNumarasi(String hastaTcNumarasi) {
        this.hastaTcNumarasi = hastaTcNumarasi;
    }

    public String getKoyulanTaniBasligi() {
        return koyulanTaniBasligi;
    }

    public void setKoyulanTaniBasligi(String koyulanTaniBasligi) {
        this.koyulanTaniBasligi = koyulanTaniBasligi;
    }

    public String getTaniDetaylari() {
        return taniDetaylari;
    }

    public void setTaniDetaylari(String taniDetaylari) {
        this.taniDetaylari = taniDetaylari;
    }

    public Date getRaporunVerildigiTarih() {
        return raporunVerildigiTarih;
    }

    public void setRaporunVerildigiTarih(Date raporunVerildigiTarih) {
        this.raporunVerildigiTarih = raporunVerildigiTarih;
    }

    public String getFizikselFotografAdi() {
        return fizikselFotografAdi;
    }

    @Transient
    private MultipartFile fizikselFotograf;

    public Laborant getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

	public static void save(Rapor rapor) {
		// TODO Auto-generated method stub
		
	}

}
