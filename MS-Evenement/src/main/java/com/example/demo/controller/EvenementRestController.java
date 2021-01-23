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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evenement;
import com.example.demo.services.IEvenementService;

@RestController
@CrossOrigin
public class EvenementRestController {
	@Autowired
	IEvenementService evenementService;
	
	@RequestMapping(value = "/evenements", method = RequestMethod.GET)
	public List<Evenement> findEvenement(){
		return evenementService.findAll();	
	}
	
	@GetMapping(value = "/evenements/{id}")

	public Evenement findOneEvenementById(@PathVariable Long id) {

		return evenementService.findEvenement(id);
	}
	
	@PostMapping(value = "/evenements")

	public Evenement addEvenement(@RequestBody Evenement m)

	{
		return evenementService.addEvenement(m);

	}

	@DeleteMapping(value = "/evenements/{id}")

	public void deleteEvenement(@PathVariable Long id)

	{

		evenementService.deleteEvenement(id);

	}
	
	@PutMapping(value = "/evenements/{id}")

	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement p)

	{

		p.setId(id);
		return evenementService.updateEvenement(p);

	}
}
