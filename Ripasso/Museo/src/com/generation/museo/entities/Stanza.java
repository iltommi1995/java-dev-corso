package com.generation.museo.entities;

import com.generation.utility.entities.Entity;

public class Stanza extends Entity
{
	// Proprietà 
	
	private String nome; 
	private double larghezza;
	private double lunghezza;
	
	// Costruttori
	
	public Stanza() {}
	
	public Stanza(int id, String nome, double larghezza, double lunghezza) {
		super(id);
		this.nome = nome;
		this.larghezza = larghezza;
		this.lunghezza = lunghezza;
	}
	
	// Getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}

	public double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}
}
