package entities;

public class Insegnante 
{
	public String nome;
	public int eta;
	public String materia;
	public double stipendio;
	
	
	public String scheda() {
		return 	nome 				+ "\n" 					+
				"---- età: " 		+	eta			+ "\n"	+
				"---- materia: " 	+ 	materia 	+ "\n"	+
				"---- stipendio: "	+	stipendio	+ "€"		;
				
	}
}
