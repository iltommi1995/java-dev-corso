package com.generation.circo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.circo.entities.Animale;
import com.generation.circo.entities.Cliente;
import com.generation.circo.entities.Factory;
import com.generation.utility.database.Database;
import com.generation.utility.database.IDAO;
import com.generation.utility.entities.Entity;

public class DAOAnimali implements IDAO 
{
	private Database db = Config.DB;
	
	private static DAOAnimali instance = null;

    private DAOAnimali() {}

    public static DAOAnimali getInstance()
    {
        if(instance == null)
            instance = new DAOAnimali();
        return instance;
    }
	
	@Override
	public boolean create(Entity e) {
		
		//prima di fare insert su tab staff bisogna farla sulla tab persone
		//metodo deve fare 2 insert diverse
		String query1 = "insert into animali (nome, specie, tipo, costogiornaliero, pericoloso, vaccinato, idaddestratore) values (?,?,?,?,?,?,?)";
		
		Animale a = (Animale) e;
		
		//passo query e parametri a update()
		//se inserimento persona non va bene, non arriva a staff
		//se inserimento staff va male, persona è già inserita
		//perché uso and e non or
		return db.update(query1, a.getNome(), a.getSpecie(), a.getTipo(), a.getCostoGiornaliero()+"", a.isPericoloso() == true ? 1+"" : 0+"", a.isVaccinato() == true ? 1+"" : 0+"", a.getIdAddestratore()+"");

	}
	
	@Override
	public boolean delete(int id) {
		String query1 = "delete from animali where id = ?";
		
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
			ris.add(Factory.make("animale",riga));
		
		return ris;
	}
	
	@Override
	public boolean update(Entity e) {
		String query1 = "update animali set nome = ?, specie = ?, tipo = ?, costogiornaliero = ?, pericoloso = ?, vaccinato = ?, idaddestratore = ? where id = ? ";
		
		Animale a = (Animale) e;
		if(db.update(query1, a.getNome(), a.getSpecie(), a.getTipo(), a.getCostoGiornaliero()+"", a.isPericoloso() == true ? 1+"" : 0+"", a.isVaccinato() == true ? 1+"" : 0+"", a.getIdAddestratore()+"", a.getId() + ""))
			return true;
		else
			return false;
	}
	
	// ALTRI METODI
	
	// ritorna tutti gli animali
	
	public List<Entity> elenco() 
	{
		return read("select * from animali");
	}
	
	// ritorna gli animali addestrati da un determinato membro dello staff
	
	public List<Entity> elenco(int idaddestratore) 
	{
		String query = "select * from animali where idaddestratore = ?";
		return read(query,idaddestratore+"");
	}
	
	// ritorna gli animali addestrati da un membro dello staff che si chiama come il parametro passato
	
	public List<Animale> elenco(String nome) 
	{
		String query = "select * from animali inner join staff on staff.id = animali.idaddestratore inner join persone on persone.id = staff.id where persone.nome = ?";
		
		List<Animale> fl = new ArrayList<Animale>();
		
		for(Entity an : read(query, nome))
		{
			if(an instanceof Animale)
			{
				Animale ani = (Animale) an;
				fl.add(ani);
			}
		}
		return fl;
	}
}
