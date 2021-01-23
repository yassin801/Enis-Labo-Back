package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.Bean.EvenementBean;
import com.example.demo.Bean.OutilBean;
import com.example.demo.Bean.PublicationBean;


@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING,length = 3 )
public abstract class Membre implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private String cin;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Lob
	private String photo;

	private String cv;
	
	private String email;
	
	private String password;
	
	@Transient
	Collection<PublicationBean> pubs;
	
	@Transient
	Collection<EvenementBean> evnts;

	@Transient
	Collection<OutilBean> outils;

	/**
	 * 
	 */
	public Membre() {
		super();
	}

	public Membre(Long id ,String nom, String prenom, String cin, Date date, String photo, String cv, String email,String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.date = date;
		this.photo = photo;
		this.cv = cv;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<PublicationBean> getPubs() {
		return pubs;
	}

	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}
	

	public Collection<EvenementBean> getEvnts() {
		return evnts;
	}

	public void setEvnts(Collection<EvenementBean> evnts) {
		this.evnts = evnts;
	}

	public Collection<OutilBean> getOutils() {
		return outils;
	}

	public void setOutils(Collection<OutilBean> outils) {
		this.outils = outils;
	}
	
}
