package main;

import java.util.Scanner;

public class Esercizio_WhileDoWhile_2 
{
	public static void main(String[] args) 
	{
		//Traccia 2
		//Chiedete all'utente qual è il suo piatto preferito
		//Alla fine ponete la stessa domanda agli altri eventuali utenti
		//finché ce ne sono
		//Stampare l'elenco degli utenti con il nome dei loro piatti preferiti
		
		// Dichiarazione
		
		Scanner tastiera = new Scanner(System.in);
		
		int i = 0;
		String piattoPreferito;
		String riepilogo = "";
		boolean continua = false;
		
		do {
			i++;
			System.out.println("Qual è il tuo piatto preferito?");
			piattoPreferito = tastiera.nextLine();
			riepilogo += "Il piatto preferito dell'utente numero " + i + " è: " + piattoPreferito + "\n";
			
			System.out.println("Vuoi aggiungere il piatto preferito di un altro utente? rispondi si o no");
			continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
		}
		while(continua == true);
		System.out.println(riepilogo);
		
		tastiera.close();
	}
}
