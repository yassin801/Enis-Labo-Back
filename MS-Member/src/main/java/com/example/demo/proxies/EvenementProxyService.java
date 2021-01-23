package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Bean.EvenementBean;

@FeignClient(value = "MS-EVENEMENT")
public interface EvenementProxyService {
	@GetMapping(value = "/evenements/{id}")
	public EntityModel<EvenementBean> findEvenementById(@PathVariable(name = "id") Long id);
	
	@GetMapping("/evenements")
	public CollectionModel<EvenementBean> findEvenements();
}
