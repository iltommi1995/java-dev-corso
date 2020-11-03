package entities;

public class Insegnante extends Persona {
	protected String materia;
	protected int anniLavoro;
	
	public Insegnante(String nome, String cognome, int eta, String materia, int anniLavoro) {
		super(nome, cognome, eta);
		this.materia = materia;
		this.anniLavoro = anniLavoro;
	}
	
	public double stipendio() {
		double stipendio = 1000;
		
		if(anniLavoro > 5) {
			stipendio += 400;
		}
		
		if(anniLavoro > 10) {
			stipendio += 400;
		}
		
		if(anniLavoro > 20) {
			stipendio += 500;
		}
		
		return stipendio;
	}
	
	public String toString() {
		String res =	nome 						+ 	" " 		+ cognome	+ "\n"	+
						"--- Età: "					+ 	eta 		+		"\n"		+
						"--- Materia: "				+ 	materia 	+		"\n"		+
						"--- Anni Lavoro: "			+	anniLavoro	+	 	"\n"		+
						"--- Stipendio: "			+	stipendio()	+		"\n"		;
		return res;	
	}
}
