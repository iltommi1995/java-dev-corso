package main;

import java.util.Scanner;

public class Selezione_Esercizio_00 
{
	public static void main(String[] args) 
	{
		/* Chiedere all'utente l'anno di nascita
		 * Calcolare l'età
		 * Se è maggiorenne chiedegli cosa vuole da bere
		 * Se sceglie la birra, il ticket è 3.5€
		 * Se sceglie la coca cola, il ticket è 2.5€
		 * Se sceglie il vino, il ticket è 5€
		 * Stampare come risposta il valore del ticket
		 * Se è minorenne stampare il messaggio per cui non può entrare
		 * Stampare la risposta in caso sia maggiorenne o minorenne
		 */
		
		// Dichiarazione
		
		Scanner tastiera = new Scanner(System.in);
		
		int annoNascita, eta;
		String drink;
		double ticket;
		
		
		System.out.println("Quando sei nato?");
		annoNascita = Integer.parseInt(tastiera.nextLine());
		eta = 2020 - annoNascita;
		
		if(eta >= 18) {
			System.out.println("Puoi bere. Cosa vuoi bere?");
			drink = tastiera.nextLine();
			if(
					!drink.equalsIgnoreCase("birra") ||
					!drink.equalsIgnoreCase("coca cola") ||
					!drink.equalsIgnoreCase("vino"))
				ticket = 8;
			else
				ticket = 10;
			if(drink.equalsIgnoreCase("birra")) {
				ticket = 3.5;
			}
			if(drink.equalsIgnoreCase("coca cola")) {
				ticket = 2.5;
			}
			if(drink.equalsIgnoreCase("vino")) {
				ticket = 5;
			}
	
			System.out.println("Dovrai pagare" + ticket + "€");
		} else { 
			System.out.println("Non puoi bere!");
		}
		
		tastiera.close();
	}
}
