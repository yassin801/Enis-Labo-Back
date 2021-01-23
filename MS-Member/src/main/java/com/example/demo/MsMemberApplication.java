package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.Bean.EvenementBean;
import com.example.demo.Bean.OutilBean;
import com.example.demo.Bean.PublicationBean;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxy;
import com.example.demo.proxies.PublicationProxy;
import com.example.demo.service.IMemberService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsMemberApplication implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	IMemberService memberService;
	@Autowired
	PublicationProxy publicationProxy;
	@Autowired
	EvenementProxyService evenementProxyService;
	@Autowired
	OutilProxy outilProxy;

	public static void main(String[] args) {
		SpringApplication.run(MsMemberApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Test DAO
		Date date1 = new Date();
		String photo = null;

		// Creation
		Membre etd1 = new Etudiant(null, "rebai", "yassin", "1111", date1, photo, "cv", "email", "123456789", date1,
				"diplôme");
		Membre etd2 = new Etudiant(null, "rebai", "yassmine", "2222", date1, photo, "cv", "email", "123456789", date1,
				"diplôme");
		
		Membre etd3 = new Etudiant(null, "rebai", "jalel", "1212", date1, photo, "cv", "email", "123456789", date1,
				"diplôme");
		
		Membre etd4 = new Etudiant(null, "rebai", "Amine", "2121", date1, photo, "cv", "email", "123456789", date1,
				"diplôme");

		Membre eus1 = new EnseignantChercheur(null, "rebai", "salah", "3333", date1, photo, "cv", "email", "123456789",
				"grade", "etablissement");
		Membre eus2 = new EnseignantChercheur(null, "rebai", "mohamed", "4444", date1, photo, "cv", "email",
				"123456789", "grade", "etablissement");

		//memberRepository.save(eus1);
		//memberRepository.save(eus2);

		//memberRepository.save(etd1);
		//memberRepository.save(etd2);
		//memberRepository.save(etd3);
		//memberRepository.save(etd4);

		// Show
		//memberRepository.findAll().forEach(membre -> {
			//System.out.println(membre.getPrenom() + " " + membre.getNom());
		//});

		// Find
		//Membre m1 = memberRepository.findById((long) 4).get();
		//if (m1 != null) {
		//	System.out.println(m1.getPrenom() + " " + m1.getNom());
		//} else {
		//	System.out.println("cant find member");
		//}

		// Modify
		//m1.setPrenom("ali");
		//memberRepository.save(m1);

		// Delete
		//memberRepository.deleteById(m1.getId());

		// Test service
		// Update a Member
		//Membre

		//m = memberService.findMember(1L);

		//m.setCv("cv1.pdf");
		//memberService.updateMember(m);

		// Delete a Member
		//memberService.deleteMember(2L);

		// Affecter
		//memberService.affecterEncadreantToEtudiant(3L, 1L);
		//memberService.affecterEncadreantToEtudiant(4L, 1L);
		//memberService.affecterEncadreantToEtudiant(5L, 1L);
		//memberService.affecterEncadreantToEtudiant(6L, 1L);
		
		
		
		
		//PublicationBean publication = publicationProxy.findPublicationById(1L).getContent();
		//System.out.println(publication);
		
		//memberService.affecterauteurTopublication(1L, 1L);

		//EvenementBean evenement = evenementProxyService.findEvenementById(1L).getContent();
		//System.out.println(evenement);
		
		//memberService.affecterorganisateurToEvenement(1L, 1L);
		
		//OutilBean outil = outilProxy.findOutilById(1L).getContent();
		//System.out.println(outil);
		
		//memberService.affecterUtilisateurToOutilt(1L, 1L);
		
	}

}
