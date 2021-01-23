package com.example.demo.Bean;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class EvenementBean {

	private Long id;
	private String titre;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String lieu;
}
