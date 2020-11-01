package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Terminale;

public class MainNegozio {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Stampare l'elenco di tutti i prodotti
		 * Stampare l'elenco di tutti i film
		 * stampare l'elenco di tutti i libri
		 * stampare la media delle pagine dei libri
		 * stampare la media delle pagine di genere horror
		 * stampare la durata media dei film in ore
		 * stampare la durata totale dei film di genere avventura
		 * stampare l'elenco dei libri che fanno parte di una serie
		 */
		boolean continua = false;
		Terminale output = new Terminale();
		Scanner tastiera = new Scanner(System.in);
		
		do {
			System.out.println(output.output());
		
			System.out.println("\nVuoi effettuare altre operazioni? Rispondi si o no.");
			continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
		} while(continua == true);
		
	
		System.out.println("\nCiao e alla prossima!");
	}

}
