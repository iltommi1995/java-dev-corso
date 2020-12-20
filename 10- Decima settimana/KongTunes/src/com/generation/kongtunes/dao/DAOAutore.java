package com.generation.kongtunes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.kongtunes.entities.Autore;
import com.generation.kongtunes.entities.Traccia;
import com.generation.utility.database.Database;

public class DAOAutore 
{
	// Proproietà 
	
	private Database db = Config.DB;
	
	// Costruttore
	
	public DAOAutore () {}
	
	// METODI CRUD
	
	// Read
	
	public List<Autore> read(String query)
	{
		List<Autore> ris = new ArrayList<Autore>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Autore a = new Autore();
			a.fromMap(riga);
			ris.add(a);
		}
		return ris;
	}
	
	// Create
	
	public boolean create(Autore a) 
	{
		String query = "insert into autori " 					+
				"(nome, nazionalita) values" 					+
				"('" + a.getNome()		+	"',"				+
				"'" + a.getNazionalita()		+	"')"		;
		
		return db.update(query);				
	}
	
	// Update
	
	public boolean update(Autore a) 
	{
		String query = 	"update autori set " 							+
				"nome = '" 			+ 	a.getNome() 		+ 	"', " 	+
				"nazionalita = '" 	+ 	a.getNazionalita() 	+	 "'" 	+
				" where id = "		+	a.getId()						;
		return db.update(query);
	}
	
	// Delete 
	
	public boolean delete(int id)
	{
		String query = "delete from autori where id = " + id;
		
		return db.update(query);
	}
	
	// Altri metodi
	
	public Autore ricerca(int idalbum)
    {
        return  read("select    autori.* from    autori  inner join album on autori.id = album.idautore where album.id = " + idalbum).get(0);
    }
}
