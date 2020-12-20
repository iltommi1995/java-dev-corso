package com.generation.scuola.entities;

import java.sql.Date;
import java.util.Map;

public class Studente extends Persona
{
	// Proprietà 
	
	 private int classe;
	 private String sezione;
	 private int votoIta;
	 private int votoMat;
	 private int votoIng;
	 private int votoSto;
	 
	 // Costruttori
	 
	 public Studente() {}

	 public Studente(int id, String nome, String cognome, Date dob, String residenza, int classe, String sezione, int votoIta, int votoMat, int votoIng, int votoSto) {
		super(id, nome, cognome, dob, residenza);
		this.classe = classe;
		this.sezione = sezione;
		this.votoIta = votoIta;
		this.votoMat = votoMat;
		this.votoIng = votoIng;
		this.votoSto = votoSto;
	}
	 
	
	 // Getters & setters

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public int getVotoIta() {
		return votoIta;
	}

	public void setVotoIta(int votoIta) {
		this.votoIta = votoIta;
	}

	public int getVotoMat() {
		return votoMat;
	}

	public void setVotoMat(int votoMat) {
		this.votoMat = votoMat;
	}

	public int getVotoIng() {
		return votoIng;
	}

	public void setVotoIng(int votoIng) {
		this.votoIng = votoIng;
	}

	public int getVotoSto() {
		return votoSto;
	}

	public void setVotoSto(int votoSto) {
		this.votoSto = votoSto;
	}
	
	
	// Altri metodi
	
	public double media() {
		return (votoIta + votoMat + votoSto + votoIng) / 4;
	}
	
	public boolean promosso() {
		boolean b = true;
		int count = 0;
		if(votoIta < 3 || votoMat < 3 || votoSto < 3 || votoIng < 3)
			b = false;
		
		count = votoIta >= 6 ? count++ : count;
		count = votoMat >= 6 ? count++ : count;
		count = votoSto >= 6 ? count++ : count;
		count = votoIng >= 6 ? count++ : count;
		
		b = count >= 2 ? false : true;
		
		return b;
	}
	
	
	public String toString() {
		String ris = "";
        Map<String, String> mappa = toMap();

        //ciclo valori della mappa
        for(String chiave : mappa.keySet())
            ris += " " + chiave + " : " + mappa.get(chiave) + ",";


        return ris;
    }

}
