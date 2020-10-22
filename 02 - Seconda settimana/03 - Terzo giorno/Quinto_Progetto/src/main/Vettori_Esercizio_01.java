package main;

public class Vettori_Esercizio_01 
{
	public static void main(String[] args) {
		//Siete i gestori di una libreria
		//Utilizzando i vettori, fate in modo di stampare
		//l'elenco dei vostri libri con vicino il prezzo
		//Es.: Il signore degli anelli 20€
		//Alla fine stampate la somma dei prezzi e la media
		
		
		// Dichiarazione e inizializzazione
		String libri[] = new String[5];
		double prezzi[] = new double[5];
		int i = 0;
		String riepilogo = "";
		double totPrezzi = 0;
		
		libri[0] = "Il signore degli anelli";
		libri[1] = "Il condominio";
		libri[2] = "La mostra delle atrocità";
		libri[3] = "Il neuromante";
		libri[4] = "Fight club";
		
		prezzi[0] = 20;
		prezzi[1] = 9.5;
		prezzi[2] = 10;
		prezzi[3] = 12.4;
		prezzi[4] = 8.4;
		
		// Calcolo
		while(i < prezzi.length) {
			riepilogo += "- " + libri[i] + " " + prezzi[i] + "€" + "\n";
			totPrezzi += prezzi[i];
			i++;
		}
		
		//Output
		riepilogo += "\nPrezzo tot: " + totPrezzi + "€\n" + "Media prezzo: " + (totPrezzi / prezzi.length) + "€";
		
		System.out.println(riepilogo);
	}
}
