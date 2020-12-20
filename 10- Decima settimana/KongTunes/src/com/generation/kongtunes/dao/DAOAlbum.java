package com.generation.kongtunes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.kongtunes.entities.Album;
import com.generation.kongtunes.entities.Film;
import com.generation.utility.database.Database;

public class DAOAlbum 
{
	// Proproietà 
	
	private Database db = Config.DB;
	
	private DAOTraccia dt = Config.TT;
	
	
	// Costruttore
	
	public DAOAlbum () {}
	
	// METODI CRUD
	
	// Read
	
	public List<Album> read(String query)
	{
		List<Album> ris = new ArrayList<Album>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Album a = new Album();
			a.fromMap(riga);
			a.setTracce(dt.tracceAlbum(a.getId()));
			ris.add(a);
		}
		return ris;
	}
	
	// Create
	
	public boolean create(Album a) 
	{
		String query = "insert into film " 											+
				"(nome, genere, datapubblicazione, idautore) values" 		+
				"('" + a.getNome()		+	"',"						+
				"'" + a.getGenere()	+	"',"							+
				"'" + a.getDataPubblicazione()	+	"',"								+
				a.getAutore()	+	","		+
				"'" + a.getDataPubblicazione()	+	"')";
		return db.update(query);				
	}
	
	// Update
	
	public boolean update(Album a) 
	{
		String query = 	"update album set " 	+
				"nome = '" 				+ a.getNome() + "', " +
				"genere = '" 			+ a.getGenere() + "', " +
				"datapubblicazione = '" + a.getDataPubblicazione() + "', " +
				"idautore = " 			+ a.getAutore() + ", " 	+
				" where id = "			+ a.getId()			;
		return db.update(query);
	}
	
	// Delete 
	
	public boolean delete(int id)
	{
		String query = "delete from album where id = " + id;
		
		return db.update(query);
	}
	
	// Altri metodi
	
	public List<Album> elencoAlbum(String nazionalita) 
	{
	    return read(    "select    album.* from    autori  inner join album on autori.id = album.idautore    "
	                    +" where    nazionalita = '"+ nazionalita + "'" );
	}
}
