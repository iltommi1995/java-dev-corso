package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Sede;

public class DAOSede 
{
	
	private Connection con;
	private DAODipendente daoD;
	public DAOSede() {
		// Non voglio creare da solo la connection, chiedo alla classe DB
		// di farlo per me
		this.con = Database.getConnection();
		this.daoD = new DAODipendente();
	}
	
	public List<Sede> elenco(String query) 
	{
		List<Sede> ris = new ArrayList<Sede>();
		
		try {
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				ris.add(new Sede(
									rs.getInt("id"),
									rs.getString("citta"),
									rs.getString("indirizzo"),
									rs.getInt("mq"),
									daoD.perSede(rs.getInt("id"))
								)
						);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ris;
	}
}
