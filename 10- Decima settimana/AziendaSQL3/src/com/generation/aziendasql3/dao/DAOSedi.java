package com.generation.aziendasql3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.aziendasql3.entities.Dipendente;
import com.generation.aziendasql3.entities.Sede;
import com.generation.utility.database.Database;

public class DAOSedi 
{
	// Proprietà 
	
	private Database db = Config.DB;
	
	private DAODipendenti daoDip = Config.DD;
	
	// Costruttore
	
	public DAOSedi () {}
	
	// Metodo per leggere la tabella sedi
	
	public List<Sede> read(String query)
	{
		List<Sede> ris = new ArrayList<Sede>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Sede s = new Sede();
			s.fromMap(riga);
			
			// Inserisco lista dipendenti per sede
			
			s.setDipendenti(daoDip.dipendentiPerSede(s.getId()));
			
			ris.add(s);
		}
		return ris;
	}
	
	// Create
	
	public boolean create(Sede s) 
	{
		String query = "insert into sedi " 						+
						"(citta, indirizzo, mq) values" 		+
						"('" + s.getCitta() 		+	"',"	+
						"'"	 + s.getIndirizzo()		+	"',"	+
						s.getMq()					+	")"		;
		
		return db.update(query);				
	}
	
	// Update
	
	public boolean update(Sede s) 
	{
		String query = 	"update sedi set " +
						"citta = '" + s.getCitta() + "', " +
						"indirizzo = '" + s.getIndirizzo() + "', " 	+
						"mq = " + s.getMq()  				+
						" where id = "	+	s.getId()				;
		return db.update(query);
	}
	
	// Delete
	
	public boolean delete(int id)
	{
		String query = "delete from sedi where id = " + id;
		
		return db.update(query);
	}
	
	// Elenco di tutte le sedi
	
	public List<Sede> elencoSedi()
	{
		return read("select * from sedi");
	}
	
	// Elenco delle sedi che hanno almeno tot dipendenti
	
	public List<Sede> elencoSediORM(int ndipendenti) 
	{
		List<Sede> ris = new ArrayList<Sede>();
		
		for(Sede s : elencoSedi())
		{
            if(s.getDipendenti().size() >= ndipendenti)
                ris.add(s);
		}
		
		return ris;
	}
	
	// Elenco sedi per città
	
	public List<Sede> elencoSedi(String citta)
	{
		return read("select * from sedi where citta = '" + citta + "'");
	}
	
	// la somma degli stipendi dei dipendenti che lavorano in una sede che si trova nella città indicata
	
	public double stipendiTot(String citta) 
	{
		String query = "select sum(stipendio) as n, citta from dipendenti inner join sedi on dipendenti.idsede = sedi.id where sedi.citta = '" + citta +"'";
		Map<String,String> riga = db.row(query);
		
		return Double.parseDouble(riga.get("n"));
	}
	
	// Come metodo sopra ma ORM
	
	public double stipendiTotORM(String citta)
	{
		double somma = 0;
		
		for(Sede s : elencoSedi())
		{
            if(s.getCitta().equalsIgnoreCase(citta)) 
            {
            	for(Dipendente d : s.getDipendenti())
            	{
            		somma += d.getStipendio();
            	}
            }
		}
		return somma;
	}
}
