package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Automobile;

public class DAOConcessionaria {
	
	private Connection con;
	
	// COSTRUTTORE
	
	public DAOConcessionaria()
	{
		String path = "jdbc:mysql://localhost:3306/concessionaria";
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
            e.printStackTrace();
        }
	}
	
	// Creare ArrayList
	
	public List<Automobile> elenco(String query)
    {
    	List<Automobile> ris = new ArrayList<Automobile>();
    	
    	try {
    		PreparedStatement p = con.prepareStatement(query);
    		ResultSet rs = p.executeQuery();
    		
    		while(rs.next()) {
    			ris.add( new Automobile(
    									rs.getInt("id"),
    									rs.getString("nome"),
    									rs.getInt("cilindrata"),
    									rs.getInt("numerocilindri"),
    									rs.getString("colore"),
    									rs.getDate("datavendita"),
    									rs.getString("cittacliente"),
    									rs.getInt("etacliente"),
    									rs.getInt("prezzo")
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
	
	/*
	 * 
		1 – Elenco schede di tutte le vetture
		2 – Scheda di una vettura
		3 – Elenco nome, cilindrata delle vetture con cilindrata > 1999
		4 - Elenco nome, cilindrata, numerocilindri delle vetture 
		    con numerocilindri “pari”
		5 – Elenco nome, datavendita, cittacliente delle vetture 
		    Vendute negli ultimi 3 anni
		6 – Eta media dei clienti che hanno acquistato vetture di colore
		    Bianco
		7 – Calcolare prezzo medio delle vetture con 4 cilindri
		8 – Elenco nome, datavendita, cittacliente delle vetture vendute
		    Nella città più “spendacciona”
	 */
	
	// stampa al
	
	public static String stampa(List<Automobile> lista) {
		String ris = "";
		for(Automobile a : lista) {
			ris += "\n" + a.toString() + "\n"	+ "------------" + "\n";
		}
		
		return ris;
		
	}
	
	/*
	 * private int id;
	private String nome;
	private int cilindrata;
	private int numerocilindri;
	private String colore;
	private Date date;
	private String cittacliente;
	private int etacliente;
	private int prezzo;
	 */
	
	public static String stampaQuelloCheVuoi(List<Automobile> lista, String[] parametri) {
		String ris = "";
		
		double mediaEta = 0;
		for(Automobile a : lista) {
			for(int i = 0; i < parametri.length; i++) {
				switch(parametri[i].toLowerCase()) {
					case "id":
						ris += "\nId: " + a.getId();
					break;
					case "nome":
						ris += "\nNome: " + a.getNome();
					break;
					case "cilindrata":
						ris += "\nCilindrata: " + a.getCilindrata();
					break;
					case "numerocilindri":
						ris += "\nNumero cilindri: " + a.getNumerocilindri();
					break;
					case "datavendita":
						ris += "\nDate: " + a.getDate();
					break;
					case "cittacliente":
						ris += "\nCittà cliente: " + a.getCittacliente();
					break;
					case "etacliente":
						ris += "\nEta cliente: " + a.getEtacliente();
					break;
					case "prezzo":
						ris += "\nPrezzo: " + a.getPrezzo();
					break;
				}
			}

				ris += "\n\n" + "---------" + "\n";		
		}
		
		return ris;
	}
	
	// Continua
	
	public static boolean continua(Scanner tastiera) {
		System.out.println("\nVuoi effettuare un'altra operazione?");
		return tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
	}
	
	// 1- Elenco schede di tutte le vetture
	
	public List<Automobile> listaVetture() {
		return elenco("select * from automobili");
	}
	
	
	// 2- Scheda di una vettura
	
	public List<Automobile> singolaVettura(int id) {
		String query = "select * from automobili where id = '" + id + "'";
		return elenco(query);
	}
	
	// 3 - Elenco nome, cilindrata delle vetture con cilindrata > 1999
	
	public List<Automobile> listaVettureCilindrata1999() {
		String query = "select * from automobili where cilindrata > '1999'";
		return elenco(query);
	}
	
	// 4 - Elenco nome, cilindrata, numerocilindri delle vetture con numerocilindri “pari”
	
	public List<Automobile> listaVettureCilindriPari() {
		String query = "select * from automobili where numerocilindri % 2 = '0'";
		return elenco(query);
	}
	
	
	// 5 - Elenco nome, datavendita, cittacliente delle vetture Vendute negli ultimi 3 anni 
	
	public List<Automobile> listaAutoVenduteNegliUltimi3Anni() {
		String query = "select * from automobili where (year(now()) - year(datavendita)) <= 3 ";
		return elenco(query);
	}
	
	// 6 - Eta media dei clienti che hanno acquistato vetture di colore Bianco
	
		public double etaClientiAutoBianche() {
			String query = "select avg(etacliente) as 'media' from automobili where colore = 'bianco' ";
			double mediaStipendi = 0;
			try {
				PreparedStatement p = con.prepareStatement(query);
	    		ResultSet rs = p.executeQuery();
	    		while(rs.next()) {
					mediaStipendi = rs.getDouble("media");
				}	
	    		
			}catch(Exception e) {
				e.printStackTrace();
			}
			return mediaStipendi;
		}
	
	// 7 – Calcolare prezzo medio delle vetture con 4 cilindri
		
		public double mediaPrezziVetture4Cilindri() {
			String query = "select avg(prezzo) as 'media' from automobili where numerocilindri = 4 ";
			double media = 0;
			try {
				PreparedStatement p = con.prepareStatement(query);
	    		ResultSet rs = p.executeQuery();
	    		while(rs.next()) {
					media = rs.getDouble("media");
				}	
	    		
			}catch(Exception e) {
				e.printStackTrace();
			}
			return media;
		}
		
		
	// 8 – Elenco nome, datavendita, cittacliente delle vetture vendute Nella città più “spendacciona”
		
		public List<Automobile> cittaSpendaccione() {
			String query = "select * from automobili where cittacliente = (" +
					"select cittacliente from ("+
							"select sum(prezzo) 'totprezzo', cittacliente from automobili "+
								"group by cittacliente"+
							") prezzitotcitta"+
						   " where totprezzo = ("+
								"select max(totprezzo) from ("+
							"select sum(prezzo) 'totprezzo', cittacliente from automobili"+
								" group by cittacliente"+
							") prezzitotcitta))";
			return elenco(query);
		}

}
