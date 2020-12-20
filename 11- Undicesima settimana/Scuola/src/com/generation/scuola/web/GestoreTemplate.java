package com.generation.scuola.web;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.generation.scuola.entities.Persona;
import com.generation.utility.entities.Entity;

public class GestoreTemplate 
{
	// Questa classe si occuperà di gestire la lettura dei 
	// template che sono contenuti nella cartella WebContent/Template
	
	private String percorsoCartella;
	
	public GestoreTemplate(String percorsoCartella)
	{
		this.percorsoCartella = percorsoCartella;
	}
	
	// Il metodo leggi dovrà prendere il contenuto di un file e 
	// ritornarlo sottoforma di stringa
	
	public String leggi(String nomeFile)
	{
		String ris = "";
		String percorso = percorsoCartella + "/" + nomeFile;
		try {
			Scanner s = new Scanner(new File(percorso));
			
			while(s.hasNextLine())
				ris += s.nextLine();
			s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ris = "404 - FILE NON TROVATO " + percorso;
		}
		
		return ris;
	}
	
	public String grafica(String nomeTemplate, List<? extends Entity> oggetti)
	{
		String ris = "";
		
		String templateBase = leggi(nomeTemplate);
		
		for(Entity e : oggetti)
		{
			ris += templateBase;
			
			Map<String,String> map = e.toMap();
			
			for(String k : map.keySet()) 
				ris = ris.replace("["+k+"]", map.get(k));
		}
		return ris;
	}
}
