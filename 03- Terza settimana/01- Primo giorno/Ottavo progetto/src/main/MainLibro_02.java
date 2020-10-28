package main;

import java.util.Scanner;

public class MainLibro_02 {

	public static void main(String[] args)
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Quanti libri vuoi inserire?");
		int nLibri = Integer.parseInt(tastiera.nextLine());
		int numero = nLibri;
		String elenco = "";
		Libro l;
		double mediaPrezzi = 0;
		while(nLibri > 0) {
			l = new Libro();
			System.out.println("Inserisci il titolo del libro");
			l.titolo = tastiera.nextLine();
			System.out.println("Inserisci l'autore del libro");
			l.autore = tastiera.nextLine();
			System.out.println("Inserisci il genere del libro");
			l.genere = tastiera.nextLine();
			System.out.println("Inserisci il prezzo del libro");
			l.prezzo = Double.parseDouble(tastiera.nextLine());
			
			elenco  += "- " + l.titolo + ", " + l.autore + ", " + l.prezzo + "\n";
			nLibri --;
			mediaPrezzi += l.prezzo;
		}
		System.out.println(elenco + "Media prezzo libri :  " + mediaPrezzi/numero);
		tastiera.close();
	}

}
