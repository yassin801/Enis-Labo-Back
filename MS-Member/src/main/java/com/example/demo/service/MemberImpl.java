package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.EvenementBean;
import com.example.demo.Bean.OutilBean;
import com.example.demo.Bean.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.MembreEvntRepository;
import com.example.demo.dao.MembreOutilRepository;
import com.example.demo.dao.Membrepubrepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Evnt_Ids;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Ids;
import com.example.demo.entities.Membre_Pub_Ids;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxy;
import com.example.demo.proxies.PublicationProxy;

@Service
public class MemberImpl implements IMemberService {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	@Autowired
	Membrepubrepository membrepubrepository;
	@Autowired
	PublicationProxy publicationProxy;
	@Autowired
	MembreEvntRepository membreevntrepository;
	@Autowired
	EvenementProxyService evenementProxy;
	@Autowired
	MembreOutilRepository membreOutilRepository;
	@Autowired
	OutilProxy outilProxy;

	public Membre addMember(Membre m) {

		memberRepository.save(m);

		return m;

	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);

	}

	public Membre findMember(Long id) {
		Membre

		m = (Membre) memberRepository.findById(id).get();

		return m;

	}

	//
	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNom(nom);
	}

	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplôme(diplome);
	}

	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	public void affecterEncadreantToEtudiant(Long idEtd, Long idEus) {
		Etudiant etd = (Etudiant) findMember(idEtd);
		EnseignantChercheur eus = (EnseignantChercheur) findMember(idEus);

		etd.setEncadrant(eus);
		updateMember(etd);
	}
	
	public List<EnseignantChercheur> findAllTeachers() {
		return enseignantChercheurRepository.findAll();
	}
	
	public List<Etudiant> findAllStudents(){
		return etudiantRepository.findAll();
	}

	// Get students by the teacher
	@Override
	public List<Etudiant> findByEncadrant(Long idEncadrant) {
		return etudiantRepository.findByEncadrant(enseignantChercheurRepository.findById(idEncadrant).get());
	}

	/// pub-member
	public Membre affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr = memberRepository.findById(idauteur).get();
		Membre_Publication mbs = new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Ids(idpub, idauteur));
		membrepubrepository.save(mbs);
		return mbr;
	}

	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs

				= new ArrayList<PublicationBean>();

		List<Membre_Publication> idpubs

				= membrepubrepository.findpubId(idauteur);

		idpubs.forEach(s -> {
			System.out.println(s);

			pubs.add(publicationProxy.findPublicationById(

					s.getId().getPublication_id()).

					getContent());
		});
		return pubs;
	}
	
	public List<Membre> findAuteurParPublication(Long idPublication){
		List<Membre> auteurs

				= new ArrayList<Membre>();

		List<Membre_Publication> idauteurs

				= membrepubrepository.findAuteurId(idPublication);

		idauteurs.forEach(s -> {
			auteurs.add(memberRepository.findById(s.getId().getAuteur_id()).get()

					);
		});
		return auteurs;
	}
	

	public void deleteMemberPublication(Long idauteur, Long idPublication) {
		membrepubrepository.deleteById(new Membre_Pub_Ids(idPublication, idauteur));
	}

	public Membre_Publication updateMemberPublication(Long idauteur, Long idPublication) {
		return membrepubrepository.saveAndFlush(membrepubrepository.getOne(new Membre_Pub_Ids(idPublication, idauteur)));
	}

	public Membre_Publication findMemberPublication(Long idauteur, Long idPublication) {
		return membrepubrepository.findById(new Membre_Pub_Ids(idPublication, idauteur)).get();
	}

	public List<Membre_Publication> findAllMemberPublication(){
		return membrepubrepository.findAll();
	}


	//// member-event
	@Override
	public Membre affecterorganisateurToEvenement(Long idOrganisateur, Long idEvnt) {
		Membre mbr = memberRepository.findById(idOrganisateur).get();
		Membre_Evenement mbs = new Membre_Evenement();
		mbs.setOrganisateur(mbr);
		;
		mbs.setId(new Membre_Evnt_Ids(idEvnt, idOrganisateur));
		membreevntrepository.save(mbs);
		return mbr;
	}
	
	
 
	@Override
	public List<EvenementBean> findEvenementparorganisateur(Long idOrganisateur) {
		List<EvenementBean> events

				= new ArrayList<EvenementBean>();

		List<Membre_Evenement> idevents

				= membreevntrepository.findEvntId(idOrganisateur);

		idevents.forEach(s -> {
			System.out.println(s);

			events.add(evenementProxy.findEvenementById(

					s.getId().getEvenement_id()).

					getContent());
		});
		return events;
	}

	public List<Membre> findOrganisateurParEvenement(Long idEvenement) {
		List<Membre> orgas

				= new ArrayList<Membre>();

		List<Membre_Evenement> idorgas

				= membreevntrepository.findOrganisateurId(idEvenement);

		idorgas.forEach(s -> {
			orgas.add(memberRepository.findById(s.getId().getOrganisateur_id()).get()

					);
		});
		return orgas;
	}
	

	public void deleteMemberEvent(Long idOrganisateur, Long idEvnt) {
		membreevntrepository.deleteById(new Membre_Evnt_Ids(idEvnt, idOrganisateur));
	}

	public Membre_Evenement updateMemberEvent(Long idOrganisateur, Long idEvnt) {
		return membreevntrepository.saveAndFlush(membreevntrepository.getOne(new Membre_Evnt_Ids(idEvnt, idOrganisateur)));
	}

	public Membre_Evenement findMemberEvent(Long idOrganisateur, Long idEvnt) {
		return membreevntrepository.findById(new Membre_Evnt_Ids(idEvnt, idOrganisateur)).get();
	}

	public List<Membre_Evenement> findAllMemberEvent(){
		return membreevntrepository.findAll();
	}


	// outil-member
	@Override
	public Membre affecterUtilisateurToOutilt(Long idUtilisateur, Long idOutil) {
		Membre mbr = memberRepository.findById(idUtilisateur).get();
		Membre_Outil mbs = new Membre_Outil();
		mbs.setUtilisateur(mbr);
		mbs.setId(new Membre_Outil_Ids(idOutil, idUtilisateur));
		membreOutilRepository.save(mbs);
		return mbr;
	}

	@Override
	public List<OutilBean> findOutilParUtilisateur(Long idUtilisateur) {
		List<OutilBean> outils

				= new ArrayList<OutilBean>();

		List<Membre_Outil> idoutils

				= membreOutilRepository.findOutilId(idUtilisateur);

		idoutils.forEach(s -> {
			System.out.println(s);

			outils.add(outilProxy.findOutilById(

					s.getId().getOutil_id()).

					getContent());
		});
		return outils;
	}
	
	public List<Membre> findUtilisateurParOutil(Long idOutil) {
		List<Membre> users

				= new ArrayList<Membre>();

		List<Membre_Outil> idusers

				= membreOutilRepository.findMemberId(idOutil);

		idusers.forEach(s -> {
			users.add(memberRepository.findById(s.getId().getUtilisateur_id()).get()

					);
		});
		return users;
	}
	

	public void deleteMemberOutil(Long idUtilisateur, Long idOutil) {
		membreOutilRepository.deleteById(new Membre_Outil_Ids(idOutil, idUtilisateur));
	}

	public Membre_Outil updateMemberOutil(Long idUtilisateur, Long idOutil) {
		return membreOutilRepository.saveAndFlush(membreOutilRepository.getOne(new Membre_Outil_Ids(idOutil, idUtilisateur)));
	}

	public Membre_Outil findMemberOutil(Long idUtilisateur, Long idOutil) {
		return membreOutilRepository.findById(new Membre_Outil_Ids(idOutil, idUtilisateur)).get();
	}

	public List<Membre_Outil> findAllMemberOutil(){
		return membreOutilRepository.findAll();
	}


}
