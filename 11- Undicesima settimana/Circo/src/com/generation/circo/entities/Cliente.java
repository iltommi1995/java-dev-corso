package com.generation.circo.entities;

import java.sql.Date;

public class Cliente extends Persona
{
	// Proprietà 
	
	private int altezza;
	private String residenza;
	private String cittaVisita;
	private int spesa;
	
	// Costruttori
	
	public Cliente() {}

	public Cliente(int id, String nome, String cognome, Date dob, String sesso, int altezza, String residenza,
			String cittaVisita, int spesa) {
		super(id, nome, cognome, dob, sesso);
		this.altezza = altezza;
		this.residenza = residenza;
		this.cittaVisita = cittaVisita;
		this.spesa = spesa;
	}
	
	// Getters & setters

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getCittaVisita() {
		return cittaVisita;
	}

	public void setCittaVisita(String cittaVisita) {
		this.cittaVisita = cittaVisita;
	}

	public int getSpesa() {
		return spesa;
	}

	public void setSpesa(int spesa) {
		this.spesa = spesa;
	}
}
