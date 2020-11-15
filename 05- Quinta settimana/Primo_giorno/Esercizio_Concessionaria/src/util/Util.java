package util;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Prodotto;

public class Util 
{
	
	// Metodo per ritornare lista di tutti i prodotto di un ArrayList
	
	public static String stampa(ArrayList<Prodotto> lista) {
		String risp = "";
		for(Prodotto p : lista) {
			risp += p.toString() + "\n";
		}
		return risp;
	}
	
	public static boolean continua(Scanner tastiera) {
		System.out.println("\nVuoi effettuare un'altra operazione? Rispondi si o no\n");
		return tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
	}
}
