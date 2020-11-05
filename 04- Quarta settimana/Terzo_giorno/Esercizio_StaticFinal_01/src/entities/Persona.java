package entities;

public abstract class Persona 
{
	// Propriet� private
	
	private String nome;
	private int eta;
	
	
	// Costruttore di Persona
	
	public Persona(String nome, int eta) {
		setNome(nome);
		setEta(eta);
	}
	
	
	// Getters e setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	// Metodo toString per stampare le propriet� dell'oggetto

	public String toString() {
		return nome + "\n" + "--- Et�: " + eta + "\n";
	}
	
	
	// Metodi abstract, senza corpo
	
	public abstract String esito();
	
	public abstract double media();
}
