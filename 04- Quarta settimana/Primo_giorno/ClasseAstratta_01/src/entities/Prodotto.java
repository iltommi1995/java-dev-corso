package entities;

public abstract class Prodotto {
	protected String titolo;
	protected double prezzo;
	
	public Prodotto (String titolo, double prezzo) {
		this.titolo = titolo;
		this.prezzo = prezzo;
	}
	
	public abstract String toString();
}
