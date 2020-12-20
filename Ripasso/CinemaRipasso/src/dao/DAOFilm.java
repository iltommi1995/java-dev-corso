package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Attore;
import entities.Film;

public class DAOFilm 
{
	
	private Connection con;
	private DAOAttore daoA = new DAOAttore();
	
	public DAOFilm() {
		this.con = Database.getConnection();
	}
	
	// Elenco
	
	public List<Film> elenco(String query) {
		
		List<Film> ris = new ArrayList<Film>();
		
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				ris.add(new Film		(
											rs.getInt("id"),
											rs.getString("titolo"),
											rs.getInt("annouscita"),
											rs.getInt("durata"),
											rs.getString("genere"),
											daoA.listaAttoriFilm(rs.getInt("id"))
										)
						);
			}
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ris;
	}
	
	public List<Film> listaFilm() {
		return elenco("select * from film");
	}
	
	public List<Film> cercaFilm(String titolo) {
		return elenco("select * from film where titolo like '%" + titolo + "%'");
	}
	
	public List<Film> cercaPerAttore(String cognome) {
		return elenco("select film.* from attori inner join recita on attori.id = recita.idattore inner join film on recita.idfilm = film.id where attori.cognome = '" + cognome + "'");
	}
}
