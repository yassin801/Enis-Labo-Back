package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.EvenementBean;
import com.example.demo.Bean.OutilBean;
import com.example.demo.Bean.PublicationBean;
import com.example.demo.entities.*;
import com.example.demo.service.IMemberService;

@RestController
@CrossOrigin(origins = "http://localhost:9999/", maxAge = 3600)
public class MemberRestController {
	@Autowired
	IMemberService memberService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Membre> findMembres() {
		return memberService.findAll();
	}

	@RequestMapping(value = "/membres/teachers", method = RequestMethod.GET)
	public List<EnseignantChercheur> getAllTeachers() {
		return memberService.findAllTeachers();
	}

	@RequestMapping(value = "/membres/students", method = RequestMethod.GET)
	public List<Etudiant> getAllStudents() {
		return memberService.findAllStudents();
	}

	@GetMapping(value = "/membre/{id}")

	public Membre findOneMemberById(@PathVariable Long id) {

		return memberService.findMember(id);
	}

	@GetMapping(value = "/membre/search/cin/{cin}")

	public Membre findOneMemberByCin(@PathVariable String cin)

	{
		return memberService.findByCin(cin);
	}

	@GetMapping(value = "/membre/search/email/{email}")

	public Membre findOneMemberByEmail(@PathVariable String email)

	{
		return memberService.findByEmail(email);
	}

	@GetMapping(value = "/membre/search/nom")

	public List<Membre> findOneMemberByNom(@RequestParam String nom)

	{
		return memberService.findByNom(nom);
	}

	@PostMapping(value = "/membres/etudiant")

	public Membre addMembre(@RequestBody Etudiant e)

	{
		return memberService.addMember(e);

	}


	@PostMapping(value = "/membres/enseignant")

	public Membre addMembre(@RequestBody EnseignantChercheur m)

	{
		return memberService.addMember(m);

	}

	@DeleteMapping(value = "/membres/{id}")

	public void deleteMembre(@PathVariable Long id)

