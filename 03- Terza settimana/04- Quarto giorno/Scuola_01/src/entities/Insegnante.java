package entities;

public class Insegnante extends Persona
{	 
	
	public String materia;
	public int anniLavoro;
	public int stipendio = 1000;
	public int pensione;
	
	public Insegnante(String nome, String cognome, String sesso, int eta, String materia, int anniLavoro)
	{
		super(nome, cognome, sesso, eta);
		this.materia = materia;
		this.anniLavoro = anniLavoro;
		
		if(anniLavoro > 10) {
			this.stipendio = 1500;
		}
		if(anniLavoro > 20) {
			this.stipendio = 2000;
		}
		
		switch(sesso.toLowerCase()) {
			case "m":
				this.pensione = 70 - eta;
			break;
			case "f":
				this.pensione = 65 - eta;
			break;
		}
		
	}
	
	public String scheda() {
		 String risp = 			super.scheda() 													+
				 				"---- Materia: " 				+ materia 		+ 	"\n" 		+
				 				"---- Anni di lavoro: " 		+ anniLavoro 	+	"\n" 		+
				 				"---- Stipendio: " 				+ stipendio 	+ 	"€\n"		+
				 				"---- Anni alla pensione: " 	+ pensione		+	"\n"		;
		 return risp;
	 }
}
