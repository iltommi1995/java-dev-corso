package entities;

public class Studente extends Persona
{
	 public int classe;
	 public double mediaIta;
	 public double mediaMate;
	 public double mediaFra;
	 public double mediaIng;
	 public double mediaTot;
	 public boolean esito = true;
	 public boolean erasmus = false;
	 public int insuf = 0;
	 
	 public Studente(String nome, String cognome, String sesso, int eta, int classe, double mediaIta, double mediaMate, double mediaFra, double mediaIng) 
	 {
		 super(nome, cognome, sesso, eta);
		 this.classe = classe;
		 this.mediaIta = mediaIta;
		 this.mediaMate = mediaMate;
		 this.mediaFra = mediaFra;
		 this.mediaIng = mediaIng;
		 this.mediaTot = (mediaIta + mediaMate + mediaFra + mediaIng)/4;
		 
		 
		 if(mediaIta < 6)
			 this.insuf++;
		 if(mediaMate < 6)
			 this.insuf++;
		 if(mediaFra < 6)
			 this.insuf++;
		 if(mediaIng < 6)
			 this.insuf++;
		 
		 if(classe == 3 && this.insuf > 1) 
			 this.esito = false;
		 if((classe < 3 && classe >= 1) && this.insuf > 2)
			 this.esito = false;
		 
		 if((this.esito == true) && (mediaIng > 8 || mediaFra > 8))
			 this.erasmus = true;
	 }
	 
	 
	 public String scheda() {
		 String esitoStu = this.esito == true ? "Promosso" : "Bocciato";
		 String eras = this.erasmus == true ? "Ammesso" : "Non ammesso";
		 
		 String risp = 	super.scheda()																	+
				 		"---- Classe: " 			+ 	classe 						+ 		"\n" 		+
				 		"---- Media italiano: " 	+	mediaIta 					+		"\n" 		+
				 		"---- Media matematica: " 	+ 	mediaMate 					+ 		"\n"		+
				 		"---- Media francese: " 	+	mediaFra					+		"\n"		+
				 		"---- Media inglese: "		+ 	mediaIng					+		"\n"		+
				 		"---- Media totale: "		+ 	mediaTot					+ 		"\n"		+
				 		"---- Esito: "				+ 	esitoStu					+		"\n"		+
				 		"---- Erasmus: "			+ 	eras						+		"\n"		+
				 		"---- Numero insuf: "		+ 	insuf 						+ 		"\n"		;
		 return risp;
	 }
}
