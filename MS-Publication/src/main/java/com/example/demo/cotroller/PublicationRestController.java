package com.example.demo.cotroller;

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

import com.example.demo.entities.Publication;
import com.example.demo.services.IPublicationService;

@RestController
@CrossOrigin
public class PublicationRestController {
	@Autowired
	IPublicationService publicationService;
	
	@RequestMapping(value = "/publications", method = RequestMethod.GET)
	public List<Publication> findPublication(){
		return publicationService.findAll();	
	}
	
	@GetMapping(value = "/publications/{id}")

	public Publication findOnePublicationById(@PathVariable Long id) {

		return publicationService.findPublication(id);
	}
	
	@PostMapping(value = "/publications")

	public Publication addPublication(@RequestBody Publication m)

	{
		return publicationService.addPublication(m);

	}

	@DeleteMapping(value = "/publications/{id}")

	public void deletePublication(@PathVariable Long id)

	{

		publicationService.deletePublication(id);

	}
	
	@PutMapping(value = "/publications/{id}")

	public Publication updatePublication(@PathVariable Long id, @RequestBody Publication p)

	{

		p.setId(id);
		return publicationService.updatePublication(p);

	}
}
