package com.generation.circo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.circo.entities.Cliente;
import com.generation.circo.entities.Factory;
import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;

public class DAOClienti implements IDAO
{
	private Database db = Config.DB;
	
	private static DAOClienti instance = null;

    private DAOClienti() {}

    public static DAOClienti getInstance()
    {
        if(instance == null)
            instance = new DAOClienti();
        return instance;
    }
	
	@Override
	public boolean create(Entity e) {
		
		//prima di fare insert su tab staff bisogna farla sulla tab persone
		//metodo deve fare 2 insert diverse
		String query1 = "insert into persone (nome, cognome, dob, sesso) values (?,?,?,?)";
		String query2 = "insert into clienti (id, altezza, residenza, cittavisita, spesa) values ((select max(id) from persone), ?, ?, ?, ?)";
		
		Cliente c = (Cliente) e;
		
		//passo query e parametri a update()
		//se inserimento persona non va bene, non arriva a staff
		//se inserimento staff va male, persona è già inserita
		//perché uso and e non or
		return db.update(query1, c.getNome(), c.getCognome(), c.getDob()+"", c.getSesso())
				&&
				db.update(query2, c.getAltezza()+"", c.getResidenza(), c.getCittaVisita(), c.getSpesa()+"");
	}
	
	@Override
	public boolean delete(int id) {
		String query1 = "delete from clienti where id = ?";
		String query2 = "delete from persone where id = ?";
		
		if(db.update(query1, id+"") && db.update(query2, id+""))
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
			ris.add(Factory.make("cliente",riga));
		
		return ris;
	}
	
	@Override
	public boolean update(Entity e) {
		String query1 = "update persone set nome = ?, cognome = ?, dob = ?, sesso = ? where id = ? ";
		String query2 = "update clienti set altezza = ?, residenza = ?, cittavisita = ?, spesa = ? where id = ? ";
		
		Cliente c = (Cliente) e;
		if(db.update(query1, c.getNome(), c.getCognome(), c.getDob() + "", c.getSesso(), c.getId() + "")
				&& db.update(query2, c.getAltezza()+"", c.getResidenza(), c.getCittaVisita(), c.getSpesa()+"", c.getId() + ""))
			return true;
		else
			return false;
	}

	
	// ALTRI METODI
	
	// ritorna tutti i clienti
	
	public List<Entity> elenco() 
	{
		return read("select * from persone inner join clienti on persone.id = clienti.id");
	}
	
	// elenco dei clienti che hanno fatto visita in una determinata città
	
	public List<Entity> elenco(String cittaVisitata)
	{
		String query = "select * from persone inner join clienti on persone.id = clienti.id where cittavisitata = ?";
		return read(query,cittaVisitata);
	}
	
	// elenco dei clienti la cui età è <= al parametro inserito
	
	public List<Cliente> elenco(int eta) 
	{
		String query = "select * from persone inner join clienti on persone.id = clienti.id where eta = ?";
		
		List<Entity> l = read(query,eta+"");
		
		List<Cliente> fl = new ArrayList<Cliente>();
		
		for(Entity cl : l)
		{
			if(cl instanceof Cliente)
			{
				Cliente cli = (Cliente) cl;
				fl.add(cli);
			}
		}
		return fl;
	}
	
}
