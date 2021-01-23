package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

@Service
public class PublicationImpl implements IPublicationService {

	@Autowired
	PublicationRepository publicationRepository;
	
	public Publication addPublication(Publication m) {
		publicationRepository.save(m);
		return m;
	}

	public void deletePublication(Long id) {
		publicationRepository.deleteById(id);
		
	}

	public Publication updatePublication(Publication p) {
		publicationRepository.saveAndFlush(p);
		return p;
	}

	public Publication findPublication(Long id) {
		Publication p = publicationRepository.findById(id).get();
		return p;
	}

	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	public List<Publication> findByType(String type) {
		return publicationRepository.findByType(type);
	}

	public List<Publication> findByTitre(String titre) {
		return publicationRepository.findByTitre(titre);
	}

}
