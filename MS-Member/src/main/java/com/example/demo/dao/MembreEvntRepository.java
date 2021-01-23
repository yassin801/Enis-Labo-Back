package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Evnt_Ids;

import feign.Param;

@Repository
public interface MembreEvntRepository extends JpaRepository<Membre_Evenement, Membre_Evnt_Ids> {
	@Query("select m from Membre_Evenement m where organisateur_id=:x")
	List<Membre_Evenement> findEvntId(@Param ("x") Long x);
	
	@Query("select m from Membre_Evenement m where evenement_id=:x")
	List<Membre_Evenement> findOrganisateurId(@Param ("x") Long x);
}
