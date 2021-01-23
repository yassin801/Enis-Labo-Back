package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>{
	
	List<Publication>findByType(String type);
	
	List<Publication>findByTitre(String titre);
}
