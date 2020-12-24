package com.generation.circo.entities;

import com.generation.utility.entities.Entity;

public class Animale extends Entity
{
	// Proprietà
	
	private String nome;
	private String specie;
	private String tipo;
	private int CostoGiornaliero;
	private boolean pericoloso;
	private boolean vaccinato;
	private int idAddestratore;
	
	// Costruttori
	
	public Animale() {}

	public Animale(int id, String nome, String specie, String tipo, int costoGiornaliero, boolean pericoloso,
			boolean vaccinato, int idAddestratore) {
		super(id);
		this.nome = nome;
		this.specie = specie;
		this.tipo = tipo;
		CostoGiornaliero = costoGiornaliero;
		this.pericoloso = pericoloso;
		this.vaccinato = vaccinato;
		this.idAddestratore = idAddestratore;
	}
	
	// Getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCostoGiornaliero() {
		return CostoGiornaliero;
	}

	public void setCostoGiornaliero(int costoGiornaliero) {
		CostoGiornaliero = costoGiornaliero;
	}

	public boolean isPericoloso() {
		return pericoloso;
	}

	public void setPericoloso(boolean pericoloso) {
		this.pericoloso = pericoloso;
	}

	public boolean isVaccinato() {
		return vaccinato;
	}

	public void setVaccinato(boolean vaccinato) {
		this.vaccinato = vaccinato;
	}

	public int getIdAddestratore() {
		return idAddestratore;
	}

	public void setIdAddestratore(int idAddestratore) {
		this.idAddestratore = idAddestratore;
	}
	
	
	
	
}
