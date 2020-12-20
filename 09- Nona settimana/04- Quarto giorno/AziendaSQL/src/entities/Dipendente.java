package entities;

import java.sql.Date;

public class Dipendente 
{
	
	// Creo la classe dipendente con le prop uguali ai campi della tabella
	// che ho su mysql
	
	private int id;
	private String cognome;
	private Date dob;
	private String sesso;
	private String residenza;
	private int stipendio;
	
	// Costruttore
	
	public Dipendente(int id, String cognome, Date dob, String sesso, String residenza, int stipendio) {
		this.id = id;
		this.cognome = cognome;
		this.dob = dob;
		this.sesso = sesso;
		this.residenza = residenza;
		this.stipendio = stipendio;
	}
	
	
	// Getters & setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	
	

	
	
	
	
}
