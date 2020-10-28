package main;

public class Studente 
{
	public String nome;
	public int eta;
	public int classe;
	public double mediaIta;
	public double mediaMate;
	
	public String scheda() {
		return  
				"Nome: " + nome + "\n" 				+ 
				"Età: " + eta + "\n" 				+ 
				"Classe: " + classe + "\n" 			+ 
				"Media ita: " + mediaIta + "/10\n" 	+ 
				"Media mate: " + mediaMate + "/10"	;
	}
}
