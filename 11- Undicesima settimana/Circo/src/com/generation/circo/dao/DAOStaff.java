package com.generation.circo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.circo.entities.Factory;
import com.generation.circo.entities.Staff;
import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;

// Implemento l'interfaccia IDAO presente in Utility.jar in 
// modo da rendere obbligatorio l'override dei metodi presenti in
// IDAO

public class DAOStaff implements IDAO
{
	
	private Database db = Config.DB;
	
	private static DAOStaff instance = null;

    private DAOStaff() {}

    public static DAOStaff getInstance()
    {
        if(instance == null)
            instance = new DAOStaff();
        return instance;
    }
	
	@Override
	public boolean create(Entity e) {
		
		//prima di fare insert su tab staff bisogna farla sulla tab persone
		//metodo deve fare 2 insert diverse
		String query1 = "insert into persone (nome, cognome, dob, sesso) values (?,?,?,?)";
		String query2 = "insert into staff (id, ruolo, stipendio, giornolibero) values ((select max(id) from persone), ?, ?, ?)";
		
		Staff s = (Staff) e;
		
		//passo query e parametri a update()
		//se inserimento persona non va bene, non arriva a staff
		//se inserimento staff va male, persona è già inserita
		//perché uso and e non or
		return db.update(query1, s.getNome(), s.getCognome(), s.getDob()+"", s.getSesso())
				&&
				db.update(query2, s.getRuolo(),s.getStipendio()+"", s.getGiornoLibero());
	}

	@Override
	public boolean delete(int id) {
		String query1 = "delete from staff where id = ?";
		String query2 = "delete from persone where id = ?";
		
		if(db.update(query1, id+"") && db.update(query2, id+""))
			return true;
		else
			return false;
	}

	//par query è obbligatorio, parametri possono essere anche 0 (da 0 a N)
	@Override
	public List<Entity> read(String query, String... params) {
		
		List<Entity> ris = new ArrayList<Entity>();
		
		//rimpiazzo ? con parametri
		List<Map<String,String>> tabella = db.rows(query, params);
		
		//ciclo righe estrapolate da database
		for(Map<String,String> riga : tabella)
			//formo oggetto tramite Factory, indico tipo e do parametri
			ris.add(Factory.make("staff",riga));
		
		return ris;
	}

	@Override
	public boolean update(Entity e) {
		String query1 = "update persone set nome = ?, cognome = ?, dob = ?, sesso = ? where id = ? ";
		String query2 = "update staff set ruolo = ?, stipendio = ?, giornolibero = ? where id = ? ";
		
		Staff s = (Staff) e;
		if(db.update(query1, s.getNome(), s.getCognome(), s.getDob() + "", s.getSesso(), s.getId() + "")
				&& db.update(query2, s.getRuolo(), s.getStipendio()+"", s.getGiornoLibero(), s.getId() + ""))
			return true;
		else
			return false;
	}
	
	
	//restituisce elenco di tt i membri dello staff
	//passo params che restituisce vettore di stringhe vuoto
	//passo 0 parametri
	public List<Entity> elenco(){
		return read("select * from persone inner join staff on persone.id = staff.id");
	}
		
	//passo 1 parametro
	public List<Entity> elenco(String sesso){
			
		String query = "select * from persone inner join staff on persone.id = staff.id where sesso = ?";
		return read(query,sesso);
	}
	
	//passo 2 parametri castati a String
	//scrivere query che ritorna membri staff con eta tra etaMinima e etaMassima
	public List<Entity> elenco(int etaMinima, int etaMassima){
		String query = "select * from persone inner join staff on persone.id = staff.id where (year(now()) - year(dob)) between ? and ?";
		return read(query, etaMinima + "", etaMassima + "");
	}
	
	/*
	public List<Entity> read(String query) {
		
		List<Entity> ris = new ArrayList<Entity>();
		
		//leggo da db risultati di query
		List<Map<String,String>> tabella = db.rows(query);
		
		//trasformo mappa in Entity
		for(Map<String,String> riga : tabella)
			ris.add(Factory.make("staff",riga));
		
		return ris;
	}*/
}
