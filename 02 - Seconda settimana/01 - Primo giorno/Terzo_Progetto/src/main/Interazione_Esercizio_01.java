package main;
import java.util.Scanner;

public class Interazione_Esercizio_01 
{
	public static void main(String[] args) 
	{
		/* Un vostro amico deve organizzare una festa.
		 * chiedetegli quante persone vuole invitare. 
		 * Per OGNO persona chiedere il nome. 
		 * Stampare alla fine, solo una volta, l'elenco degli invitati.
		 */
		
		// Dichiarazione e inizializzazione
		int numPersone = 0;
		String nomiInvitati = "";
		Scanner tastiera = new Scanner(System.in);
		
		// Calcolo
		System.out.println("Quante persone inviti alla festa?");
		numPersone = Integer.parseInt(tastiera.nextLine());
		
		while(numPersone > 0) {
			System.out.println("Dimmi il nome della persona numero " + numPersone);
			nomiInvitati +=  numPersone > 1 ? tastiera.nextLine() + ", " : tastiera.nextLine() + ".";
			numPersone --;
		}
		
		System.out.println("Questo è l'elenco dei nomi: " + nomiInvitati);
		tastiera.close();
	}
}
