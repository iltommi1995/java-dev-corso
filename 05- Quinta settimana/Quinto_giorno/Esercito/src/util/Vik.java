package util;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Unita;

public class Vik 
{
	public static final int min = 1;
	public static final int max = 100;

	public static final int minInt = 1;
	public static final int maxInt = 1000;

	public static final int minDouble = 1;
	public static final int maxDouble = 1000;
	/**
	 * Controllo la lunghezza della Stringa se e' compresa tra
	 * il valore minimo e masso allora ritorna TRUE
	 * 
	 * il valore di verifica e' il terzo parametro
	 * @param int min
	 * @param int max
	 * @param String verifica
	 * @return	boolean
	 */
	public static boolean controlloString(int min,int max,String verifica)
	{
		boolean ris = false;
		if(verifica.length() >= min && verifica.length() <= max)
			ris = true;
		return ris;
	}

	/**
	 * Controlla la dimensione di un INT se e' compreso nel valore di verifica
	 * allora ritorna true
	 * 
	 * il valore di verifica e' il terzo parametro
	 * @param int min
	 * @param int max
	 * @param int verifica
	 * @return	boolean
	 */
	public static boolean controllaInt(int minInt,int maxInt, int verifica)
	{
		boolean ris = false;
		if(verifica >= minInt && verifica <= maxInt)
			ris = true;
		return ris;
	}

	/**
	 * Controlla la dimensione di un DOUBLE se e' compreso nel valore di verifica
	 * allora ritorna true
	 * 
	 * il valore di verifica e' il terzo parametro
	 * @param int min
	 * @param int max
	 * @param double verifica
	 * @return	boolean
	 */
	public static boolean controllaDouble(int min, int max, double verifica)
	{
		boolean ris = false;
		if(verifica >= min && verifica <= max)
			ris = true;
		return ris;
	}

	/**
	 * se i parametri String nome, int x, int y, int maxDistanzaPercorribile sono veri creo l'unita
	 * 
	 * @param nome
	 * @param x
	 * @param y
	 * @param maxDistanzaPercorribile
	 * @return boolean
	 */
	
	public static boolean controllaUnita(String nome, int x, int y, int maxDistanzaPercorribile)
	{
		boolean ris = false;
		if(	Vik.controlloString(min, max, nome)	&&
				Vik.controllaInt(minInt, maxInt, x)	    &&
				Vik.controllaInt(minInt, maxInt, y)	    &&
				Vik.controllaInt(minInt, maxInt, maxDistanzaPercorribile))
			ris = true;
		return ris;
	}

	/**
	 * Controllo se il soldato puo' essere creato...
	 *  Se i paramtri dell'unita sono verificati: String nome, int x, int y, int maxDistanzaPercorribile
	 * e i paramtri del soldato sono verificati: String squadra, int potenzaFuoco
	 * creo il soldato
	 * 
	 * @param nome
	 * @param x
	 * @param y
	 * @param maxDistanzaPercorribile
	 * @param squadra
	 * @param potenzaFuoco
	 * @return	boolean
	 */
	public static boolean controllaSoldato(	String nome, int x, int y, int maxDistanzaPercorribile,
			String squadra, int potenzaFuoco)
	{
		boolean ris = false;
		if(	controllaUnita(nome,x,y,maxDistanzaPercorribile)	&&
				Vik.controlloString(min, max, squadra)				&&
				Vik.controllaInt(minInt, maxInt, potenzaFuoco))
			ris = true;
		return ris;
	}

	/**
	 * Controllo se il soldato puo' essere creato...
	 *  Se i paramtri dell'unita sono verificati: String nome, int x, int y, int maxDistanzaPercorribile
	 * e i paramtri del mezzo sono verificati: int carburante, int consumoCarburante,String tipo
	 * creo il mezzo
	 * @param nome
	 * @param x
	 * @param y
	 * @param maxDistanzaPercorribile
	 * @param carburante
	 * @param consumoCarburante
	 * @param tipo
	 * @return boolean
	 */
	
	//MEZZO,Liuka,791,804,499,749,10,SOTTOMARINO
	public static boolean controllaMezzo(	String nome, int x, int y, int maxDistanzaPercorribile,
			int carburante, int consumoCarburante,String tipo)
	{
		boolean ris = false;
		if(	controllaUnita(nome,x,y,maxDistanzaPercorribile)	&&
				Vik.controllaInt(minInt, maxInt, carburante)				&&
				Vik.controllaInt(minInt, maxInt, consumoCarburante)       &&
				Vik.controlloString(min, max, tipo))
			ris = true;
		return ris;
	}

	/**
	 * Se l'utente risponde si il boolean e' true 
	 * il parametro da passare e' di tipo Scanner tastiera
	 * @param tastiera
	 * @return boolean
	 */
	public static boolean continua(Scanner tastiera)
	{
		System.out.println("\nVuoi effettuare un'altra operazione? Rispondi si o no\n");
		return tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
	}


	/**
	 * Stampa il to String dell'oggetto Unita tramite un ciclo for/each dell'ArrayList elenco. 
	 * @param elenco
	 * @return String
	 */
	public static String stampaArrayList(ArrayList<Unita> elenco)
	{
		String ris = "";
		for(Unita u : elenco) {
			ris += u.toString() + "\n";
		}
		return ris;
	}
	
	/**
	 * Stampa il to String dell'oggetto Unita tramite un ciclo for/each dell'ArrayList elenco. 
	 * @param elenco
	 * @return String
	 */
	public static String stampaArrayListString(ArrayList<String> elenco)
	{
		String ris = "";
		for(String s : elenco) {
			ris += s.toString() + "\n";
		}
		return ris;
	}

	/**
	 * Verificare nel main se una String e' vuota o maggiore di 0 se non e' corretta ritorna la risposta 
	 * che non e' stata trovata nessuna rispsota
	 * @param parametro
	 * @return String
	 */
	public static String rispostaVuota (String parametro)
	{
		String ris = "";
		if(parametro.length() == 0 )		
			ris = "La richiesta da lei effetuata non ha prodotto nessun risultato\n"; 
		else
			ris = parametro;
		return ris;		
	}
	
	/**
	 * Try catch dinamico, inserendo parametri, per controllare che utente abbia inserito valori
	 * numerici
	 * @param boolean, int, Scanner
	 * @return int
	 */
	public static int controlloInserimento (boolean rispCorretta, int risposta, Scanner tastiera) {
		do {
			try {
				risposta = Integer.parseInt(tastiera.nextLine());
				rispCorretta = true;
			} catch (NumberFormatException e1) {
				System.out.println("Devi inserire solo valori numerici");
			}
		}while(rispCorretta == false);
		return risposta;
	}
	
	public static String controlloInserimentoStr (boolean rispCorretta, String risposta, Scanner tastiera) {
		do {
			risposta = tastiera.nextLine();
			if(risposta.length() > 0) {
				rispCorretta = true;
			} else {
				System.out.println("Devi inserire un valore ");
			}
		}while(rispCorretta == false);
		return risposta;
	}
	
	
	public static String stampaArrayListEDistanza(ArrayList<Unita> elenco, int x, int y)
	{
		String ris = "";
		for(Unita u : elenco) {
			ris += "\n" + u.toString() + "Distanza da: " + u.distanzaDa(x,y) + "\n\n" + "------------" + "\n";
		}
		return ris;
	}
}