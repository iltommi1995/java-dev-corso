package com.myproject.imdb.entities;

import java.sql.Date;
import java.util.List;

public class Regista extends Persona
{
	// PROPRIETA'
	
	private boolean oscarRegia;
	private boolean baftaRegia;
	private List<Film> filmGirati;
	
	// COSTRUTTORI
	
	public Regista() {}

	public Regista(int id, String nome, String cognome, Date dob, String nazionalita, String imgpath, boolean oscarRegia,
			boolean baftaRegia, List<Film> filmGirati) {
		super(id, nome, cognome, dob, nazionalita, imgpath);
		this.oscarRegia = oscarRegia;
		this.baftaRegia = baftaRegia;
		this.filmGirati = filmGirati;
	}
	
	// GETTERS & SETTERS

	public boolean isOscarRegia() {
		return oscarRegia;
	}

	public void setOscarRegia(boolean oscarRegia) {
		this.oscarRegia = oscarRegia;
	}

	public boolean isBaftaRegia() {
		return baftaRegia;
	}

	public void setBaftaRegia(boolean baftaRegia) {
		this.baftaRegia = baftaRegia;
	}

	public List<Film> getFilmGirati() {
		return filmGirati;
	}

	public void setFilmGirati(List<Film> filmGirati) {
		this.filmGirati = filmGirati;
	}
}
