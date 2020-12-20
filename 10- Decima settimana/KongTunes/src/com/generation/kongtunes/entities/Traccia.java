package com.generation.kongtunes.entities;

import com.generation.utility.entities.Entity;

public class Traccia extends Entity
{
	// Proprietà 
	
	private String titolo;
	private double durata;
	private int idalbum;
	
	// Costruttore
	
	public Traccia() {}

	public Traccia(int id, String titolo, double durata, int idalbum) {
		super(id);
		this.titolo = titolo;
		this.durata = durata;
		this.idalbum = idalbum;
	}
	
	// Getters & setters

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public double getDurata() {
		return durata;
	}

	public void setDurata(double durata) {
		this.durata = durata;
	}

	public int getIdalbum() {
		return idalbum;
	}

	public void setIdalbum(int idalbum) {
		this.idalbum = idalbum;
	}
	
	
}
