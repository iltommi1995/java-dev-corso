package entities;

public class Film {
	private String nome;
	private double prezzo;
	
	public Film(String nome, double prezzo) {
		setNome(nome);
		setPrezzo(prezzo);
	}
	
	public String toString() {
		return nome + " " + prezzo + "€";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
