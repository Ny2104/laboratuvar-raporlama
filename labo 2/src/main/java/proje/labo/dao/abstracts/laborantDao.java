package proje.labo.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import proje.labo.entities.concretes.Laborant;

public interface laborantDao extends JpaRepository<Laborant,Integer> {
 
	
	
}