	{
		int taille = 0;
		try {
			List<Etudiant> students = memberService.findByEncadrant(id);
			taille = students.size();
		} catch (Exception e) {
			// TODO: handle exception
		}


		if (taille == 0) {
			
			try {

				List<EvenementBean> events = memberService.findEvenementparorganisateur(id);
				if (events.size() != 0 && events != null) {
					for (EvenementBean event : events) {
						memberService.deleteMemberEvent(id, event.getId());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {

				List<PublicationBean> pubs = memberService.findPublicationparauteur(id);
				if (pubs.size() != 0 && pubs != null) {
					for (PublicationBean pub : pubs) {
						memberService.deleteMemberPublication(id, pub.getId());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				List<OutilBean> outils = memberService.findOutilParUtilisateur(id);

				if (outils.size() != 0 && outils != null) {
					for (OutilBean outil : outils) {
						memberService.deleteMemberOutil(id, outil.getId());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}


			memberService.deleteMember(id);

		}

	}

	@PutMapping(value = "/membres/etudiant/{id}")

	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p)

	{

		p.setId(id);
		return memberService.updateMember(p);

	}

	@PutMapping(value = "/membres/enseignant/{id}")

	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)

	{

		p.setId(id);
		return memberService.updateMember(p);

	}

	@PutMapping(value = "/membres/enseignant/affect/{idetd}/{idens}")

	public Membre affecterEncadrantToEtudiant(@PathVariable Long idetd, @PathVariable Long idens)

	{

		memberService.affecterEncadreantToEtudiant(idetd, idens);
		return findOneMemberById(idetd);
	}

	@GetMapping(value = "/membre/studentbyteacher/{id}")

	public List<Etudiant> findByEncadrant(@PathVariable Long id)

	{
		return memberService.findByEncadrant(id);
	}

	@GetMapping("/fullmember/{id}")

	public Membre findAFullMember(@PathVariable(name = "id") Long id)

	{
		Membre mbr = null;
		
		try {

			mbr = memberService.findMember(id);

			mbr.setPubs(memberService.findPublicationparauteur(id));

			mbr.setEvnts(memberService.findEvenementparorganisateur(id));

			mbr.setOutils(memberService.findOutilParUtilisateur(id));
			
		} catch (Exception e) {
			// TODO: handle exception
		}


		return mbr;
	}

	//
	// members-events
	//

	@PostMapping(value = "/member/event/add")

	public Membre addMembreToEvent(@RequestBody Membre_Evnt_Ids ids)

	{
		return memberService.affecterorganisateurToEvenement(ids.getOrganisateur_id(), ids.getEvenement_id());

	}

	@GetMapping("/member/event/getOrgs/{idEvent}")

	public List<Membre> findOrganisateurParEvenement(@PathVariable(name = "idEvent") Long idEvent)

	{
		return memberService.findOrganisateurParEvenement(idEvent);
	}

	@GetMapping("/member/event/getEvent/{idOrganisateur}")

	public List<EvenementBean> findEvenementparorganisateur(@PathVariable(name = "idOrganisateur") Long idOrganisateur)

	{
		return memberService.findEvenementparorganisateur(idOrganisateur);
	}

	@RequestMapping(value = "/member/event/all", method = RequestMethod.GET)
	public List<Membre_Evenement> getAllMembreEvent() {
		return memberService.findAllMemberEvent();
	}

	@GetMapping(value = "/member/event/getone/{idOrganisateur}/{idEvnt}")

	public Membre_Evenement findOneMembreEventById(@PathVariable Long idOrganisateur, @PathVariable Long idEvnt) {

		return memberService.findMemberEvent(idOrganisateur, idEvnt);
	}

	@DeleteMapping(value = "/member/event/{idOrganisateur}/{idEvnt}")

	public void deleteMembreEvent(@PathVariable Long idOrganisateur, @PathVariable Long idEvnt)

	{

		memberService.deleteMemberEvent(idOrganisateur, idEvnt);

	}

	@PutMapping(value = "/member/event/{idOrganisateur}/{idEvnt}")

	public Membre_Evenement updateMembreEvent(@PathVariable Long idOrganisateur, @PathVariable Long idEvnt)

	{
		return memberService.updateMemberEvent(idOrganisateur, idEvnt);
	}

	@DeleteMapping(value = "/member/event/delete/{idEvnt}")

	public void deleteMembreEventOfEvent(@PathVariable Long idEvnt)

	{

		List<Membre> mbrs = memberService.findOrganisateurParEvenement(idEvnt);

		if (mbrs.size() != 0 && mbrs != null) {
			for (Membre mbr : mbrs) {
				memberService.deleteMemberEvent(mbr.getId(), idEvnt);
			}
		}

	}

	//
	// members-publications
	//

	@PostMapping(value = "/member/publication/add")

	public Membre addMembreToPublication(@RequestBody Membre_Pub_Ids ids)

	{
		return memberService.affecterauteurTopublication(ids.getAuteur_id(), ids.getPublication_id());

	}

	@GetMapping("/member/publication/getAuteurs/{idPublication}")

	public List<Membre> findAuteurParPublication(@PathVariable(name = "idPublication") Long idPublication)

	{
		return memberService.findAuteurParPublication(idPublication);
	}

	@GetMapping("/member/publication/getPublication/{idAuteur}")

	public List<PublicationBean> findPublicationParAuteur(@PathVariable(name = "idAuteur") Long idAuteur)

	{
		return memberService.findPublicationparauteur(idAuteur);
	}

	@RequestMapping(value = "/member/publication/all", method = RequestMethod.GET)
	public List<Membre_Publication> getAllMembrePublication() {
		return memberService.findAllMemberPublication();
	}

	@GetMapping(value = "/member/publication/getone/{idAuteur}/{idPublication}")

	public Membre_Publication findOneMembrePublicationById(@PathVariable Long idAuteur,
			@PathVariable Long idPublication) {

		return memberService.findMemberPublication(idAuteur, idPublication);
	}

	@DeleteMapping(value = "/member/publication/{idAuteur}/{idPublication}")

	public void deleteMembrePublication(@PathVariable Long idAuteur, @PathVariable Long idPublication)

	{

		memberService.deleteMemberPublication(idAuteur, idPublication);

	}

	@PutMapping(value = "/member/publication/{idAuteur}/{idPublication}")

	public Membre_Publication updateMembrePublication(@PathVariable Long idAuteur, @PathVariable Long idPublication)

	{
		return memberService.updateMemberPublication(idAuteur, idPublication);
	}

	@DeleteMapping(value = "/member/publication/delete/{idPublication}")

	public void deleteMembrePublicationOfPublication(@PathVariable Long idPublication)

	{

		List<Membre> mbrs = memberService.findAuteurParPublication(idPublication);

		if (mbrs.size() != 0 && mbrs != null) {
			for (Membre mbr : mbrs) {
				memberService.deleteMemberPublication(mbr.getId(), idPublication);
			}
		}

	}

	//
	// Member-Outil
	//

	@PostMapping(value = "/member/outil/add")

	public Membre addMembreToOutil(@RequestBody Membre_Outil_Ids ids)

	{
		return memberService.affecterUtilisateurToOutilt(ids.getUtilisateur_id(), ids.getOutil_id());

	}

	@GetMapping("/member/outil/getUtilisateur/{idOutil}")

	public List<Membre> findUtilisateurParOutil(@PathVariable(name = "idOutil") Long idOutil)

	{
		return memberService.findUtilisateurParOutil(idOutil);
	}

	@GetMapping("/member/outil/getOutil/{idUtilisateur}")

	public List<OutilBean> findOutilParUtilisateur(@PathVariable(name = "idUtilisateur") Long idUtilisateur)

	{
		return memberService.findOutilParUtilisateur(idUtilisateur);
	}

	@RequestMapping(value = "/member/outil/all", method = RequestMethod.GET)
	public List<Membre_Outil> getAllMembreOutil() {
		return memberService.findAllMemberOutil();
	}

	@GetMapping(value = "/member/outil/getone/{idUtilisateur}/{idOutil}")

	public Membre_Outil findOneMembreOutilById(@PathVariable Long idUtilisateur, @PathVariable Long idOutil) {

		return memberService.findMemberOutil(idUtilisateur, idOutil);
	}

	@DeleteMapping(value = "/member/outil/{idUtilisateur}/{idOutil}")

	public void deleteMembreOutil(@PathVariable Long idUtilisateur, @PathVariable Long idOutil)

	{

		memberService.deleteMemberOutil(idUtilisateur, idOutil);

	}

	@PutMapping(value = "/member/outil/{idUtilisateur}/{idOutil}")

	public Membre_Outil updateMembreOutil(@PathVariable Long idUtilisateur, @PathVariable Long idOutil)

	{
		return memberService.updateMemberOutil(idUtilisateur, idOutil);
	}

	@DeleteMapping(value = "/member/outil/delete/{idOutil}")

	public void deleteMembreOutilOfOutil(@PathVariable Long idOutil)

	{

		List<Membre> mbrs = memberService.findUtilisateurParOutil(idOutil);

		if (mbrs.size() != 0 && mbrs != null) {
			for (Membre mbr : mbrs) {
				memberService.deleteMemberOutil(mbr.getId(), idOutil);
			}
		}

	}
}