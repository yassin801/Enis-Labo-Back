package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
