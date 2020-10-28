package entities;

public class Libro 
{
	public String titolo;
	public String autore;
	public int prezzo;
	
	public Libro(String titolo, String autore, int prezzo)
	{
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
	};
	
	public String scheda() {
		return titolo + " " + autore + " " + prezzo + "€";
	}
}
