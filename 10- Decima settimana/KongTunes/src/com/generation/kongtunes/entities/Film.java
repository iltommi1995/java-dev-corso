package com.generation.kongtunes.entities;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.generation.utility.entities.Entity;

public class Film extends Entity
{
	// Proprietà 
	
	private String titolo;
	private String regista;
	private String genere;
	private int durata;
	private Date dataPubblicazione;
	private List<Traccia> colonnaSonora; 
	
	// Costruttore
	
	public Film() {}

	public Film(int id, String titolo, String regista, String genere, int durata, Date dataPubblicazione,
			List<Traccia> colonnaSonora) {
		super(id);
		this.titolo = titolo;
		this.regista = regista;
		this.genere = genere;
		this.durata = durata;
		this.dataPubblicazione = dataPubblicazione;
		this.colonnaSonora = colonnaSonora;
	}
	
	// Getters & setters

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public List<Traccia> getColonnaSonora() {
		return colonnaSonora;
	}

	public void setColonnaSonora(List<Traccia> colonnaSonora) {
		this.colonnaSonora = colonnaSonora;
	}
	
	// ToString
	
	public String toString() {
        String ris = "**\n";
        ris += getClass().getSimpleName() + "\n";

        Map<String, String> mappa = toMap();
        
        for(String chiave : mappa.keySet())
        {
        	if(!chiave.equalsIgnoreCase("colonnaSonora")) 
        		ris += chiave + " : " + mappa.get(chiave) + "\n";
        }
        
        ris += "Colonna sonora: [ ";
        
        int i = 0;
        
        for(Traccia t : getColonnaSonora()) 
        {
        	i++;
        	
        	if(i == getColonnaSonora().size())
        		ris += t.getTitolo();
        	else
        		ris += t.getTitolo() + ", ";
        }  
        
        ris += " ]\n**\n";
        return ris;
    }
	
}
