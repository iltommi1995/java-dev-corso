package com.generation.circo.entities;

import java.sql.Date;

public class Staff extends Persona 
{
	// Proprietà
	
	private String ruolo;
	private int stipendio;
	private String giornoLibero;
	
	// Costruttori
	
	public Staff() {}

	public Staff(int id, String nome, String cognome, Date dob, String sesso, String ruolo, int stipendio,
			String giornoLibero) {
		super(id, nome, cognome, dob, sesso);
		this.ruolo = ruolo;
		this.stipendio = stipendio;
		this.giornoLibero = giornoLibero;
	}
	
	// Getters & setters

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	public String getGiornoLibero() {
		return giornoLibero;
	}

	public void setGiornoLibero(String giornoLibero) {
		this.giornoLibero = giornoLibero;
	}
	
	
}
