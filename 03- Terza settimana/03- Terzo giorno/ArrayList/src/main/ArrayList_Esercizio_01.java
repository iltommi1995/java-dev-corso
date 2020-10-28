package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Libro;

public class ArrayList_Esercizio_01 {
	public static void main(String[] args) 
	{
		// Creare un ArrayList di String
		// Inserire un numweo indefinito di String
		// Stampare l'elenco
		
		// Creare un ArrayList di numeri (interi o double)
		// Inserire un numero indefinito di numeri
		// Stampare la somma dei numeri
		
		// Creare una classe Libro con la proprietà nome e prezzo
		// Creare un ArrayList di oggetti Libro
		// Inserire un numero indefinito di libri
		// Stampare elenco dei libri
		// Stampare la somma dei prezzi
		
		Scanner tastiera = new Scanner(System.in);
		
		
		
		int scelta;
		
		boolean continua = false;
		do {
			System.out.println("Scegli cosa fare:\n" + "1- Stampa elenco parole\n" + "2- Stampa somma numeri\n" + "3- Stampa elenco libri e somma prezzi\n" );
			scelta = Integer.parseInt(tastiera.nextLine());
			String output = "";
			boolean continua1 = false;
			int somma = 0;
			String risposta;
			int rispostaNum;
			ArrayList<String> parole = new ArrayList();
			ArrayList<Integer> numeri = new ArrayList();
			
			ArrayList<Libro> libri = new ArrayList();
			switch(scelta) {
				case 1:
					do {
						System.out.println("Inserisci la parola: ");
						risposta = tastiera.nextLine();
						parole.add(risposta);
						
						System.out.println("\nVuoi aggiungere un'altra parola? Rispondi si o no.");
						continua1 = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
					} while (continua1 == true);
					
					for(int i = 0; i < parole.size(); i++) {
						output += (i+1) + "- " + parole.get(i) + "\n";
					}
					System.out.println(output);
					
					System.out.println("Vuoi fare altro? Rispondi si o no.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				
				case 2:
					do {
						System.out.println("Inserisci il numero intero: ");
						rispostaNum = Integer.parseInt(tastiera.nextLine());
						numeri.add(rispostaNum);
						
						System.out.println("\nVuoi aggiungere un altro numero? Rispondi si o no.");
						continua1 = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
					} while (continua1 == true);
					
					for(int i = 0; i < numeri.size(); i++) {
						output += (i+1) + "- " + numeri.get(i) + "\n";
						somma += numeri.get(i);
					}
					output += "\nE la somma dei numeri è: " + somma;
					System.out.println(output);
					
					System.out.println("Vuoi fare altro? Rispondi si o no.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
					
					
				case 3: 
					do {
						Libro l = new Libro();
						System.out.println("Inserisci il titolo del libro: ");
						risposta = tastiera.nextLine();
						l.nome = risposta;
						
						System.out.println("Inserisci il prezzo del libro: ");
						rispostaNum = Integer.parseInt(tastiera.nextLine());
						l.prezzo = rispostaNum;
						
						libri.add(l);
						
						System.out.println("\nVuoi aggiungere un altro libro? Rispondi si o no.");
						continua1 = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
						
					} while (continua1 == true);
					
					for(int i = 0; i < libri.size(); i++) {
						output += (i+1) + "- " + libri.get(i).scheda() + "\n";
						somma += libri.get(i).prezzo;
					}
					output += "\nE la somma dei prezzi è: " + somma;
					System.out.println(output);
					
					System.out.println("Vuoi fare altro? Rispondi si o no.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				default:
					System.out.println("\nL'operazione da te indicata non è disponibile.\n");
					
					System.out.println("Vuoi fare altro? Rispondi si o no.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
			}
		} while(continua == true);
		
		System.out.println("\nGrazie e ciao");
		tastiera.close();
	}
}
