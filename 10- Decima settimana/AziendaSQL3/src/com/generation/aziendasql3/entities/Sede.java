package com.generation.aziendasql3.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.utility.entities.Entity;

public class Sede extends Entity
{
	private String citta;
	private String indirizzo;
	private int mq;
	private List<Dipendente> dipendenti;
	
	public Sede() {}

	public Sede(int id, String citta, String indirizzo, int mq, List<Dipendente> dipendenti) {
		super(id);
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.mq = mq;
		this.dipendenti = dipendenti;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getMq() {
		return mq;
	}

	public void setMq(int mq) {
		this.mq = mq;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	public String toString() 
	{
		String ris = "******************\n";
		
		ris += getClass().getSimpleName() + "\n";
		
		Map<String,String> mappa = toMap();
		
		for(String chiave : mappa.keySet()) 
			if(chiave.equalsIgnoreCase("dipendenti"))
			{
				String[] lista = mappa.get(chiave).split("stipendio");
				ris += chiave + " : " + (lista.length - 1) + " dipendenti\n";
			}
			else {
				ris += chiave + " : " + mappa.get(chiave) + "\n";
			}
		
		ris += "******************\n";
		
		return ris;
	}
}
