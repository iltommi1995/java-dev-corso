package com.generation.kongtunes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.kongtunes.entities.Traccia;
import com.generation.utility.database.Database;

public class DAOTraccia 
{
	// Proproietà 
	
	private Database db = Config.DB;
	
	// Costruttore
	
	public DAOTraccia () {}
	
	// METODI CRUD
	
	// Read
	
	public List<Traccia> read(String query)
	{
		List<Traccia> ris = new ArrayList<Traccia>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Traccia t = new Traccia();
			t.fromMap(riga);
			ris.add(t);
		}
		return ris;
	}
	
	// Create
	
	public boolean create(Traccia t) 
	{
		String query = "insert into tracce " 					+
						"(titolo, durata, idalbum) values" 		+
						"('" + t.getTitolo()		+	"',"	+
						t.getDurata()		+	","				+
						t.getIdalbum()		+	")"				;
		
		return db.update(query);				
	}
	
	// Update
	
	public boolean update(Traccia t) 
	{
		String query = 	"update tracce set " 	+
				"titolo = '" 			+ t.getTitolo() + "', " +
				"durata = " 			+ t.getDurata() + ", " 	+
				"idalbum = " 			+ t.getIdalbum()  		+
				" where id = "			+	t.getId()			;
		return db.update(query);
	}
	
	// Delete 
	
	public boolean delete(int id)
	{
		String query = "delete from tracce where id = " + id;
		
		return db.update(query);
	}
	
	
	// Altri metodi
	
	public List<Traccia> tracceAlbum(int idalbum) 
	{
		return read("select * from tracce where idalbum = " + idalbum);
	}
	
	public List<Traccia> tracceColonnaSonora(int idfilm)
	{
		return read("select    * "
                + "from    film inner join colonnasonora on film.id = colonnasonora.idfilm " 
                + "inner join tracce on tracce.id = colonnasonora.idtraccia " 
                + "where idfilm = " + idfilm);
	}
	
	public List<Traccia> elencoTracce(String nomeArtista) 
    {
        return read("select    tracce.* from    autori  inner join album on autori.id = album.idautore inner join tracce on idalbum = album.id "
                    + "where autori.nome = '" + nomeArtista+ "'");
    }
}
