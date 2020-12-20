package entities;

import java.util.List;

import utils.Vik;

public class Film 
{
	private int id;
	private String titolo;
	private int annoUscita;
	private int durata;
	private String genere;
	private List<Attore> cast;
	
	// Costruttore
	
	public Film(int id, String titolo, int annoUscita, int durata, String genere,  List<Attore> cast) {
		this.id = id;
		this.titolo = titolo;
		this.annoUscita = annoUscita;
		this.durata = durata;
		this.genere = genere;
		this.cast = cast;
	}
	
	// Tostring
	
	public String toString() {
		return 	"Id: " + 	id		+					"\n"			+
				"Titolo: " + 	titolo		+			"\n"			+
				"Anno uscita: " + 	annoUscita		+	"\n"			+
				"Durata: " + 	durata		+			"\n"			+
				"Durata: " + 	durata		+			"\n"			+
				"Genere: "	+	genere		+			"\n"			+
				"Attori: "	+	Vik.stampaListaAttoriRiga(cast);
	}
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoUscita() {
		return annoUscita;
	}

	public void setAnnoUscita(int annoUscita) {
		this.annoUscita = annoUscita;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public List<Attore> getCast() {
		return cast;
	}

	public void setCast(List<Attore> cast) {
		this.cast = cast;
	}
	
	
	
	
}
