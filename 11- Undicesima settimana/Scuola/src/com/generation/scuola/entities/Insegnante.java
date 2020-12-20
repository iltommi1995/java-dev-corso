package com.generation.scuola.entities;

import java.sql.Date;
import java.util.Map;

public class Insegnante extends Persona
{
	// Proproietà 
	
	private int nclassi;
	private String materia;
	
	// Costruttori
	
	public Insegnante() {}

	public Insegnante(int id, String nome, String cognome, Date dob, String residenza, int nclassi, String materia) {
		super(id, nome, cognome, dob, residenza);
		this.nclassi = nclassi;
		this.materia = materia;
	}

	// Getters & setters
	
	public int getNclassi() {
		return nclassi;
	}

	public void setNclassi(int nclassi) {
		this.nclassi = nclassi;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public String toString() {
		String ris = "";
        Map<String, String> mappa = toMap();

        //ciclo valori della mappa
        for(String chiave : mappa.keySet()) {
            ris += " " + chiave + " : " + mappa.get(chiave) + ",";
            System.out.println(chiave + " " + mappa.get(chiave));
        }
        return ris;
    }
}
