package com.myproject.imdb.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;
import com.myproject.imdb.entities.Attore;
import com.myproject.imdb.entities.Factory;
import com.myproject.imdb.entities.Prodotto;

public class DAOAttore implements IDAO
{
	// Proprietà 
	
	private Database db = Config.DB;
	
	// Pattern singleton
	
	private static DAOAttore instance = null;
	private DAOAttore() {}
	
	public static DAOAttore getInstance()
	{
		if(instance == null)
			instance = new DAOAttore();
		return instance;
	}
	
	// Metodi CRUD
	
	@Override
	public boolean create(Entity e) 
	{
		String query1 = "insert into persone(nome, cognome, dob, nazionalita) values(?,?,?,?)";
		String query2 = "insert into attori(id,oscarAttore, baftaAttore, scuolaRecitazione) values((select max(id) from persone),?,?,?)";
		Attore a = (Attore) e;
		return 
			db.update(query1, a.getNome(), a.getCognome(), a.getDob()+"", a.getNazionalita())
			&&
			db.update(query2, a.isOscarAttore() == true ? 1+"" : 0+"", a.isBaftaAttore() == true ? 1+"" : 0+"", a.getScuolaRecitazione());
	}

	@Override
	public boolean delete(int id) 
	{
		String query1 = "delete from attori where id = ?";
		String query2 = "delete from persone where id = ?";
		return 
			db.update(query1, id+"")
			&&
			db.update(query2, id+"");
	}

	@Override
	public List<Entity> read(String query, String... params) 
	{
		List<Entity> ris = new ArrayList<Entity>();
		List<Map<String,String>> tabella = db.rows(query, params);
		
		//DAOProdotto dp = DAOProdotto.getInstance();
		
		for(Map<String,String> riga : tabella)
		{
			Attore a = (Attore)  Factory.make("attore", riga);
			//a.setFilmRecitati(dp.prodottiPerAttore(a.getId()));
			ris.add(a);
		}
		return ris;
	}

	@Override
	public boolean update(Entity e) 
	{
		String query1 = "update persone set nome = ?, cognome = ?, dob = ?, nazionalita = ? where id = ?";
		String query2 = "update attori set oscarAttore = ?, baftaAttore = ?, scuolaRecitazione = ? where id = ?";

		Attore a = (Attore) e;
		return 
			db.update(query1, a.getNome(), a.getCognome(), a.getDob()+"", a.getNazionalita(), a.getId()+"")
			&&
			db.update(query2, a.isOscarAttore() == true ? 1+"" : 0+"", a.isBaftaAttore() == true ? 1+"" : 0+"", a.getScuolaRecitazione(), a.getId()+"");
	}
	
	// Query
	
	public List<Map<String,String>> attoriPerFilm(int id)
	{
		String query = "select persone.*, attori.* from attori inner join attoriprodotti on attori.id = attoriprodotti.idattore inner join persone on persone.id = attori.id where attoriprodotti.idprodotto = ?";
		List<Map<String,String>> ris = new ArrayList<Map<String,String>>();
		for(Entity e : read(query, id+""))
		{
			Map<String,String> ma = new LinkedHashMap<String,String>();
			if(e instanceof Attore)
			{
				ma.put("id", e.getId()+"");
				ma.put("nome", ((Attore) e).getNome());
				ma.put("cognome", ((Attore) e).getCognome());
			}
			ris.add(ma);
		}
		return ris;
	}
}
