package com.myproject.imdb.entities;

import java.sql.Date;

public class Film extends Prodotto
{
	// PROPRIETA'
	
	private int idRegista;
	private int durata;
	private Date dataUscita;
	private boolean oscar;
	
	// COSTRUTTORI
	
	public Film() {}

	public Film(int id, String titolo, boolean daVedere, boolean visto, String imgpath, int idRegista, int durata, Date dataUscita,
			boolean oscar) {
		super(id, titolo, daVedere, visto, imgpath);
		this.idRegista = idRegista;
		this.durata = durata;
		this.dataUscita = dataUscita;
		this.oscar = oscar;
	}
	
	// GETTERS & SETTERS

	public int getIdRegista() {
		return idRegista;
	}

	public void setIdRegista(int idRegista) {
		this.idRegista = idRegista;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public Date getDataUscita() {
		return dataUscita;
	}

	public void setDataUscita(Date dataUscita) {
		this.dataUscita = dataUscita;
	}

	public boolean isOscar() {
		return oscar;
	}

	public void setOscar(boolean oscar) {
		this.oscar = oscar;
	}
}
