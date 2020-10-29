package entities;

public class Persona {
	protected String nome;
	protected String cognome;
	protected String sesso;
	protected int eta;
	
	public Persona(String nome, String cognome, String sesso, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.eta = eta;
	}
	
	public String scheda() {
		String risp = 	nome 						+ 	" " 		+ 	cognome 	+ 		"\n" 		+
		 				"---- Sesso: " 				+ 	sesso	 					+ 		"\n" 		+
		 				"---- Età: "   				+ 	eta		 					+ 		"\n" 		;
		return risp;
	}
}
