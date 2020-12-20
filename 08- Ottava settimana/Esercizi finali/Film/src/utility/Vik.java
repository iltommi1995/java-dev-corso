package utility;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import entities.Film;

public class Vik {
	
	public static final int MINCHAR = 2;
	public static final int MAXCHAR = 200;
	
	public static final int MINNUM = 1;
	public static final int MAXNUM = 3000;
	
	//controllo stringhe
	public static boolean controlloString(int min, int max, String parametro) {
		boolean ris = false;
		if(parametro.length() >= min && parametro.length() <= max)
			ris = true;
		return ris;
	}
	
	//controllo int
	public static boolean controlloInt(int min, int max, int parametro) {
		boolean ris = false;
		if(parametro >= min && parametro <= max)
			ris = true;
		return ris;
	}
	
	//controllo double
	public static boolean controlloDouble(int min, int max, double parametro) {
		boolean ris = false;
		if(parametro >= min && parametro <= max)
			ris = true;
		return ris;
	}
	
	//controllo boolean
	public static boolean controlloBoolean(String parametro) {
		boolean ris = false;
		if(parametro.equalsIgnoreCase("si") || parametro.equalsIgnoreCase("sì") || parametro.equalsIgnoreCase("no"))
			ris = true;
		return ris;
	}
	
	//controllo Film
	public static boolean controlloFilm(int id, int year, int length, String title, String subject, int popularity,
			String award) {
		boolean ris = false;
		if(
				Vik.controlloInt(MINNUM, MAXNUM, id) &&
				Vik.controlloInt(MINNUM, MAXNUM, year) &&
				Vik.controlloInt(MINNUM, MAXNUM, length) &&
				Vik.controlloString(MINCHAR, MAXCHAR, title) &&
				Vik.controlloString(MINCHAR, MAXCHAR, subject) &&
				Vik.controlloInt(MINNUM, MAXNUM, popularity) &&
				Vik.controlloBoolean(award))
			ris = true;
		return ris;
	}
	
	//controllo Person
	public static boolean controlloPerson(String name, String type) {
		boolean ris = false;
		if(Vik.controlloString(MINCHAR, MAXCHAR, name) &&
				Vik.controlloString(MINCHAR, MAXCHAR, type))
			ris = true;
		return ris;
	}
	
	//stampa AL di Film
	public static String stampaFilm(ArrayList<Film> film) {
		String ris = "";
		for(Film f : film)
			ris += f.toString() + "\n";
		return ris;
	}
	
	//stampa AL di String
	public static String stampaALString(ArrayList<String> string) {
		String ris = "";
		for(String s : string)
			ris += s.toString() + "\n";
		return ris;
	}
	
	//stampa Mappa Integer
	public static String stampaMapInteger(Map<String, Integer> mappaInt) {
		String ris = "";
        for(String s : mappaInt.keySet()) {
            ris += s + ":" + mappaInt.get(s) + "\n";
        }
		return ris;
	}
		
	//stampa Mappa Double
	public static String stampaMapDouble(Map<String, Double> mappaDoub) {
		String ris = "";
        for(String s : mappaDoub.keySet()) {
            ris += s + ":" + mappaDoub.get(s) + "€\n";
        }
		return ris;
	}
	
	//chiedere a utente se vuole fare altre ricerche (con parametro tastiera)
	public static boolean continua(Scanner tastiera) {	
		System.out.println("Vuoi fare un'altra operazione? (si/no)");
		return tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
	}
	
}
