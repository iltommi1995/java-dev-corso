package entities;

import java.util.List;

public class Sede {
	
	private int id;
	private String citta;
	private String indirizzo;
	private int mq;
	private List<Dipendente> dipendenti;
	public Sede(int id, String citta, String indirizzo, int mq, List<Dipendente> dipendenti) {
		this.id = id;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.mq = mq;
		this.dipendenti = dipendenti;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getMq() {
		return mq;
	}
	public void setMq(int mq) {
		this.mq = mq;
	}
	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}
	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	
}
