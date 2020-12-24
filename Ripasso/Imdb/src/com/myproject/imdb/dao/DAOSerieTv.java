package com.myproject.imdb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;
import com.myproject.imdb.entities.Factory;
import com.myproject.imdb.entities.SerieTv;

public class DAOSerieTv implements IDAO
{
	// Proprietà
	
	private Database db = Config.DB;
	
	private DAOGenere dg = DAOGenere.getInstance();
	
	// Pattern singleton
	
	private static DAOSerieTv instance = null;
	
	private DAOSerieTv() {}
	
	public static synchronized DAOSerieTv getInstance()
	{
		if(instance == null)
			instance = new DAOSerieTv();
		return instance;
	}
	
	// Metodi CRUD

	@Override
	public boolean create(Entity e) 
	{
		String query1 = "insert into prodotti(titolo, davedere, visto, imgpath) values(?,?,?,?)";
		String query2 = "insert into serietv(id, dataInizio, dataFine, numeroEpisodi, bafta) values ((select max(id) from prodotti),?,?,?,?)";
		SerieTv f = (SerieTv) e;
		return 
			db.update(query1, f.getTitolo(), f.isDaVedere() == true ? 1+"" : 0+"", f.isVisto() == true ? 1+"" : 0+"", f.getImgpath())
			&&
			db.update(query2, f.getDataInizio()+"", f.getDataFine()+"", f.getNumeroEpisodi()+"", f.isBafta() == true ? 1+"" : 0+"");
	}

	@Override
	public boolean delete(int id) 
	{
		String query1 = "delete from prodotti where id = ?";
		String query2 = "delete from serietv where id = ?";
		return 
			db.update(query2, id+"")
			&&
			db.update(query1, id+"");
	}

	@Override
	public List<Entity> read(String query, String... params) 
	{
		List<Entity> ris = new ArrayList<Entity>();
		List<Map<String,String>> tabella = db.rows(query, params);
		
		DAOAttore da = DAOAttore.getInstance();
		
		for(Map<String,String> riga : tabella)
		{
			SerieTv p = (SerieTv) Factory.make("serietv", riga);
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
		String query2 = "update serietv set dataInizio = ?, dataFine = ?, numeroEpisodi = ?, bafta = ? where id = ?";
		SerieTv f = (SerieTv) e;
		return 
			db.update(query1, f.getTitolo(), f.isDaVedere() == true ? 1+"" : 0+"", f.isVisto() == true ? 1+"" : 0+"", f.getImgpath(), f.getId()+"")
			&&	
			db.update(query2, f.getDataInizio()+"", f.getDataFine()+"", f.getNumeroEpisodi()+"", f.isBafta() == true ? 1+"" : 0+"", f.getId()+"");
	}
	
	
}
