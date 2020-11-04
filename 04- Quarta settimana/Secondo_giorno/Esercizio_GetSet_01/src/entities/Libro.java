package entities;

public class Libro {
	private String nome;
	private String autore;
	private String genere;
	private double prezzo;
	
	public Libro(String nome, String autore, String genere, double prezzo) {
		setNome(nome);
		setAutore(autore);
		setGenere(genere);
		setPrezzo(prezzo);
	}
	public String getNome() {
			return nome;
	}
	public void setNome(String nome) {
		if(nome.length() > 0)
			this.nome =  nome;
		else
			this.nome =  "ERROR - IL NOME DA TE INSERITO NON E' VALIDO";
	}
	
	public String getAutore() {
		return autore;
	}
	
	public void setAutore(String autore) {
		if(autore.length() > 0)
			this.autore =  autore;
		else
			this.autore =  "ERROR - L'AUTORE DA TE INSERITO NON E' VALIDO";
			
	}
	
	public String getGenere() {
		return genere;
	}
	
	public void setGenere(String genere) {
		if(!genere.equalsIgnoreCase("") || !genere.equalsIgnoreCase(" "))
			this.genere =  genere;
		else
			this.genere =  "ERROR - IL GENERE DA TE INSERITO NON E' VALIDO";
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		if(prezzo > 0)
			this.prezzo =  prezzo;
	}
	
	public String toString() {
		return nome + "\n" + "--- Autore: " + autore + "\n" + "--- Genere: " + genere + "\n" + "--- Prezzo: " + prezzo + "€" + "\n" ;
		
	}
}
