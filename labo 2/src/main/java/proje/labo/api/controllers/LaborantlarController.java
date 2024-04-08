package proje.labo.api.controllers;

import org.springframework.web.bind.annotation.*;
import proje.labo.business.abstracts.LaborantService;
import proje.labo.entities.concretes.Laborant;

import java.util.List;

@RestController
@RequestMapping("/api/laborantlar")
public class LaborantlarController {

    private final LaborantService laborantService;

    public LaborantlarController(LaborantService laborantService) {
        this.laborantService = laborantService;
    }

    @PostMapping("/ekle")
    public void laborantEkle(@RequestBody Laborant laborant) {
        laborantService.laborantEkle(laborant);
    }

    @PutMapping("/guncelle")
    public void laborantGuncelle(@RequestBody Laborant laborant) {
        laborantService.laborantGuncelle(laborant);
    }

    @DeleteMapping("/sil/{id}")
    public void laborantSil(@PathVariable int id) {
        laborantService.laborantSil(id);
    }

    @GetMapping("/{id}")
    public Laborant laborantGetirById(@PathVariable int id) {
        return laborantService.laborantGetirById(id);
    }

    @GetMapping("/tum")
    public List<Laborant> tumLaborantlariGetir() {
        return laborantService.tumLaborantlariGetir();
    }

    @GetMapping("/ara")
    public List<Laborant> laborantAra(@RequestParam String ad, @RequestParam String soyad, @RequestParam String hastane_kimlik_numarasi) {
        return laborantService.laborantAra(ad, soyad, hastane_kimlik_numarasi);
    }
}
