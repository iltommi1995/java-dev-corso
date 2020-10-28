package entities;

public class Libro {
	public String nome;
	public int prezzo;
	
	public String scheda() {
		return nome + "\n" + "---- prezzo: " + prezzo + "€";
	}

}
