package com.generation.circo.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.circo.entities.Attrazione;
import com.generation.circo.entities.Cliente;
import com.generation.circo.entities.Factory;
import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;

public class DAOAttrazioni implements IDAO 
{
	private Database db = Config.DB;
	
	private static DAOAttrazioni instance = null;

    private DAOAttrazioni() {}

    public static DAOAttrazioni getInstance()
    {
        if(instance == null)
            instance = new DAOAttrazioni();
        return instance;
    }
	
	@Override
	public boolean create(Entity e) {
		
		//prima di fare insert su tab staff bisogna farla sulla tab persone
		//metodo deve fare 2 insert diverse
		String query1 = "insert into attrazioni (nome, costobiglietto, altezzaminima, dataacquisto, scadenzacollaudo) values (?,?,?,?,?)";
		
		Attrazione a = (Attrazione) e;
		
		//passo query e parametri a update()
		//se inserimento persona non va bene, non arriva a staff
		//se inserimento staff va male, persona è già inserita
		//perché uso and e non or
		return db.update(query1, a.getNome(), a.getCostoBiglietto()+"", a.getAltezzaMinima()+"", a.getDataAcquisto()+"", a.getScadenzaCollaudo()+"");

	}
	
	@Override
	public boolean delete(int id) {
		String query1 = "delete from attrazioni where id = ?";
		
		if(db.update(query1, id+""))
			return true;
		else
			return false;
	}
	
	@Override
	public List<Entity> read(String query, String... params) {
		
		List<Entity> ris = new ArrayList<Entity>();
		
		//rimpiazzo ? con parametri
		List<Map<String,String>> tabella = db.rows(query, params);
		
		//ciclo righe estrapolate da database
		for(Map<String,String> riga : tabella)
			//formo oggetto tramite Factory, indico tipo e do parametri
			ris.add(Factory.make("attrazione",riga));
		
		return ris;
	}
	
	@Override
	public boolean update(Entity e) {
		String query1 = "update attrazioni set nome = ?, costobiglietto = ?, altezzaminima = ?, dataacquisto = ?, scadenzacollaudo = ? where id = ? ";
		
		Attrazione a = (Attrazione) e;
		if(db.update(query1, a.getNome(), a.getCostoBiglietto()+"", a.getAltezzaMinima()+"", a.getDataAcquisto()+"", a.getScadenzaCollaudo()+"", a.getId() + ""))
			return true;
		else
			return false;
	}
	
	
	// ALTRI METODI
	
	// ritorna tutti gli animali
	
	public List<Entity> elenco() 
	{
		return read("select * from attrazioni");
	}
	
	// ritorna l'elenco delle attrazioni che sono acquistate tra le due date passate come parametro
	
	public List<Entity> elenco(Date da, Date a) 
	{
		String query = "select * from attrazioni where dataacquisto between ? and ?";
		return read(query, da +"", a +"");
	}
	
	// ritornare l'elenco delle attrazioni che sono gestite da una persona che ha il giorno libero nel giorno indicato come parametro
	
	public List<Attrazione> elenco(String giorno) 
	{
		String query = "select * from attrazioni inner join gestione on attrazioni.id = gestione.idattrazione inner join staff on staff.id = gestione.idstaff where giornolibero = ?";

		List<Entity> l = read(query,giorno);
		
		List<Attrazione> fl = new ArrayList<Attrazione>();
		
		for(Entity at : l)
		{
			if(at instanceof Attrazione)
			{
				Attrazione att = (Attrazione) at;
				fl.add(att);
			}
		}
		return fl;
	}
}
