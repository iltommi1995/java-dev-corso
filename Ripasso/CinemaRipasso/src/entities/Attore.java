package entities;

import java.sql.Date;

public class Attore 
{
	private int id;
	private String nome;
	private String cognome;
	private Date dob;
	private int costoPerFilm;
	
	
	// Costruttore
	
	public Attore(int id, String nome, String cognome, Date dob, int costoPerFilm) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.costoPerFilm = costoPerFilm;
	}
	
	
	// Tostring
	
	public String toString() {
		return 	"Id: " + 	id	+	"\n"	+
				"Nome: "	+	nome	+	"\n"	+
				"Cognome: "	+	cognome	+	"\n"	+
				"Data di nascita: "		+	dob		+	"\n"	+
				"Costo per film: "		+	costoPerFilm;
		
	}
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getCostoPerFilm() {
		return costoPerFilm;
	}

	public void setCostoPerFilm(int costoPerFilm) {
		this.costoPerFilm = costoPerFilm;
	}	
}
