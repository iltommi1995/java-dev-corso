package entities;

public class Studente extends Persona {
	public String classe;
	public double mediaIta;
	public double mediaMate;
	
	public Studente(String nome, String cognome, int eta, String classe, double mediaIta, double mediaMate) {
		super(nome, cognome, eta);
		this.classe = classe;
		this.mediaIta = mediaIta;
		this.mediaMate = mediaMate;
	}
	
	public String esito() {
		int anno = Integer.parseInt(classe.split("")[0]);
		String esito = "Promosso";
		if (anno == 3 && (mediaIta < 6 || mediaMate < 6)) {
			esito = "Bocciato";
		}
		if((anno < 3 & anno >= 1) & (mediaIta < 6 && mediaMate < 6)) {
			esito = "Bocciato";
		}
		return esito;
	}
	
	private double media() {
		return (mediaIta + mediaMate)/2;
	}

	public String toString() {
		String res =	nome 						+ 	" " 		+ 	cognome	+ "\n"	+
						"--- Età: "					+ 	eta 		+		"\n"		+
						"--- Classe: "				+	classe		+	 	"\n"		+
						"--- Media italiano: "		+	mediaIta	+		"\n"		+
						"--- Media matematica: "	+	mediaMate	+		"\n"		+
						"--- Esito: "				+	esito()		+		"\n"		+
						"--- Media: "				+	media()		+		"\n"		;
		return res;	
	}
	
	
}
