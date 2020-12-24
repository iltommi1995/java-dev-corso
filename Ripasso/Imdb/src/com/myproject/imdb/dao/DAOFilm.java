package com.myproject.imdb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;
import com.myproject.imdb.entities.Factory;
import com.myproject.imdb.entities.Film;
import com.myproject.imdb.entities.Prodotto;

public class DAOFilm implements IDAO
{
	// Proprietà
	
	private Database db = Config.DB;
	
	private DAOGenere dg = DAOGenere.getInstance();
	
	// Pattern singleton
	
	private static DAOFilm instance = null;
	
	private DAOFilm() {}
	
	public synchronized static DAOFilm getInstance()
	{
		if(instance == null)
			instance = new DAOFilm();
		return instance;
	}

	@Override
	public boolean create(Entity e) 
	{
		String query1 = "insert into prodotti(titolo, davedere, visto, imgpath) values(?,?,?,?)";
		String query2 = "insert into film(id, idRegista, durata, dataUscita, oscar) values((select max(id) from prodotti),?,?,?,?)";
		
		Film f = (Film) e;
		return 
			db.update(query1, f.getTitolo(), f.isDaVedere() == true ? 1+"" : 0+"", f.isVisto() == true ? 1+"" : 0+"", f.getImgpath())
			&&
			db.update(query2, f.getIdRegista()+"", f.getDurata()+"", f.getDataUscita()+"", f.isOscar() == true ? 1+"" : 0+"");
	}

	@Override
	public boolean delete(int id) 
	{
		String query1 = "delete from prodotti where id = ?";
		String query2 = "delete from film where id = ?";
		return db.update(query2, id+"") && db.update(query1, id+"");
	}

	@Override
	public List<Entity> read(String query, String... params) 
	{
		List<Entity> ris = new ArrayList<Entity>();
		List<Map<String,String>> tabella = db.rows(query, params);
		
		DAOAttore da = DAOAttore.getInstance();
		
		for(Map<String,String> riga : tabella) 
		{
			Film p = (Film) Factory.make("film", riga);
			p.setAttoriPresenti(da.attoriPerFilm(p.getId()));
			p.setGeneri(dg.generiProdotto(p.getId()));
			ris.add(p);
		}
		return ris;
	}

	@Override
	public boolean update(Entity e) 
	{
		String query1 = "update prodotti set titolo = ?, davedere = ?, visto = ?, imgpath = ? where id = ?";
		String query2 = "update film set idRegista = ?, durata = ?, dataUscita = ?, oscar = ? where id = ?";
		Film f = (Film) e;
		return 
			db.update(query1, f.getTitolo(), f.isDaVedere() == true ? 1+"" : 0+"", f.isVisto() == true ? 1+"" : 0+"", f.getImgpath(), f.getId()+"")
			&&
			db.update(query2, f.getIdRegista()+"", f.getDurata()+"", f.getDataUscita()+"", f.isOscar() == true ? 1+"" : 0+"", f.getId()+"");
	}
	
	// Query
	
	public List<Film> filmPerRegista (int id)
	{
		List<Film> ris = new ArrayList<Film>();
		String query = "select film.* from film inner join registi on film.idregista = registi.id where registi.id = ?";
		
		for(Entity e : read(query, id+""))
			if(e instanceof Film)
				ris.add((Film) e);
		return ris;
	}
}
