package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPublicationApplication implements CommandLineRunner {
	@Autowired
	PublicationRepository publicationRepository;
	public static void main(String[] args) {
		SpringApplication.run(MsPublicationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date d1 = new Date();
		//publicationRepository.save(new Publication(null,"type","titre","lien",d1,"pdf"));
	}

}
