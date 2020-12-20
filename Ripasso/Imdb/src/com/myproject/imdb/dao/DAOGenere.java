package com.myproject.imdb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;
import com.myproject.imdb.entities.Factory;
import com.myproject.imdb.entities.Genere;

public class DAOGenere implements IDAO
{
	// Richiamo il database da Config
	
	private Database db = Config.DB;
	
	// Pattern singleton
	
	private static DAOGenere instance = null;

    private DAOGenere() {}

    public static DAOGenere getInstance()
    {
        if(instance == null)
            instance = new DAOGenere();
        return instance;
    }
    
    // METODI CRUD
    
    // Create
    
	@Override
	public boolean create(Entity e) {
		String query = "insert into generi (nome) values (?) ";
		Genere g = (Genere) e;		
		return db.update(query, g.getNome());
	}
	
	// Delete

	@Override
	public boolean delete(int id) {
		String query = "delete from generi where id = ?";
		return db.update(query, id+"");
	}
	
	// Read

	@Override
	public List<Entity> read(String query, String... params) {
		List<Entity> ris = new ArrayList<Entity>();
		
		List<Map<String,String>> tabella = db.rows(query, params);
		
		for(Map<String,String> riga : tabella)
			ris.add(Factory.make("genere",riga));
		return ris;
	}
	
	// Update

	@Override
	public boolean update(Entity e) {
		String query = "update generi set nome = ? where id = ?";
		
		Genere g = (Genere) e;		
		return db.update(query, g.getNome(), g.getId()+"");
	}
	
	// Query
	
	public List<Genere> generiProdotto (int id) {
		List<Entity> le = read("select generi.* from generi inner join generiprodotti on generi.id = generiprodotti.idgenere where generiprodotti.idprodotto = ?",id+"");
		List<Genere> lg = new ArrayList<Genere>();
		
		for(Entity e : le)
			if(e instanceof Genere)
				lg.add((Genere) e);
		return lg;
	}
}
