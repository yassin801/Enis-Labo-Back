package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Bean.OutilBean;

@FeignClient(value = "MS-OUTIL")
public interface OutilProxy {
	@GetMapping(value = "/outils/{id}")
	public EntityModel<OutilBean> findOutilById(@PathVariable(name = "id") Long id);
	
	@GetMapping("/outils")
	public CollectionModel<OutilBean> findOutils();
}
