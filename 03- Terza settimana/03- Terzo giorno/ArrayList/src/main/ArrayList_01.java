package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_01 {

	public static void main(String[] args) 
	{
		// Usiamo un arraylist nel quale inseriamo un numero imprecisato di string
		ArrayList<String> elenco;
		
		elenco = new ArrayList<String>();
		System.out.println("Dimensione elenco: " + elenco.size());
		
		Scanner tastiera = new Scanner(System.in);
		String risposta;
		String titolo;
		do {
			System.out.println("Inserisci un titolo");
			titolo = tastiera.nextLine();
			
			elenco.add(titolo);
			System.out.println("Dimensione elenco: " + elenco.size());
			System.out.println("Vuoi inserire un nuovo titolo?");
			risposta = tastiera.nextLine();
			
		} while(!risposta.equalsIgnoreCase("no"));
		
		String stampa = "";
		
		for(int i = 0; i < elenco.size(); i++) {
			stampa += (i+1) + "- " + elenco.get(i) + "\n";
		}
		
		System.out.println(stampa);
	}

}
