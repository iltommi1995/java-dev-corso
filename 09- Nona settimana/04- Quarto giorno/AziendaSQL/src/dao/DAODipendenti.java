package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entities.Dipendente;

public class DAODipendenti {
	/*
	 * DAO sta per Data Access Object, quindi un DAO è una classe che si 
	 * occupa dell'accesso dei dati che si trovano in un altro posto che 
	 * potrebbe essere un database, un file, un sito web ecc ...
	 * 
	 * All'interno di questo oggetto andremo a definire il canale di 
	 * connessione con il database e a leggere i dati.
	 */
	
	private Connection con;
	
	public DAODipendenti()
	{
		// Il costruttore dovrà semplicemente andare ad inizializzare
		// l'oggetto Connection
		
		String path = "jdbc:mysql://localhost:3306/aziendajava";
        String user = "root";
        String pw = "root";
        
        try 
        {
        	// Questa istruzione serve a dire a java di utilizzare il 
        	// connector corretto
            Class.forName("com.mysql.jdbc.Driver"); 
            // Si crea la connessione passando i 3 parametri
            con = DriverManager.getConnection(path, user, pw);
            System.out.println("CONNESSIONE OK");
        }
        catch(Exception e)
        {
            System.err.println("ERRORE DI CONNESSIONE");
        }
	}
	
	public List<Dipendente> elenco(String query)
    {
    	List<Dipendente> ris = new ArrayList<Dipendente>();
    	
    	
    	
    	try {
    		PreparedStatement p = con.prepareStatement(query);
    		ResultSet rs = p.executeQuery();
    		
    		while(rs.next()) {
    			ris.add( new Dipendente(
    									rs.getInt("id"),
    									rs.getString("cognome"),
    									rs.getDate("dob"),
    									rs.getString("sesso"),
    									rs.getString("residenza"),
    									rs.getInt("stipendio")
    							)
    					);
    		}
    	} catch(Exception e)
    	{
    		System.out.println("Errore nella query : " + query);
    		e.printStackTrace();
    	}
    	return ris;
    }
	
	public List<Dipendente> listaDipendenti() {
		return elenco("select * from dipendenti");
	}
	
	public List<Dipendente> listaDipendenti(int stipendio) {
		return elenco("select * from dipendenti where stipendio > " + stipendio);
	}
	
	// CI SONO DUE METODI DI LAVORO: ORM o NON-ORM
	// ORM vuol dire Object Relational Mapping, ovvero trasformare i dati di 
	// sql in oggetti java e poi fare il calcolo
	// NON-ORM vuol dire prelevare dati dal db già secondo i canoni stabiliti
	
	public List<Dipendente> listaDipendenti(String residenza) {
		return elenco("select * from dipendenti where residenza = '" + residenza +"'");
	}
	
	public List<Dipendente> listaDipendentiORM(String residenza) {
		List<Dipendente> ris = new ArrayList<Dipendente>();
		
		for(Dipendente d : listaDipendenti()) {
			if(d.getResidenza().equalsIgnoreCase(residenza))
				ris.add(d);
		}
		return ris;
	}
	
	
	/*
     * Scrivere i seguenti metodi sia ORM che NON-ORM:
     * 1 - public List<Dipendente> ricerca(String sesso, String cognome)
     * cercare i dipendenti che sono di un determinato sesso e
     * hanno un determinato cognome
     * 
     * 2 - public List<Dipendente> ricercaIntelligente(String sesso, String cognome)
     * come il precedente ma se un parametro è = "" allora non considerarlo nella ricerca
     * 
     * 3- public double mediaStipendi(String residenza)
     * calcolare la media degli stipendi dei dipendenti che abitano in una determinata
     * città
     */
	
	public List<Dipendente> ricercaORM(String sesso, String cognome)
    {
        List<Dipendente> ris = new ArrayList<Dipendente>();
        for(Dipendente d : listaDipendenti())
            if(d.getSesso().equalsIgnoreCase(sesso) && d.getCognome().equalsIgnoreCase(cognome))
                ris.add(d);
        if(ris.size() == 0)
            System.out.println("La ricerca non ha prodotto alcun risultato");

        return ris;
    }

    public List<Dipendente> ricercaNonORM(String sesso, String cognome)
    {
        return elenco("select * from dipendenti where sesso = '" + sesso + "' and cognome = '" + cognome + "'");
    }

    public List<Dipendente> ricercaIntelligenteORM(String sesso, String cognome)
    {
        List<Dipendente> ris = new ArrayList<Dipendente>();
        for(Dipendente d : listaDipendenti())
        {
            if(d.getSesso().equalsIgnoreCase(sesso) && cognome.equals(""))
                ris.add(d);

            else if(sesso.equals("") && d.getCognome().equalsIgnoreCase(cognome))
                ris.add(d);

            else if(d.getSesso().equalsIgnoreCase(sesso) && d.getCognome().equalsIgnoreCase(cognome))
                ris.add(d);
        }
        if(ris.size() == 0)
            System.out.println("La ricerca non ha prodotto alcun risultato");

        return ris;
    }
    
    public List<Dipendente> ricercaIntelligente(String sesso, String cognome)
    {
        String query = "select * from dipendenti as d where ";

        if(!(sesso.equalsIgnoreCase("")))
            query += "d.sesso = '" + sesso + "'";

        if(!(sesso.equalsIgnoreCase("")) && !(cognome.equalsIgnoreCase("")))
            query += " and ";

        if(!(cognome.equalsIgnoreCase("")))
            query += "d.cognome = '" + cognome + "'";

        if(sesso.equalsIgnoreCase("") && cognome.equalsIgnoreCase(""))
            return null;

        return elenco(query);
    }
	
	public double mediaStipendiOrm(String residenza) {
		double conteggio = 0;
		double mediaStipendi = 0;
		
		for(Dipendente d : listaDipendenti()) {
			if(d.getResidenza().equalsIgnoreCase(residenza))
			{
				mediaStipendi += d.getStipendio();
				conteggio ++;
			}
		}
		
		return (mediaStipendi / conteggio);
	}
	
	public double mediaStipendi(String residenza) {
		double mediaStipendi = 0;
		String query = "select avg(stipendio) as 'media' from dipendenti where residenza = '" + residenza + "'"; 
		
		// devo fare in modo che la query non ritorni dei dipendenti ma un double
		try {
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				mediaStipendi = rs.getDouble("media");
			}	
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return mediaStipendi;
	}
	
}
