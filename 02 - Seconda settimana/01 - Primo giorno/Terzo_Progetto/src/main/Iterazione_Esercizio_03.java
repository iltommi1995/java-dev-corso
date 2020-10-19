package main;

import java.util.Scanner;

public class Iterazione_Esercizio_03 
{
	public static void main(String[] args) 
	{
		/*
		 * Siete il dipendente di una libreria.
		 * Vi chiedono di catalogare una SERIE di libri ma non sapete da subito
		 * quanti sono.
		 * Per ogni libro dovete inserire TITOLO e PREZZO.
		 * Una volta finiti i libri, stampate il riepilogo di tutti i libri 
		 * insieme al TOTALE DEI PREZZI e alla MEDIA DEI PREZZI
		 */
		
		// Dichiarazione e inizializzazione
		
		String titoloLibro = "a";
		String riepilogo = "";
		double prezzoLibro = 0;
		double totalePrezzi = 0;
		int i = 0;
		
		Scanner tastiera = new Scanner(System.in);
		
		// calcolo
		while(!titoloLibro.equalsIgnoreCase("")) {
			i ++;
			System.out.println("\nInserisci il titolo del libro " + i);
			titoloLibro = tastiera.nextLine();
			if (titoloLibro.equals(""))
				titoloLibro = "";
			else {
				riepilogo += "\n" + i + "- " + titoloLibro;
				System.out.println("\nInserisci il prezzo del libro " + i);
				prezzoLibro = Double.parseDouble(tastiera.nextLine());
				totalePrezzi += prezzoLibro;
				riepilogo +=  "- costa " + prezzoLibro + "€";
			}
		}
		System.out.println("\n" + riepilogo + "\n" + "Il totale dei prezzi è: " + totalePrezzi + "\n" + "La media dei prezzi è: " + (totalePrezzi / (i -1)));
		tastiera.close();
	}
}
