package com.myproject.imdb.entities;

import java.util.Map;

import com.generation.utility.entities.Entity;

public class Factory 
{
	public static Entity make(String tipo)
	{
		switch(tipo.toLowerCase())
		{
			case "attore":
				return new Attore();
			case "film":
				return new Film();
			case "genere":
				return new Genere();
			case "persona":
				return new Persona();
			case "prodotto":
				return new Prodotto();
			case "regista":
				return new Regista();
			case "serietv":
				return new SerieTv();
			default:
				return null;
		}
	}
	
	public static Entity make(String tipo, Map<String,String> riga)
	{
		Entity ris = make(tipo);
		ris.fromMap(riga);
		return ris;
	}
}
