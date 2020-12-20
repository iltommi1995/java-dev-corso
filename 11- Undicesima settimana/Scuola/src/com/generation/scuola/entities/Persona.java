package com.generation.scuola.entities;

import java.sql.Date;
import java.util.Map;

import com.generation.utility.entities.Entity;

public class Persona extends Entity {

	private String nome;
	private String cognome;
	private Date dob;
	private String residenza;
	
	public Persona() {}

	public Persona(int id, String nome, String cognome, Date dob, String residenza) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.residenza = residenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	
	public String toString() {
		String ris = "";
        Map<String, String> mappa = toMap();

        //ciclo valori della mappa
        for(String chiave : mappa.keySet())
            ris += chiave + " : " + mappa.get(chiave) + ", ";


        return ris;
    }
	
}
