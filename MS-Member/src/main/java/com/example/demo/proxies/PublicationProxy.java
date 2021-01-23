package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Bean.PublicationBean;

@FeignClient(value = "MS-PUBLICATION")
public interface PublicationProxy {
	@GetMapping(value = "/publications/{id}")
	public EntityModel<PublicationBean> findPublicationById(@PathVariable(name = "id") Long id);
	
	@GetMapping("/publications")
	public CollectionModel<PublicationBean> findPublications();
	
}
