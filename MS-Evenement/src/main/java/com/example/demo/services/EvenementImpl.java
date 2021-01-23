package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Service
public class EvenementImpl implements IEvenementService {

	@Autowired
	EvenementRepository evenementRepository;
	
	@Override
	public Evenement addEvenement(Evenement e) {
		// TODO Auto-generated method stub
		return evenementRepository.save(e);
	}

	@Override
	public void deleteEvenement(Long id) {
		// TODO Auto-generated method stub
		evenementRepository.deleteById(id);
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		// TODO Auto-generated method stub
		return evenementRepository.saveAndFlush(e);
	}

	@Override
	public Evenement findEvenement(Long id) {
		// TODO Auto-generated method stub
		return evenementRepository.findById(id).get();
	}

	@Override
	public List<Evenement> findAll() {
		// TODO Auto-generated method stub
		return evenementRepository.findAll();
	}

}
