package main;

import java.util.Scanner;

public class MainViaggi {

	public static void main(String[] args) 
	{
		/*
		 * Chiedete all'utente quanti viaggi vuole inserire
		 * Per ogni viaggio fatevi passare i seguenti valori:
		 * destinazione, prezzoBase, periodoMigliore
		 * stampare ELENCO DEI VIAGGI
		 * stampare SOMMA DEI PREZZI
		 */
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Quanti viaggi vuoi inserire?");
		int nViaggi = Integer.parseInt(tastiera.nextLine());
		
		Viaggio[] viaggi = new Viaggio[nViaggi];
		Viaggio v;
		int indice = 0;
		
		//String riepilogo = "";
		//int counter = 1;
		
		double sommaPrezzi = 0;
		
		while(indice < nViaggi) {
			v = new Viaggio();
			
			System.out.println("Inserisci la destinazione:");
			v.destinazione = tastiera.nextLine();
			System.out.println("Inserisci il prezzo base:");
			v.prezzoBase = Double.parseDouble(tastiera.nextLine());
			System.out.println("Inserisci il periodo migliore:");
			v.periodoMigliore = tastiera.nextLine();
			
			viaggi[indice] = v;
			
			indice ++;
		}
		
		String elenco = "";
		
		for(int i = 0; i < viaggi.length; i++) {
			elenco += (i+1) + "- " + viaggi[i].stampaViaggio() + "\n";
			sommaPrezzi += viaggi[i].prezzoBase;
		}
		
		
		/*Viaggio elencoViaggi = new Viaggio();
		for( int i = nViaggi; i > 0; i--) {
			System.out.println("Inserisci la destinazione:");
			elencoViaggi.destinazione = tastiera.nextLine();
			System.out.println("Inserisci il prezzo base:");
			elencoViaggi.prezzoBase = Double.parseDouble(tastiera.nextLine());
			System.out.println("Inserisci il periodo migliore:");
			elencoViaggi.periodoMigliore = tastiera.nextLine();
			
			riepilogo += counter + "- " + elencoViaggi.stampaViaggio() + "\n";
			sommaPrezzi += elencoViaggi.prezzoBase;
			counter ++;
		}*/
		
		System.out.println("Ecco l'elenco dei viaggi:\n\n" + elenco + "\n\nEd ecco la somma dei prezzi: " + sommaPrezzi + "€");
		tastiera.close();
	}

}
