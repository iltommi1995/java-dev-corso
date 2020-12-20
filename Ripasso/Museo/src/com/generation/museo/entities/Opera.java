package com.generation.museo.entities;

import com.generation.utility.entities.Entity;

public abstract class Opera extends Entity
{
	// Proprietà
	
	private String nome;
	private String autore; 
	private int secolo;
	
	// Costruttori
	
	public Opera() {}

	public Opera(int id, String nome, String autore, int secolo) {
		super(id);
		this.nome = nome;
		this.autore = autore;
		this.secolo = secolo;
	}
	
	// Getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getSecolo() {
		return secolo;
	}

	public void setSecolo(int secolo) {
		this.secolo = secolo;
	}
}
