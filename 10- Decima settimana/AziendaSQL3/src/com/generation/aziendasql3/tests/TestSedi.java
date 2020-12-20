package com.generation.aziendasql3.tests;

import com.generation.aziendasql3.dao.Config;
import com.generation.aziendasql3.dao.DAOSedi;
import com.generation.aziendasql3.entities.Sede;

public class TestSedi {

	public static void main(String[] args) 
	{
		DAOSedi daos = Config.DS;
		
		// Metodo per stampare sedi che hanno più di n dipendenti
		//for(Sede s : daos.elencoSediORM(5))
		//	System.out.println(s);
		
		// Metodo per stampare sedi che hanno più di n dipendenti
		//for(Sede s : daos.elencoSedi("roma"))
		//	System.out.println(s);
	
		// Metodo per Stampare il tot stipendio per città selezionata
				
		//System.out.println(daos.stipendiTot("roma"));
		
		// Metodo orm per Stampare il tot stipendio per città selezionata
		
		System.out.println(daos.stipendiTotORM("roma"));
	}
}
