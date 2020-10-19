package main;

import java.util.Scanner;

public class Iterazione_Esercizio_02 
{
	public static void main(String[] args) 
	{
		/*
		 * Volete organizzare una festa per un vostro amico che compie gli anni
		 * Creiamo un programma che chieda all'utente il numero di invitati
		 * Facciamo in modo che per ogni invitato chieda il nome
		 * Definiamo un budget per il regalo e diamo la possibilità ad ognuno di dire quanti soldi vuole mettere
		 * Per ogni utente, stampiamo il valore del budget rimanente.
		 * quando il budget è uguale a zero.
		 * Nel caso in cui i soldi non siano abbastanza per coprire il budget, stampare quanto manca.
		 * Alla fine stampare un riepilogo che tenga in considerazione il nome dell'invitato e il budget
		 */
		
		int numPersone = 0;
		String riepilogoInvitati = "";
		int budget = 50;
		int quota = 0;
		Scanner tastiera = new Scanner(System.in);
		
		// Calcolo
		System.out.println("Quante persone inviti alla festa?");
		numPersone = Integer.parseInt(tastiera.nextLine());
		
		while(numPersone > 0) {
			System.out.println("\nDimmi il nome della persona numero " + numPersone);
			riepilogoInvitati +=  numPersone + ") " + tastiera.nextLine() + " mette "; 
			System.out.println("\nOra dimmi quanti euro mette.");
			quota = Integer.parseInt(tastiera.nextLine());
			budget += - quota;
			riepilogoInvitati += quota + "€" + "\n";
			System.out.println("\nMancano da mettere " + budget + "€");
			
			numPersone --;
		}
		
		System.out.println("\nRiepilogo finale: \n" + riepilogoInvitati + "\n mancano da mettere " + budget + "€");
		tastiera.close();
	}
}
