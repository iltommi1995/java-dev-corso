package com.generation.scuola.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.scuola.entities.Insegnante;
import com.generation.utility.database.Database;

public class DAOInsegnanti 
{
	private Database db = Config.DB;
	
	private static DAOInsegnanti instance = null;
	private DAOInsegnanti() {};
	public static DAOInsegnanti getInstance()
	{
		if(instance == null)
			instance = new DAOInsegnanti();
		return instance;
	}
	
	// Read
	
	public List<Insegnante> read(String query)
	{
		List<Insegnante> ris = new ArrayList<Insegnante>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Insegnante i = new Insegnante();
			i.fromMap(riga);
			ris.add(i);
		}
		return ris;
	}
	
	public List<Insegnante> elenco() {
		return read("select persone.*, insegnanti.* from insegnanti inner join persone on persone.id = insegnanti.id");
	}
	
}
