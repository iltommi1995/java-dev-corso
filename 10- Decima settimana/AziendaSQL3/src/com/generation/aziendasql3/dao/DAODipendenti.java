package com.generation.aziendasql3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.aziendasql3.entities.Dipendente;
import com.generation.utility.database.Database;

public class DAODipendenti 
{
	private Database db = Config.DB;
	
	public DAODipendenti() {};
	
	public List<Dipendente> read(String query)
	{
		List<Dipendente> ris = new ArrayList<Dipendente>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Dipendente d = new Dipendente();
			d.fromMap(riga);
			ris.add(d);
		}
		return ris;
	}
	
	public List<Dipendente> elenco()
	{
		
		return read("select * from dipendenti");
	}
	
	public List<Dipendente> elencoResidenza(String r)
	{
		return read("select * from dipendenti where residenza = '" + r + "'");
	}
	
	public boolean create(Dipendente d) 
	{
		String query = "insert into dipendenti " +
						"(cognome, dob, sesso, residenza, stipendio, idsede) values" +
						"('" + d.getCognome() +	"',"		+
						"'"	 + d.getDob()		+	"',"	+
						"'"	 + d.getSesso()		+	"',"	+
						"'"	 + d.getResidenza()		+	"',"+
						d.getStipendio()			+ ", "		+
						d.getIdSede()		+	")"			;
		
		return db.update(query);				
	}
	
	public boolean update(Dipendente d) 
	{
		String query = 	"update dipendenti set " +
						"cognome = '" + d.getCognome() + "', " +
						"dob = '" + d.getDob() + "', " 	+
						"sesso = '" + d.getSesso() + "', " +
						"residenza = '" + d.getResidenza() + "', " 	+
						"stipendio = '" + d.getStipendio() + "', " 	+
						"idsede = " + d.getIdSede()  				+
						" where id = "	+	d.getId()				;
		return db.update(query);
	}
	
	public boolean delete(int id)
	{
		String query = "delete from dipendenti where id = " + id;
		
		return db.update(query);
	}
	
	public List<Dipendente> dipendenteIdMaggiore () {
		String query = "select * from dipendenti where dipendenti.id = (select max(dipendenti.id) from dipendenti)";
		
		return read(query);
	}
	
	public String elencoIdCognome()
	{
		List<Dipendente> lista= read("select * from dipendenti");
		
		String ris = "";
		
		for(Dipendente d : lista) {
			ris += "ID: " + d.getId() + ", cognome: " + d.getCognome()+"\n";
		}
		
		return ris;
	}
	
	// Metodo che restituisce quanti abitanti sono residenti nella citta indicata
	// facciamolo non orm
	
	public int contaAbitanti(String citta)
	{
		String query = "select count(*) as n from dipendenti where residenza = '" + citta + "'";
		
		Map<String,String> riga = db.row(query);
		
		return Integer.parseInt(riga.get("n"));
	}
	
	// Metodo per restituire dipendenti per sede
	
	public List<Dipendente> dipendentiPerSede(int idSede) {
		return read("select * from dipendenti inner join sedi on dipendenti.idsede = sedi.id where idsede = " + idSede);
	}
	
}
