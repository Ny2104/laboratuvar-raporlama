package proje.labo.api.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import proje.labo.business.abstracts.RaporService;
import proje.labo.entities.concretes.Rapor;

import java.util.List;

@RestController
@RequestMapping("/api/raporlar")
public class RaporlarController {

    private final RaporService raporService;

    public RaporlarController(RaporService raporService) {
        this.raporService = raporService;
    }

   

    @PostMapping("/foto-yukle")
    public String fotoYukle(@RequestParam("file") MultipartFile file) {
        return "Fotoğraf başarıyla yüklendi: " + file.getOriginalFilename();
    }

    @PostMapping("/ekle")
    public void raporEkle(@RequestBody Rapor rapor) {
        raporService.raporEkle(rapor);
    }

    @PutMapping("/guncelle")
    public void raporGuncelle(@RequestBody Rapor rapor) {
        raporService.raporGuncelle(rapor);
    }

    @DeleteMapping("/sil/{id}")
    public void raporSil(@PathVariable int id) {
        raporService.raporSil(id);
    }

    @GetMapping("/{id}")
    public Rapor raporGetirById(@PathVariable int id) {
        return raporService.raporGetirById(id);
    }

    @GetMapping("/tum")
    public List<Rapor> tumRaporlariGetir() {
        return raporService.tumRaporlariGetir();
    }

    @GetMapping("/hasta")
    public List<Rapor> raporAraByHastaAdSoyad(@RequestParam String ad, @RequestParam String soyad) {
        return raporService.raporAraByHastaAdSoyad(ad, soyad);
    }

    @GetMapping("/hasta-tc")
    public List<Rapor> raporAraByHastaTc(@RequestParam String tc) {
        return raporService.raporAraByHastaTc(tc);
    }

    @GetMapping("/laborant")
    public List<Rapor> raporAraByLaborant(@RequestParam String laborantAd, @RequestParam String laborantSoyad) {
        return raporService.raporAraByLaborant(laborantAd, laborantSoyad);
    }

    @GetMapping("/tarihe-gore-sirala")
    public List<Rapor> raporlariTariheGoreSirala() {
        return raporService.raporlariTariheGoreSirala();
    }

    @GetMapping("/arama")
    public List<Rapor> raporAra(@RequestParam(required = false) String hastaAd,
                                 @RequestParam(required = false) String hastaSoyad,
                                 @RequestParam(required = false) String hastaTc,
                                 @RequestParam(required = false) String laborantAd,
                                 @RequestParam(required = false) String laborantSoyad) {
        if (hastaAd != null && !hastaAd.isEmpty() && hastaSoyad != null && !hastaSoyad.isEmpty()) {
            return raporService.raporAraByHastaAdSoyad(hastaAd, hastaSoyad);
        } else if (hastaTc != null && !hastaTc.isEmpty()) {
            return raporService.raporAraByHastaTc(hastaTc);
        } else if (laborantAd != null && !laborantAd.isEmpty() && laborantSoyad != null && !laborantSoyad.isEmpty()) {
            return raporService.raporAraByLaborant(laborantAd, laborantSoyad);
        } else {
            return raporService.tumRaporlariGetir();
        }
    }
    
}

