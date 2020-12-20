package com.generation.scuola.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.scuola.entities.Persona;
import com.generation.utility.database.Database;

public class DAOPersone 
{
	private Database db = Config.DB;
	
	// parte nuova
	// Il DAOPersone, così come gli altri DAO, dovrà essere creato all'interno del mio
	// programma solo 1 volta, per risovlere questa problematica ci viene in soccorso il 
	// pattern SINGLETON
	// Quando usiamo il pattern singleton dobbiamo effettuare tre operazioni: 
	// 1- 	definire una variabile del tipo desiderato nella propria classe
	//		come una proprietà static
	private static DAOPersone instance = null;
	
	// 2- 	definire come privato il costruttore per fare in modo che nessuno
	//		dall'esterno possa creare oggetti di questo tipo
	private DAOPersone() {}
	
	// 3-	definiamo un metodo statico getInstance() che ci ritornerà un oggetto
	//		del tipo richiesto.
	//		Il metodo controlla se instance non è ancora stato definito, allora lo crea. 
	//		Successivamente, in ogni caso, lo ritorna. Quindi l'operazione new DAOPersone()
	//		verrà eseguita solo 1 volta.
	public static DAOPersone getInstance()
	{
		if(instance == null)
			instance = new DAOPersone();
		return instance;
	}

	// fine parte nuova
	
	public List<Persona> read(String query)
	{
		List<Persona> ris = new ArrayList<Persona>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Persona p = new Persona();
			p.fromMap(riga);
			ris.add(p);
		}
		return ris;
	}
	
	public List<Persona> elenco() {
		return read("select * from persone");
	}

	public boolean create(Persona p)
	{
	    String query = "insert into persone (nome, cognome, dob, residenza) values " 
	                    + "('" + p.getNome() + "',"
	                    + "'" + p.getCognome() + "',"
	                    + "'" +  p.getDob() + "',"
	                    + "'" + p.getResidenza() + "')" ;
	    return db.update(query);
	}

	public boolean update(Persona p)
	{
	    String query =  "update persone set "
	                    + "nome = '" + p.getNome() + "',"
	                    + "cognome = '" + p.getCognome() + "',"
	                    + "dob = '" + p.getDob() + "',"
	                    + "residenza = '" + p.getResidenza() + "',"
	                    + " where id = " + p.getId();
	    return db.update(query);
	}

	public boolean delete(int id)
	{
	    String query = "delete from persone where id = " + id;

	    return db.update(query);
	}
	
	/*
	 * Scrivere i metodi sia ORM che NON-ORM:
	 * - public List<Persona> elencoResidenti(String residenza)
	 * - public List<Persona> cerca(String r)
	 * ritornare le persone che nel nome, nel cognome o nella residenza
	 * hanno la stringa r, non necessariamente uguale, basta che compaia
	 */
	
	// NON ORM
	
	public List<Persona> elencoResidenti(String residenza)
	{
		return read("select * from persone where residenza ='" + residenza + "'");
	}
	
	public List<Persona> cerca(String r)
	{
		return read("select * from persone where nome like '%" + r + "%' or cognome like '%" + r + "%' or residenza like '%" + r +"%'");
	}
	
	// ORM
	
	public List<Persona> elencoResidentiOrm(String residenza)
	{
		List<Persona> li = new ArrayList();
		
		for(Persona l : read("select * from persone"))
			if(l.getResidenza().equalsIgnoreCase(residenza))
				li.add(l);
		return li;
	}
	
	public List<Persona> cercaOrm(String r)
	{
		List<Persona> li = new ArrayList();
		
		for(Persona l : read("select * from persone"))
			if(l.getResidenza().toLowerCase().contains(r.toLowerCase()) || 
					l.getCognome().toLowerCase().contains(r.toLowerCase()) || 
					l.getNome().toLowerCase().contains(r.toLowerCase()))
				li.add(l);
		return li;
	}
	
}
