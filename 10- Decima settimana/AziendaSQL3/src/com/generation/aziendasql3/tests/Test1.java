package com.generation.aziendasql3.tests;

import java.sql.Date;

import com.generation.aziendasql3.dao.DAODipendenti;
import com.generation.aziendasql3.entities.Dipendente;

public class Test1 {

	public static void main(String[] args)
	{
		// Creo un dipendente su Java
		
		Dipendente d = new Dipendente(0, "Magico", 
										Date.valueOf("2000-3-1"),
										"M",
										"Bergamo",
										1890,
										1
										);
		
		// Provo a salvarlo sul database
		
		DAODipendenti dd = new DAODipendenti();
		//dd.create(d);
		
		// Stampo la lista di dipendenti e verifico se quello nuovo è presente
		
		for(Dipendente dip : dd.elenco())
			System.out.println(dip);
	}
}
