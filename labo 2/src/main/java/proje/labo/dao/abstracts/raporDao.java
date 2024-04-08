package proje.labo.dao.abstracts;
import java.util.List;
import proje.labo.entities.concretes.Rapor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface raporDao extends JpaRepository<Rapor, Integer> {
    List<Rapor> findByHastaTcNumarasi(String tc);
    List<Rapor> findByLaborantAdAndLaborantSoyad(String ad, String soyad);
    List<Rapor> findByOrderByRaporunVerildigiTarihAsc();
    List<Rapor> findByHastaAdAndHastaSoyad(String ad, String soyad);

}