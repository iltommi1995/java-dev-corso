package main;

public class Libro 
{
	public String autore;
	public String titolo; 
	public String genere;
	public Double prezzo;
	
	public String stampaLibro() {
		String ris = "- " + autore + ", " + titolo + ", " + genere + ", " + prezzo + "€\n";
		return ris;
	}
}
