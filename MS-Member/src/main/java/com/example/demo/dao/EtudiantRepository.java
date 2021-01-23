package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	List<Etudiant>findByDiplôme(String diplôme);
	List<Etudiant>findByDiplômeOrderByDateInscriptionDesc(String diplôme);
	//Get students by the teacher
	List<Etudiant>findByEncadrant(EnseignantChercheur encadrant);
}
