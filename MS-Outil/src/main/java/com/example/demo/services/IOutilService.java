package com.example.demo.services;

import java.util.List;

import com.example.demo.entittes.Outil;

public interface IOutilService {
	public Outil addOutil(Outil o);

	public void deleteOutil(Long id);

	public Outil updateOutil(Outil o);

	public Outil findOutil(Long id);

	public List<Outil> findAll();
}
