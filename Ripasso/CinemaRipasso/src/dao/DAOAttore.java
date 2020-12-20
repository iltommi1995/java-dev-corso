package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Attore;

public class DAOAttore 
{

	private Connection con;
	
	// Creo connessione
	
	public DAOAttore() {
		this.con = Database.getConnection();
	}
	
	// Elenco
	
	public List<Attore> elenco(String query) {
		
		List<Attore> ris = new ArrayList<Attore>();
		
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				ris.add(new Attore		(
											rs.getInt("id"),
											rs.getString("nome"),
											rs.getString("cognome"),
											rs.getDate("dob"),
											rs.getInt("costoperfilm")
										)
						);
			}
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ris;
	}
	
	public List<Attore> listaAttori() {
		return elenco("select * from attori");
	}
	
	public List<Attore> listaAttoriFilm(int idFilm) {
		return elenco("select * from attori inner join recita on attori.id = recita.idattore inner join film on recita.idfilm = film.id where film.id = " + idFilm);
	}
	
	public List<Attore> listaAttori( int costoMax) {
		return elenco("select * from attori where costoPerFilm <= " + costoMax);
	}
}
