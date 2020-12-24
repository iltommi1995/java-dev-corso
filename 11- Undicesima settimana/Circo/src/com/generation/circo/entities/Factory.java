package com.generation.circo.entities;

import java.util.HashMap;
import java.util.Map;

import com.generation.utility.entities.Entity;


public abstract class Factory 
{
	// In questa classe introduciamo un nuovo pattern
	// La factory è un pattern che fa parte della categoria dei
	// CREAZIONALI. Un pattern creazionale è collegato direttamente 
	// alla creazione di oggetti
	
	// Il pattern factory serve a centralizzare la produzione di oggetti
	// con questo pattern faccio in modo che tutti gli oggetti del mio programma
	// vengano creati in questa classe. 
	// In questo modo posso ridurre le dipendenze
	// Ridurre le dipendenze significa fare in modo che l'ìntero mio
	// programma dipenda solo dalla factory  e che quindi qualora 
	// dovessi avere problemi in fase di creazione degli oggetti posso venire qui
	// e risolvere senza andare a zonzo per il programma.
	
	// Solitamente nella factory troviamo uno o più metodi che creano oggetti
	// questi metodi solitamente si chiamano "make" e producono oggetti
	// del tipo formale che sta più in alto nell'albero genealogico delle classi
	// nel nostro caso: entity
	
	public static Entity make(String tipo)
	{
		switch(tipo.toLowerCase())
		{
			case "animale":
				return new Animale();
			case "attrazione":
				return new Attrazione();
			case "cliente":
				return new Cliente();
			case "staff":
				return new Staff();
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
	
	public static Entity makeRequest(String tipo, Map<String,String[]> request)
	{
		Map<String,String> riga = new HashMap<String,String>();
		
		for(String name : request.keySet())
			riga.put(name, request.get(name)[0]);
		
		return make(tipo,riga);
	}
}
