package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entittes.Outil;

@SpringBootApplication
@EnableDiscoveryClient
public class MsOutilApplication implements CommandLineRunner {
	
	@Autowired
	OutilRepository outilRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MsOutilApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Date d = new Date();
		//outilRepository.save(new Outil(null,d,"source"));
	}

}
