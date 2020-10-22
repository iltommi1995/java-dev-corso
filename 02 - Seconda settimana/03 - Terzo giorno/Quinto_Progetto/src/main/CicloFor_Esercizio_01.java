package main;

import java.util.Scanner;

public class CicloFor_Esercizio_01 {

	public static void main(String[] args) {
		// Creare vettore di stringhe contentente 5 destinazioni
		// stampare l'intero vettore col ciclo for
		// chiedere a utente dove vuole andare
		// stampare solo destinazione indicata dall'utente
		// solo se è presente tra quelle disponibili
		
		Scanner tastiera = new Scanner(System.in);
		String destinazioneUtente = "";
		
		String destinazioni[] = new String[] {"Londra", "Milano", "Roma", "San Francisco", "San Jose"};
		System.out.println("Queste sono le destinazioni disponibili: ");
		for(int i = 0; i < destinazioni.length; i++) {
			System.out.println((i+1) + "- " + destinazioni[i]);
		}
		System.out.println("Dove vuoi andare?");
		destinazioneUtente = tastiera.nextLine();
		
		boolean trovato = false;
		for(int i = 0; i < destinazioni.length; i++) {
			if(destinazioni[i].equalsIgnoreCase(destinazioneUtente))
				{
				trovato = true;
				System.out.println("Ok, hai scelto di andare a " + destinazioni[i] + ", complimenti!");
				}
		}
		
		
		if(trovato == false) {
			System.out.println("Non c'è la tua destinazione");
		}
	}
}
