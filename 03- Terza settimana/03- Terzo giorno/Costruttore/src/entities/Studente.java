package entities;

public class Studente 
{
	// nome, cognome, classe, mediaIta, mediaMate
			// creare un costruttore nella classe Studente
	public String nome;
	public String cognome;
	public String classe;
	public double mediaIta;
	public double mediaMate;
	public double mediaTot;
	
	public Studente(String nome, String cognome, String classe, Double mediaIta, Double mediaMate) {
		this.nome = nome;
		this.cognome = cognome;
		this.classe = classe;
		this.mediaIta = mediaIta;
		this.mediaMate = mediaMate;
	}
	
	public String scheda() {
		String risp = 	nome		+ 	" "		+	cognome			+	"\n" 	+
						"---- Classe: "			+ 	classe			+	"\n"	+
						"---- Media Ita: "		+	mediaIta		+ 	"\n"	+
						"---- Media mate: "		+ 	mediaMate		+	"\n"	;
				
							
		return risp;
	}
	
	public  Studente(String nome, Double mediaMate, Double mediaIta) {
		this.nome = nome;
		this.mediaMate = mediaMate;
		this.mediaIta = mediaIta;
		this.mediaTot = (mediaMate + mediaIta) /2;
	}
	
	public String scheda2() {
		String risp = 	nome		+ 	" "							+	"\n" 	+
						"---- Media Ita: "		+	mediaIta		+ 	"\n"	+
						"---- Media mate: "		+ 	mediaMate		+	"\n"	+
						"---- Media tot: "		+ 	mediaTot		+	"\n"	;
				
							
		return risp;
	}
}
