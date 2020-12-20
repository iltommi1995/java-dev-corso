package com.generation.utility.database;

import java.sql.*;
import java.util.*;

public class Database 
{
	private Connection con;
	
	public Database(String user, String pw, String db)
	{
		String path = "jdbc:mysql://localhost:3306/" + db;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection(path, user, pw);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Map<String,String>> rows(String query) 
	{
		List<Map<String,String>> ris = new ArrayList<Map<String,String>>();
		
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			
			while(rs.next())
			{
				Map<String,String> riga = new HashMap<>();
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
				{
					riga.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
				ris.add(riga);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ris;
	}
	
	// String... si chiama VARARGS e serve a indicare un numero variabile di 
	// parametri. Quindi sto dicendo che in questo metodo prenderà come 
	// parametro uno String query(Sempre) e altri N parametri di tipo String
	// params all'interno del metodo verrà considerato di tipo String[]
	
	// Prima una query arrivava già "apposto", con i parametri della ricerca già inseriti.
	// Invece adesso una query arriverà in questo modo:
	
	// Select * from persone where eta > ? and residenza = ?
	
	// Il nostro metodo dovrà andare a rimpiazzare quei ? con i valori contenuti
	// all'interno di params. Il primo ? viene sostituito da params[0] mentre
	// il secondo ? viene sostituito da params[1] e così via...
	// Questo lavoro di sostituzione avviene PRIMA che la query venga eseguita, con 
	// il comando executeQuery
	
	public List<Map<String,String>> rows(String query, String... params)
	{
		List<Map<String,String>> ris = new ArrayList<Map<String,String>>();
		
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			
			for(int i = 0; i < params.length; i++)
				p.setString(i+1, params[i]);
		
			ResultSet rs = p.executeQuery();
			
			while(rs.next())
			{
				Map<String,String> riga = new LinkedHashMap<String,String>();
				
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
					riga.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getString(i));
				
				ris.add(riga);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ris;
	}
	
	
	
	public Map<String,String> row(String query) {
		
		List<Map<String,String>> righe = rows(query);
		
		return righe.size() > 0 ? righe.get(0) : null;
		
	}
	
	
	public Map<String,String> row(String query, String... params) {
		List<Map<String,String>> righe = rows(query, params);
		
		return righe.size() > 0 ? righe.get(0) : null;
	}
	
	
	public boolean update(String query) 
	{
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			p.executeUpdate();
			return true;
		} catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(String query, String... params) 
	{
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			
			for(int i = 0; i < params.length; i++) 
				p.setString(i+1, params[i]);
			
			p.executeUpdate();
			return true;
		} catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
