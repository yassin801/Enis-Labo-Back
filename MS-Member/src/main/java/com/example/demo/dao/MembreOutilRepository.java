package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Ids;

import feign.Param;

@Repository
public interface MembreOutilRepository extends JpaRepository<Membre_Outil, Membre_Outil_Ids> {
	@Query("select m from Membre_Outil m where utilisateur_id=:x")
	List<Membre_Outil> findOutilId(@Param ("x") Long x);
	
	@Query("select m from Membre_Outil m where outil_id=:x")
	List<Membre_Outil> findMemberId(@Param ("x") Long x);
}
