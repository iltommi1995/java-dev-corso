package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Dipendente;

public class DAODipendente {
	
	private Connection con;
	
	public DAODipendente() {
		// Non voglio creare da solo la connection, chiedo alla classe DB
		// di farlo per me
		this.con = Database.getConnection();
	}
	
	
	public List<Dipendente> elenco (String query) 
	{
		List<Dipendente> ris = new ArrayList<Dipendente>();
		
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				ris.add(new Dipendente(
										rs.getInt("id"),
										rs.getString("cognome"),
										rs.getDate("dob"),
										rs.getString("sesso"),
										rs.getString("residenza"),
										rs.getInt("stipendio"),
										rs.getInt("idsede")
										)
						);
			}
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return ris;
	}
	
	public List<Dipendente> perSede(int idsede) 
	{
		return elenco("select * from dipendenti where idsede = " + idsede);
	}
}
