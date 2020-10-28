package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Esercizio_Ripasso_2 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		/*
		 * Creare un programma con un menu di questo tipo:
		 * 1- Inserisci libro
		 * 2- Inserisci studente
		 * 
		 * Se l'utente sceglie 1
		 * chiedere di inserire il titolo e prezzo
		 * A questo punto, sempre nel punto 1
		 * chiedere all'utente se vuole vedere l'elenco o la media
		 * dei prezzi
		 * Stampare la risposta in base alla scelta
		 * 
		 * Se l'utente sceglie 2
		 * Chiedere di inserire nome e mediaIta e media mate oer igni studente che vorra
		 * A questo punto, sempre nel punto 2
		 * Chiedere all'utente se vuole vedere l'elenco o la media di italiano e media mate
		 * Stampare la risposta in base alla scelta.
		 */
		
		Scanner tastiera = new Scanner(System.in);
		
		int scelta;
		boolean cicloEsterno = false;
		boolean cicloInterno = false;
		String riassunto = "";
		double prezzoSingolo = 0;
		double totPrezzi = 0;
		int counterLibri = 1;
		
		int counterStudenti = 1;
		String riassuntoStudenti = "";
		double votoSingolo = 0;
		double mediaMate = 0;
		double mediaIta = 0;
		
		//String percorsoFile = "";
		//Scanner file = new Scanner(new File(percorsoFile));
		do {
			System.out.println("Scegli che fare:" + "\n1- Inserisci libro" + "\n2- Inserisci studente");
			scelta = Integer.parseInt(tastiera.nextLine());
			
			switch(scelta) {
			
				//Prima opzione, inserimento libri
			
				case 1:
					
					do {
						System.out.println("\nInserisci il titolo del libro " + counterLibri);
						riassunto += counterLibri + "- " + tastiera.nextLine();
						System.out.println("\nInserisci il prezzo del libro " + counterLibri);
						prezzoSingolo = Double.parseDouble(tastiera.nextLine());
						riassunto += "------ prezzo: " + prezzoSingolo + "€\n";
						totPrezzi += prezzoSingolo;
						
						System.out.println("\nPer ora hai inserito " + counterLibri + " libri. Vuoi inserire un altro libro? Rispondi si o no.");
						cicloInterno = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
						
						counterLibri ++;
					}
					while(cicloInterno == true);
					
					System.out.println("\nScegli che fare:" + "\n1- Vedi elenco libri" + "\n2- Vedi media prezzi");
					switch(Integer.parseInt(tastiera.nextLine())) {
					
						// Utente vuole vedere lista libri
						case 1:
							System.out.println("\nEcco l'elenco dei libri:\n" + riassunto) ;
						break;
						
						// Utente vuole vedere il prezzo medio
						case 2:
							System.out.println("\nLa media dei prezzi è: " + (totPrezzi / counterLibri)) ;
						break;
					}
					
					// Far ripartire ciclo interno o tornare a quello esterno?
					
					System.out.println("\nVuoi fare altro? Rispondi si o no");
					cicloEsterno = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				
				// Seconda opzione: inserimento studenti con voti di mate e ita
				
				case 2:
					
					do {
						System.out.println("\nInserisci il nome dello studente numero " + counterStudenti);
						riassuntoStudenti += counterStudenti + "- " + tastiera.nextLine();
						System.out.println("\nInserisci la media di matematica dello studente numero " + counterStudenti);
						votoSingolo = Double.parseDouble(tastiera.nextLine());
						riassuntoStudenti += "------ Media matematica: " + votoSingolo ;
						mediaMate += votoSingolo;
						System.out.println("\nInserisci la media di italiano dello studente numero " + counterStudenti);
						votoSingolo = Double.parseDouble(tastiera.nextLine());
						riassuntoStudenti += "------ Media italiano: " + votoSingolo + "\n" ;
						mediaIta += votoSingolo;
						
						System.out.println("\nPer ora hai inserito " + counterStudenti + " studenti. Vuoi inserire un altro studente? Rispondi si o no.");
						cicloInterno = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
						
						counterStudenti ++;
					}
					while(cicloInterno == true);
					
					System.out.println("Scegli che fare:" + "\n1- Vedi elenco studenti" + "\n2- Vedi media mate e media ita");
					switch(Integer.parseInt(tastiera.nextLine())) {
					
						// Utente vuole vedere lista libri
						case 1:
							System.out.println("\nEcco l'elenco degli studenti:\n" + riassuntoStudenti) ;
						break;
						
						// Utente vuole vedere il prezzo medio
						case 2:
							System.out.println("\nLa media di mate è: " + (mediaMate / counterStudenti) + "\n" + "La media di ita è: " + (mediaIta / counterStudenti)) ;
						break;
					}
					
					// Far ripartire ciclo interno o tornare a quello esterno?
					
					System.out.println("Vuoi fare altro? Rispondi si o no\n");
					cicloEsterno = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
		
				
				// Inserito un valore numerico scorretto
				
				default:
					System.out.println("Hai inserito un valore scorretto, vuoi ricominciare? Rispondi si o no\n");
					cicloEsterno = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
			}
		}
		// Condizione per ciclo esterno riparte o no
		while(cicloEsterno == true);
		
		System.out.println("Grazie e alla prossima!");
		
		tastiera.close();

	}
}
