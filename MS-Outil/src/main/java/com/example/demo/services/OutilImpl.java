package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entittes.Outil;

@Service
public class OutilImpl implements IOutilService {

	@Autowired
	OutilRepository outilRepository;
	
	@Override
	public Outil addOutil(Outil o) {
		return  outilRepository.save(o);
	}

	@Override
	public void deleteOutil(Long id) {
		outilRepository.deleteById(id);
		
	}

	@Override
	public Outil updateOutil(Outil o) {
		// TODO Auto-generated method stub
		return outilRepository.saveAndFlush(o);
	}

	@Override
	public Outil findOutil(Long id) {
		// TODO Auto-generated method stub
		return outilRepository.findById(id).get();
	}

	@Override
	public List<Outil> findAll() {
		// TODO Auto-generated method stub
		return outilRepository.findAll();
	}

}
