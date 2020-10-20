package main;

import java.util.Scanner;

public class Esercizio_WhileDoWhile_01 
{
	public static void main(String[] args) 
	{
		// Traccia 1:
		// Inserite il titolo e il prezzo di 5 libri
		// Stampate l'elenco dei titoli e il totale dei prezzi
		
		// Inizializzazione
		
		Scanner tastiera = new Scanner(System.in);
		
		int i = 0;
		String titoloLibro;
		double prezzoLibro;
		double prezzoTotale = 0;
		String riepilogo = "";
		
		while(i < 5) {
			i ++;
			System.out.println("Iserisci il titolo del libro numero " + i);
			titoloLibro = tastiera.nextLine();
			System.out.println("Ora inserisci il prezzo del libro numero " + i);
			prezzoLibro = Double.parseDouble(tastiera.nextLine());
			
			prezzoTotale += prezzoLibro;
			
			riepilogo += "1) " + titoloLibro + " ---- prezzo: " + prezzoLibro + "€\n";
		};
		riepilogo += "\nPrezzo totale = " + prezzoTotale + "€";
		
		System.out.println(riepilogo);
		tastiera.close();
	}
}
