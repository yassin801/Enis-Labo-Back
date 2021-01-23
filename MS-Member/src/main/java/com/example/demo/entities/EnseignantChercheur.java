package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("eus")
public class EnseignantChercheur extends Membre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String grade;
	
	private String etablissement;

	public EnseignantChercheur(Long id ,String nom, String prenom, String cin, Date date, String photo, String cv, String email,String password ,String grade, String etablissement) 
	{
		super(id ,nom,  prenom,  cin,  date,  photo,  cv,  email, password);
		this.grade = grade;
		this.etablissement = etablissement;
	}

	public EnseignantChercheur() {
		super();
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	
	
}
