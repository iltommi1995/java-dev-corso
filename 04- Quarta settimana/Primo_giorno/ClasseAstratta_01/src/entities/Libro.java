package entities;

public class Libro extends Prodotto {
	public int nPagine;
	
	public Libro (String titolo, double prezzo, int nPagine) {
		super(titolo, prezzo);
		this.nPagine = nPagine;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Ciao";
	}

}
