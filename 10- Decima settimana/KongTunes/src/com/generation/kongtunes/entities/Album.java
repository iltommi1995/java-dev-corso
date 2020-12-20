package com.generation.kongtunes.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.utility.entities.Entity;

public class Album extends Entity
{
	// Proprietà
	
	private String nome;
	private String genere;
	private Date dataPubblicazione;
	private Autore autore;
	private List<Traccia> tracce;
	
	// Costruttore
	
	public Album() {}

	public Album(int id, String nome, String genere, Date dataPubblicazione, Autore autore, List<Traccia> tracce) {
		super(id);
		this.nome = nome;
		this.genere = genere;
		this.dataPubblicazione = dataPubblicazione;
		this.autore = autore;
		this.tracce = tracce;
	}
	
	// Getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public List<Traccia> getTracce() {
		return tracce;
	}

	public void setTracce(List<Traccia> tracce) {
		this.tracce = tracce;
	}
	
	// ToString
	
	public String toString() {
        String ris = "**\n";
        ris += getClass().getSimpleName() + "\n";

        Map<String, String> mappa = toMap();
        
        for(String chiave : mappa.keySet())
        {
        	if(!chiave.equalsIgnoreCase("tracce")) 
        		ris += chiave + " : " + mappa.get(chiave) + "\n";
        }
        
        ris += "Tracce: [ ";
        
        int i = 0;
        
        for(Traccia t : getTracce()) 
        {
        	i++;
        	
        	if(i == getTracce().size())
        		ris += t.getTitolo();
        	else
        		ris += t.getTitolo() + ", ";
        }  
        
        ris += " ]\n**\n";
        return ris;
    }
	
	// Ritorna true se la traccia passata come parametro compare nell’album
	
	public boolean contiene(String titolo) {
		int counter = 0;
		
		for(Traccia t : getTracce())
			counter = titolo.equalsIgnoreCase(t.getTitolo()) ? counter++ : counter;
		
		return counter == 0 ? false : true;
	};
	
	// Ritorna l’elenco delle tracce nel cui titolo compare la parola chiave passata 
	// come parametro, per fare questo metodo servitevi di IndexOf (se non sapete a cosa 
	// serve provate a cercarlo, mal che vada chiamate me)
	
	public List<Traccia> ricerca(String parola) 
	{
		List<Traccia> lista = new ArrayList<Traccia>();
		
		for(Traccia t : getTracce())
		{
			if(t.getTitolo().toLowerCase().contains(parola.toLowerCase()))
				lista.add(t);
		}
		
		return lista;
	};
}
