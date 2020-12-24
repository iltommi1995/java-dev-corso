package com.myproject.imdb.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;
import com.myproject.imdb.entities.Factory;
import com.myproject.imdb.entities.Prodotto;

public class DAOProdotto implements IDAO
{
	// PROPRIETA'
	
	private Database db = Config.DB;

	private DAOGenere dg = DAOGenere.getInstance();

	// Pattern singleton
	
	
	private static DAOProdotto instance = null;
	private DAOProdotto(){}
	
	// Synchronized per far sì che non ci siano due richieste contemporanee
	
	public static DAOProdotto getInstance()
	{
		if(instance == null)
			instance = new DAOProdotto();
		return instance;
	}
	
	// METODI CRUD

	@Override
	public boolean create(Entity e) {
		String query = "insert into prodotti(titolo, davedere, visto, imgpath) values(?,?,?,?)";
		Prodotto g = (Prodotto) e;
		return db.update(query, g.getTitolo(), g.isDaVedere() == true ? 1+"" : 0+"", g.isVisto() == true ? 1+"" : 0+"", g.getImgpath());
	}

	@Override
	public boolean delete(int id) {
		String query = "delete from prodotti where id = ?";
		return db.update(query, id+"");
	}

	@Override
	public List<Entity> read(String query, String... params) {
		List<Entity> ris = new ArrayList<Entity>();
		
		List<Map<String,String>> tabella = db.rows(query, params);
		
		DAOAttore da = DAOAttore.getInstance();
		
		for(Map<String,String> riga : tabella)
		{
			Prodotto p = (Prodotto) Factory.make("prodotto", riga);
			p.setAttoriPresenti(da.attoriPerFilm(p.getId()));
			p.setGeneri(dg.generiProdotto(p.getId()));
			ris.add(p);
		}
		return ris;
	}

	@Override
	public boolean update(Entity e) {
		String query = "update prodotti set titolo = ?, davedere = ?, visto = ?, imgpath = ? where id = ?";
		Prodotto g = (Prodotto) e;
		return db.update(query, g.getTitolo(), g.isDaVedere() == true ? 1+"" : 0+"", g.isVisto() == true ? 1+"" : 0+"", g.getImgpath(), g.getId()+"");
	}
	
	// Query
	
	public List<Map<String,String>> prodottiPerAttore(int id)
	{
		String query = "select prodotti.* from prodotti inner join attoriprodotti on prodotti.id = attoriprodotti.idprodotto where attoriprodotti.idattore = ?";
		List<Map<String,String>> ris = new ArrayList<Map<String,String>>();
		for(Entity e : read(query, id+""))
		{
			Map<String,String> ma = new LinkedHashMap<String,String>();
			if(e instanceof Prodotto)
			{
				ma.put("id", e.getId()+"");
				ma.put("titolo", ((Prodotto) e).getTitolo());
			}
			ris.add(ma);
		}
		
		return ris;
	}
}
