package com.generation.kongtunes.entities;

import com.generation.utility.entities.Entity;

public class Autore extends Entity 
{
	// Proprietà 
	
	private String nome;
	private String nazionalita;
	
	// Costruttori
	
	public Autore() {}
	
	public Autore(int id, String nome, String nazionalita) {
		super(id);
		this.nome = nome;
		this.nazionalita = nazionalita;
	}
	
	// Getters & Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
}
