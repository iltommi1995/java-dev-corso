package com.myproject.imdb.entities;

import java.util.List;
import java.util.Map;

import com.generation.utility.entities.Entity;

public class Prodotto extends Entity 
{
	// PROPRIETA' 
	
	private String titolo;
	private boolean daVedere;
	private boolean visto;
	private String imgpath;
	private List<Map<String,String>> attoriPresenti;
	private List<Genere> generi;
	
	// COSTRUTTORI
	
	public Prodotto() {}

	public Prodotto(int id, String titolo, boolean daVedere, boolean visto, String imgpath) {
		super(id);
		this.titolo = titolo;
		this.daVedere = daVedere;
		this.visto = visto;
		this.imgpath = imgpath;
	}
	
	// GETTERS & SETTERS

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public boolean isDaVedere() {
		return daVedere;
	}
	
	// Modifico setter con boolean per far sì che interpreti i valori int 1 o 0 
	// provenienti da MySQL

	public void setDaVedere(boolean daVedere) {
		this.daVedere = daVedere;
	}

	public boolean isVisto() {
		return visto;
	}
	
	// Uguale a setDaVedere

	public void setVisto(boolean visto) {
		this.visto = visto;
	}

	public List<Map<String,String>> getAttoriPresenti() {
		return attoriPresenti;
	}

	public void setAttoriPresenti(List<Map<String,String>> attoriPresenti) {
		this.attoriPresenti = attoriPresenti;
	}

	public List<Genere> getGeneri() {
		return generi;
	}

	public void setGeneri(List<Genere> generi) {
		this.generi = generi;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
}
