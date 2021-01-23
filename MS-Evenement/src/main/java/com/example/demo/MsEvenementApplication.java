package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@SpringBootApplication
@EnableDiscoveryClient
public class MsEvenementApplication implements CommandLineRunner {

	@Autowired
	EvenementRepository evenementRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MsEvenementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date d = new Date();
		//evenementRepository.save(new Evenement(null,"titre",d,"lieu"));
	}

}
