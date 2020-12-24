package com.myproject.imdb.entities;

import java.sql.Date;

import com.generation.utility.entities.Entity;

public class Persona extends Entity
{
	// PROPRIETA'
	
	private String nome;
	private String cognome;
	private Date dob;
	private String nazionalita;
	private String imgpath;
	
	// COSTRUTTORI
	
	public Persona() {}

	public Persona(int id, String nome, String cognome, Date dob, String nazionalita, String imgpath) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.nazionalita = nazionalita;
		this.imgpath = imgpath;
	}
	
	// GETTERS & SETTERS

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

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
}
