package com.myproject.imdb.entities;

import com.generation.utility.entities.Entity;

public class Genere extends Entity
{
	// PROPRIETA'
	
	private String nome;
	
	// COSTRUTTORI
	
	public Genere() {}

	public Genere(int id, String nome) {
		super(id);
		this.nome = nome;
	}
	
	// GETTERS & SETTERS

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
