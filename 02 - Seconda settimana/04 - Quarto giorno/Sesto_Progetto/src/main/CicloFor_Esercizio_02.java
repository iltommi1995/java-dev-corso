package main;

import java.util.Scanner;

public class CicloFor_Esercizio_02 
{
	public static void main(String[] args) 
	{
		//Siete i responsabili di una libreria
		//Create un vettore di titoli, uno di autori e uno di prezzi
		//Chiedete all'utente quale azione vuole eseguire tra:
		//1 - Elenco completo
		//2 - Cerca per titolo
		//3 - Cerca per autore
		//Se sceglie 1, stampare l'elenco completo:
		//Titolo: 
		//Autore:
		//Prezzo:
		//Per ogni libro
		//Se compie una ricerca per titolo, stampare la scheda solo del libro scelto
		//Se compie una ricerca per autore, stampare l'elenco dei titoli di quell'autore
		
		
		// Dichiarazione & Inizializzazione
		
		String titoli[] = new String[] {"Il signore degli anelli", "Il condominio", "Il neuromante", "Fight club", "Cocaine Nights"};
		String autori[] = new String[] {"Tolkien", "Ballard", "Gibson", " Palahniuk", "Ballard"};
		double prezzi[] = new double[] {20.5, 12.4, 10, 7.6, 9};
		
		int scelta;
		String elencoCompleto = "";
		String titolo = "";
		boolean libroTrovato = false;
		String schedaLibro = "";
		boolean autoreTrovato = false;
		String schedaAutore = "";
		boolean again = false;
		
		Scanner tastiera = new Scanner(System.in);
		
		do {
			System.out.println(
					"Benvenuto nella nostra libreria virtuale, seleziona il numero dell'opzione che ti interessa:" + "\n" +
					"1- Vedi l'elenco completo dei libri;"	+ "\n" + 
					"2- Cerca i libri per titolo;" + "\n" +
					"3- Cerca i libri per autore;" + "\n"
				);
			scelta = Integer.parseInt(tastiera.nextLine());
			switch(scelta) {
			
				// Stampa la scheda di tutti i libri
				case 1:
					for(int i = 0; i < titoli.length; i++) {
						elencoCompleto += i+1 + "- " + titoli[i] + ", " + autori[i] + ", costo " + prezzi[i] + "€\n";
					}
					System.out.println(elencoCompleto);
					break;
					
				// Ricerca per titolo
				case 2:
					do {
						System.out.println("Hai scelto di cercar i libri per titolo, inserisci il titolo del libro:");
						titolo = tastiera.nextLine();
						
						for(int i = 0; i < titoli.length; i++) {
							if(titolo.equalsIgnoreCase(titoli[i])) {
								libroTrovato = true;
								schedaLibro = "- " + titoli[i] + ", " + autori[i] + ", costo " + prezzi[i] + "€\n";
								System.out.println(schedaLibro);
							}
						}
						if(libroTrovato == false) {
							System.out.println("Mi dispiace ma non abbiamo il libro che hai cercato, vuoi provare di nuovo? Rispondi 'si' o 'no'.");
							again = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
						}
						System.out.println("\nVuoi cercare un altro libro per titolo?");
						again = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
						libroTrovato = (again == true) ? true : false;
					}
					while(again == true);
					break;
					
				// Ricerca per autore
				case 3:
					do {
						System.out.println("Hai scelto di cercar i libri per autore, inserisci il cognome dell'autore:");
						titolo = tastiera.nextLine();
						
						for(int i = 0; i < autori.length; i++) {
							if(titolo.equalsIgnoreCase(autori[i])) {
								autoreTrovato = true;
								schedaAutore = "- " + titoli[i] + ", " + autori[i] + ", costo " + prezzi[i] + "€\n";
								System.out.println(schedaAutore);
							}
						}
						if(autoreTrovato == false) {
							System.out.println("Mi dispiace ma non abbiamo libri per l'autore che hai scelto, vuoi provare di nuovo? Rispondi 'si' o 'no'.");
							again = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
						}
						System.out.println("\nVuoi cercare un altro libro per autore?");
						again = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
						autoreTrovato = (again == true) ? true : false;
						}
						while(again == true);
					break;
				
			// Inserimento di valore non corretto
			default:
				again = true;
				System.out.println("Non hai inserito un valore corretto, riprova!\n");
				break;
			}
			
			// Verifica per eseguire altre operazioni
			
			System.out.println("Vuoi eseguire altre operazioni? Rispondi 'si' o 'no'.\n");
			again = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
			
		}
		while(again == true);
		
		System.out.println("\nGrazie per averci scelto e alla prossima!");
		
		tastiera.close();
	}
}
