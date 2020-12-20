package com.myproject.imdb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;
import com.myproject.imdb.entities.Factory;
import com.myproject.imdb.entities.Persona;

public class DAOPersona implements IDAO
{
	// Proprietà 
	
	private Database db = Config.DB;
	
	// Pattern singleton
	
	private static DAOPersona instance = null;
	
	private DAOPersona() {}
	
	public static synchronized DAOPersona getInstance()
	{
		if(instance == null)
			instance = new DAOPersona();
		return instance;
	}
	
	// Metodi CRUD
	
	@Override
	public boolean create(Entity e) 
	{
		String query = "insert into persone(nome, cognome, dob, nazionalita) values(?,?,?,?)";
		
		Persona p = (Persona) e;
		return db.update(query, p.getNome(), p.getCognome(), p.getDob()+"", p.getNazionalita());
	}

	@Override
	public boolean delete(int id) 
	{
		String query = "delete from persone where id = ?";
		return db.update(query, id+"");
	}

	@Override
	public List<Entity> read(String query, String... params) 
	{
		List<Entity> ris = new ArrayList<Entity>();
		List<Map<String,String>> tabella = db.rows(query, params);
		
		for(Map<String,String> riga : tabella)
			ris.add(Factory.make("persona", riga));
		
		return ris;
	}

	@Override
	public boolean update(Entity e) 
	{
		String query = "update persone set nome = ?, cognome = ?, dob = ?, nazionalita = ? where id = ?";
		Persona p = (Persona) e;
		return db.update(query, p.getNome(), p.getCognome(), p.getDob()+"", p.getNazionalita(), p.getId()+"");
	}
	
}
