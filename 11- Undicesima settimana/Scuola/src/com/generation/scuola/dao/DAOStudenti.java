package com.generation.scuola.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.scuola.entities.Persona;
import com.generation.scuola.entities.Studente;
import com.generation.utility.database.Database;

public class DAOStudenti 
{
	private Database db = Config.DB;
	
	private static DAOStudenti instance = null;
	private DAOStudenti() {};
	public static DAOStudenti getInstance()
	{
		if(instance == null)
			instance = new DAOStudenti();
		return instance;
	}
	
	// Read
	
	public List<Studente> read(String query)
	{
		List<Studente> ris = new ArrayList<Studente>();
		
		List<Map<String,String>> tabella = db.rows(query);
		
		for(Map<String,String> riga : tabella)
		{
			Studente s = new Studente();
			s.fromMap(riga);
			ris.add(s);
		}
		return ris;
	}
	
	public boolean create(Studente p)
	{
	    String query = "insert into studenti (id, classe, sezione, votoIta, votoMat, votoIng, votoSto) values " 
	                    + "(" + p.getId() + ","
	                    +  p.getClasse() + ","
	                    +  "'" + p.getSezione() + "',"
	                    +   p.getVotoIta() + ","
	                    +   p.getVotoMat() + ","
	                    +   p.getVotoIng() + ","
	                    +   p.getVotoSto() +  ")" ;
	    return db.update(query);
	}
	
	public List<Studente> elenco() {
		return read("select * from studenti inner join persone on persone.id = studenti.id");
	}
	
	public boolean salva(Studente s) 
	{
		// Prima creare la persona
		
		if(DAOPersone.getInstance().create(s))
		{
			// Poi recuperare l'id di quella persona
			// Infine creare lo studente
			
			String query = "insert into studenti values "
							+ "( (select max(id) from persone), "
							+ "'"	+	 s.getClasse()	+	"',"
							+ "'"	+	 s.getSezione()	+	"',"
							+ "'"	+	 s.getVotoIta()	+	"',"
							+ "'"	+	 s.getVotoMat()	+	"',"
							+ "'"	+	 s.getVotoIng()	+	"',"
							+ "'"	+	 s.getVotoSto()	+	"')";
		}
		
		return false;
	}
	
}
