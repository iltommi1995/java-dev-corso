package com.generation.kongtunes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.kongtunes.entities.Film;
import com.generation.kongtunes.entities.Traccia;
import com.generation.utility.database.Database;

public class DAOFilm 
{
	// Proproietà 
	
		private Database db = Config.DB;
		
		private DAOTraccia dt = Config.TT;
		
		
		// Costruttore
		
		public DAOFilm () {}
		
		// METODI CRUD
		
		// Read
		
		public List<Film> read(String query)
		{
			List<Film> ris = new ArrayList<Film>();
			
			List<Map<String,String>> tabella = db.rows(query);
			
			for(Map<String,String> riga : tabella)
			{
				Film f = new Film();
				f.fromMap(riga);
				f.setColonnaSonora(dt.tracceColonnaSonora(f.getId()));
				ris.add(f);
			}
			return ris;
		}
		
		// Create
		
		public boolean create(Film f) 
		{
			String query = "insert into film " 					+
							"(titolo, regista, genere, durata, datapubblicazione) values" 		+
							"('" + f.getTitolo()		+	"',"	+
							"'" + f.getRegista()	+	"',"		+
							"'" + f.getGenere()	+	"',"		+
							f.getDurata()	+	","		+
							"'" + f.getDataPubblicazione()	+	"')";
			
			return db.update(query);				
		}
		
		// Update
		
		public boolean update(Film f) 
		{
			String query = 	"update film set " 	+
					"titolo = '" 			+ f.getTitolo() + "', " +
					"regista = '" 			+ f.getRegista() + "', " +
					"genere = '" 			+ f.getGenere() + "', " +
					"durata = " 			+ f.getDurata() + ", " 	+
					"datapubblicazione = '" + f.getDataPubblicazione() + "', " +
					" where id = "			+ f.getId()			;
			return db.update(query);
		}
		
		// Delete 
		
		public boolean delete(int id)
		{
			String query = "delete from film where id = " + id;
			
			return db.update(query);
		}
}
