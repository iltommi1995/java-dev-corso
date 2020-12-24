package com.myproject.imdb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;
import com.myproject.imdb.entities.Factory;
import com.myproject.imdb.entities.Regista;

public class DAORegista implements IDAO
{
	// Proprietà 
	
	private Database db = Config.DB;
	
	private DAOFilm df = DAOFilm.getInstance();
	
	// Pattern singleton
	
	private static DAORegista instance = null;
	private DAORegista() {}
	
	public static synchronized DAORegista getInstance()
	{
		if(instance == null)
			instance = new DAORegista();
		return instance;
	}
	
	// Metodi CRUD
	
	@Override
	public boolean create(Entity e) 
	{
		String query1 = "insert into persone(nome, cognome, dob, nazionalita, imgpath) values(?,?,?,?,?)";
		String query2 = "insert into registi(id, oscarRegia, baftaRegia) values((select max(id) from persone),?,?)";
		
		Regista r = (Regista) e;
		return 
			db.update(query1, r.getNome(), r.getCognome(), r.getDob()+"", r.getNazionalita(), r.getImgpath())
			&&
			db.update(query2, r.isOscarRegia() == true ? 1+"" : 0+"", r.isBaftaRegia() == true ? 1+"" : 0+"");
	}

	@Override
	public boolean delete(int id) 
	{
		String query1 = "delete from registi where id = ?";
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
		
		for(Map<String,String> riga : tabella)
		{
			Regista r = (Regista) Factory.make("regista", riga);
			r.setFilmGirati(df.filmPerRegista(r.getId()));
			ris.add(r);
		}
		return ris;
	}

	@Override
	public boolean update(Entity e) 
	{
		String query1 = "update persone set nome = ?, cognome = ?, dob = ?, nazionalita = ?, imgpath = ? where id = ?";
		String query2 = "update registi set oscarRegia = ?, baftaRegia = ? where id = ?";
		Regista r = (Regista) e;
		return 
			db.update(query1, r.getNome(), r.getCognome(), r.getDob()+"", r.getNazionalita(), r.getImgpath(), r.getId()+"")
			&&
			db.update(query2, r.isOscarRegia() == true ? 1+"" : 0+"", r.isBaftaRegia() == true ? 1+"" : 0+"", r.getId()+"");
	}

}
