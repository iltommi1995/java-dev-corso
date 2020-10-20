package main;

import java.util.Scanner;

public class Esercizio_Ripasso_02 
{
	public static void main(String[] args) 
	{
		// Siete il cameriere di una pizzeria
		// Prendete gli ordini per ogni tavolo senza sapere QUANTI SONO GLI OSPITI.
		// Per ogni ospite chiedete cosa vuole DA MANGIARE e cosa vuole DA BERE:
		// PIZZA MARGHERITA 5
		// PIZZA 4 STAGIONI 7
		// PIZZA MARINARA 4
		// PIZZA ESPLOSIVA 10 
		// BIRRA 3.5
		// COCA COLA 2.5
		// ACQUA 1.5
		// Dopo aver preso l'ordine di ogni ospite il programma chiederà se deve prendere un nuovo ordine
		// Alla fine, stampate il riepilogo contenente gli ordini di tutti gli ospiti
		// con il prezzo singolo per ogni ospite 
		// Inoltre stampate il PREZZO TOTALE e la MEDIA DEI PREZZI
		
		// Dichiarazione
		
		boolean nuovoOspite;
		boolean nuovoOrdine;
		
		String ciboSingolo;
		double prezzoCiboSingolo;
		String bereSingolo;
		double prezzoBereSingolo;
		
		String riepilogoSingoloOrdine="";
		String riepilogoTuttiOrdini="";
		
		double ciboTot;
		double bereTot;
		double prezzoTot = 0;
		int numPersone = 0;
		int numOrdine = 0;
		
		Scanner tastiera = new Scanner(System.in);
		
		// Calcolo
		
		System.out.println("Vuoi fare un nuovo ordine? Rispondi si o no");
		nuovoOrdine = tastiera.nextLine().equalsIgnoreCase("si") ? true :false;
		
		while(nuovoOrdine == true) {
			nuovoOspite = true;
			numPersone = 0;
			prezzoTot = 0;
			numOrdine ++;
			riepilogoSingoloOrdine = "Riepilogo ordine numero " + numOrdine + "\n";
			while(nuovoOspite == true) {
				numPersone ++;
				System.out.println("\nCosa vuole mangiare l'ospite numero " + numPersone + " dell'ordine numeo " + numOrdine + "?");
				ciboSingolo = tastiera.nextLine();
			
				switch(ciboSingolo.toLowerCase()) {
				case "margherita":
					prezzoCiboSingolo = 5;
				break;
				case "4 stagioni":
					prezzoCiboSingolo = 7;
				break;
				case "marinara":
					prezzoCiboSingolo = 4;
				break;
				case "esplosiva":
					prezzoCiboSingolo = 10;
				break;
				default:
					prezzoCiboSingolo = 5;
				break;
				}
				
				System.out.println("Cosa vuole bere l'ospite numero " + numPersone + " dell'ordine numeo " + numOrdine + "?");
				bereSingolo = tastiera.nextLine();
				
				switch(bereSingolo.toLowerCase()) {
				case "birra":
					prezzoBereSingolo = 3.5;
				break;
				case "coca cola":
					prezzoBereSingolo = 2.5;
				break;
				case "acqua":
					prezzoBereSingolo = 1.5;
				break;
				default:
					prezzoBereSingolo = 3;
				break;
				}
				
				
				prezzoTot += prezzoCiboSingolo + prezzoBereSingolo;
				riepilogoSingoloOrdine += "L'ospite numero " + numPersone + " paga " + prezzoCiboSingolo + "€ per il cibo e " + prezzoBereSingolo + "€ per la bibita;\n";
				
				System.out.println("L'ospite numero " + numPersone + " paga " + prezzoCiboSingolo + "€ per il cibo e " + prezzoBereSingolo + "€ per la bibita;" );
				
				System.out.println("\nOk, vuoi aggiungere una persona all'ordine? rispondi si o no.");
				
				nuovoOspite = tastiera.nextLine().equalsIgnoreCase("si") ? true :false;
			}
			
			riepilogoSingoloOrdine +=  "Prezzo totale ordine: " + prezzoTot + "\nmedia per persona: " + (prezzoTot/numPersone) + "\n";
			
			System.out.println("\n" + riepilogoSingoloOrdine);
			riepilogoTuttiOrdini += riepilogoSingoloOrdine + "\n";
			System.out.println("\nVuoi fare un nuovo ordine?");
			nuovoOrdine = tastiera.nextLine().equalsIgnoreCase("si") ? true :false;
		}
		
		System.out.println("\n" + "RIEPILOGO TOTALE:" + "\n\n" + riepilogoTuttiOrdini);
		
		System.out.println("\n" + "Ciao, alla prossima!");
		
		tastiera.close();
	}
}
