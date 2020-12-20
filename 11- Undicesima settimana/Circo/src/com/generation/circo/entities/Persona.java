package com.generation.circo.entities;

import java.sql.Date;

import com.generation.utility.entities.Entity;

public abstract class Persona extends Entity
{
	// Proprietà 
	
	private String nome;
	private String cognome;
	private Date dob;
	private String sesso;
	
	// Costruttori
	
	public Persona() {}

	public Persona(int id, String nome, String cognome, Date dob, String sesso) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.sesso = sesso;
	}
	
	// Getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	
}
