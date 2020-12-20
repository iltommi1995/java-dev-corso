 package com.myproject.imdb.entities;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class Attore extends Persona
{
	// PROPRIETA'
	
	private boolean oscarAttore;
	private boolean baftaAttore;
	private String scuolaRecitazione;
	private List<Map<String,String>> filmRecitati;
	
	// COSTRUTTORE
	
	public Attore() {}

	public Attore(int id, String nome, String cognome, Date dob, String nazionalita, boolean oscarAttore,
			boolean baftaAttore, String scuolaRecitazione, List<Map<String,String>> filmRecitati) {
		super(id, nome, cognome, dob, nazionalita);
		this.oscarAttore = oscarAttore;
		this.baftaAttore = baftaAttore;
		this.scuolaRecitazione = scuolaRecitazione;
		this.filmRecitati = filmRecitati;
	}
	
	// GETTERS & SETTERS

	public boolean isOscarAttore() {
		return oscarAttore;
	}

	public void setOscarAttore(int oscarAttore) {
		this.oscarAttore = oscarAttore == 0 ? false : true;
	}

	public boolean isBaftaAttore() {
		return baftaAttore;
	}

	public void setBaftaAttore(int baftaAttore) {
		this.baftaAttore = baftaAttore == 0 ? false : true;
	}

	public String getScuolaRecitazione() {
		return scuolaRecitazione;
	}

	public void setScuolaRecitazione(String scuolaRecitazione) {
		this.scuolaRecitazione = scuolaRecitazione;
	}

	public List<Map<String,String>> getFilmRecitati() {
		return filmRecitati;
	}

	public void setFilmRecitati(List<Map<String,String>> filmRecitati) {
		this.filmRecitati = filmRecitati;
	}
}
