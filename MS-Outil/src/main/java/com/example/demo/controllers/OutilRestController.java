package com.example.demo.controllers;

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

import com.example.demo.entittes.Outil;
import com.example.demo.services.IOutilService;

@RestController
@CrossOrigin
public class OutilRestController {
	
	@Autowired
	IOutilService outilService;
	
	@RequestMapping(value = "/outils", method = RequestMethod.GET)
	public List<Outil> findPublication(){
		return outilService.findAll();	
	}
	
	@GetMapping(value = "/outils/{id}")

	public Outil findOneOutilById(@PathVariable Long id) {

		return outilService.findOutil(id);
	}
	
	@PostMapping(value = "/outils")

	public Outil addPublication(@RequestBody Outil m)

	{
		return outilService.addOutil(m);

	}

	@DeleteMapping(value = "/outils/{id}")

	public void deletePublication(@PathVariable Long id)

	{

		outilService.deleteOutil(id);

	}
	
	@PutMapping(value = "/outils/{id}")

	public Outil updatePublication(@PathVariable Long id, @RequestBody Outil p)

	{

		p.setId(id);
		return outilService.updateOutil(p);

	}
}
