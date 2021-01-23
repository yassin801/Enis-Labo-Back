package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@DiscriminatorValue("etd")
public class Etudiant extends Membre {
	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	
	private String diplôme;
	
	@ManyToOne
	private EnseignantChercheur encadrant;

	public Etudiant(Long id ,String nom, String prenom, String cin, Date date, String photo, String cv, String email,String password ,Date dateInscription, String diplôme) {
		super(id ,nom,  prenom,  cin,  date,  photo,  cv,  email, password);
		this.dateInscription = dateInscription;
		this.diplôme = diplôme;
	}

	public Etudiant() {
		super();
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getDiplôme() {
		return diplôme;
	}

	public void setDiplôme(String diplôme) {
		this.diplôme = diplôme;
	}

	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}
	
	
	
}
