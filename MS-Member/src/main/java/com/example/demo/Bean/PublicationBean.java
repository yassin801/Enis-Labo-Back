package com.example.demo.Bean;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class PublicationBean {
	private Long id;
	private String type;
	private String titre;
	private String lien;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String sourcepdf;
}
