package com.example.demo.service;

import java.util.List;

import com.example.demo.Bean.EvenementBean;
import com.example.demo.Bean.OutilBean;
import com.example.demo.Bean.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Publication;

public interface IMemberService {
	// Crud sur les membres
	public Membre addMember(Membre m);

	public void deleteMember(Long id);

	public Membre updateMember(Membre p);

	public Membre findMember(Long id);

	public List<Membre> findAll();
	
	public List<EnseignantChercheur> findAllTeachers();
	
	public List<Etudiant> findAllStudents();

	// Filtrage par propriété
	public Membre findByCin(String cin);

	public Membre findByEmail(String email);

	public List<Membre> findByNom(String nom);

	// recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);

	// recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);

	public List<EnseignantChercheur> findByEtablissement(String etablissement);

	// Affecter un étudiant à un enseignant
	public void affecterEncadreantToEtudiant(Long idEtd, Long idEus);

	// Get students by the teacher
	public List<Etudiant> findByEncadrant(Long idEncadrant);

	// pub
	public Membre affecterauteurTopublication(Long idauteur, Long idpub);

	public List<PublicationBean> findPublicationparauteur(Long idauteur);

	public List<Membre> findAuteurParPublication(Long idPublication);

	public void deleteMemberPublication(Long idauteur, Long idPublication);

	public Membre_Publication updateMemberPublication(Long idauteur, Long idPublication);

	public Membre_Publication findMemberPublication(Long idauteur, Long idPublication);

	public List<Membre_Publication> findAllMemberPublication();

	// event
	public Membre affecterorganisateurToEvenement(Long idOrganisateur, Long idEvnt);

	public List<EvenementBean> findEvenementparorganisateur(Long idOrganisateur);

	public List<Membre> findOrganisateurParEvenement(Long idEvenement);

	public void deleteMemberEvent(Long idOrganisateur, Long idEvnt);

	public Membre_Evenement updateMemberEvent(Long idOrganisateur, Long idEvnt);

	public Membre_Evenement findMemberEvent(Long idOrganisateur, Long idEvnt);

	public List<Membre_Evenement> findAllMemberEvent();

	// outil
	public Membre affecterUtilisateurToOutilt(Long idUtilisateur, Long idOutil);

	public List<OutilBean> findOutilParUtilisateur(Long idUtilisateur);

	public List<Membre> findUtilisateurParOutil(Long idOutil);

	public void deleteMemberOutil(Long idUtilisateur, Long idOutil);

	public Membre_Outil updateMemberOutil(Long idUtilisateur, Long idOutil);

	public Membre_Outil findMemberOutil(Long idUtilisateur, Long idOutil);

	public List<Membre_Outil> findAllMemberOutil();

}
