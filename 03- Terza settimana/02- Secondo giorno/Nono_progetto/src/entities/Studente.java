package entities;

public class Studente 
{
	// Propriet� dell'oggetto: le propriet� sono dati 
	// ai quali vengono assegnati dei valori
	public String nome;
	public int eta;
	public double mediaIta;
	public double mediaMate;
	public int classe;
	
	
	//Metodo: restituisce unvalore di tipo string
	//I metodi sono dati che vengono calcolati
	// Ci� che differenzia propriet� da metodi sono le parentesi tonde
	public String scheda() {
		return nome + " " + eta;
	}
	
	public boolean esito() {
		boolean res = true;
		if(classe == 5 && (mediaIta < 6 || mediaMate < 6))
			res = false;
		if(mediaIta < 6 && mediaMate < 6)
			res = false;
		return res;
	}
}
