package utils;

import java.util.List;
import java.util.Scanner;

import entities.Attore;
import entities.Film;

public class Vik
{
	
	public static String stampaListaAttori(List<Attore> lista) {
		String ris = "";
		
		for(Attore a : lista) {
			ris += "\n" + a.toString() + "\n\n--------\n";
		}
		
		return ris;
	}
	
	public static String stampaListaAttoriRiga(List<Attore> lista) {
		String ris = "[ ";
		
		for(Attore a : lista) {
			ris += a.getNome() + " " + a.getCognome() + ", ";
		}
		
		ris += " ]";
		
		return ris;
	}
	
	public static String stampaListaFilm(List<Film> lista) {
		String ris = "";
		
		for(Film a : lista) {
			ris += "\n" + a.toString() + "\n\n--------\n";
		}
		
		return ris;
	}
	
	
	// Metodo per continuare con le opzioni
	
	public static boolean continua(Scanner tastiera) {
		System.out.println("\nVuoi effettuare un'altra operazione?");
		return tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
	}
}
