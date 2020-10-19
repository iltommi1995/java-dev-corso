package main;
import java.util.Scanner;

public class Selezione_Esercizio_03 
{
	public static void main(String[] args) 
	{
		// In questo esercizio cerchiamo di utilizzare la SELEZIONE e i BOOLEAN
		// ipotizziamo di dover creare un programma per la prenotazione di un viaggio
		// Chiedere all'utente la destinazione e il numero dei passeggeri.
		// Se l'utente non inserisce uno di questi due valori, stampare subito un messaggio di errore
		// e il programma termina!
		// Altrimenti:
		// Se la destinazione è Londra il prezzo è 100 euro
		// Se la destinazione è Parigi il prezzo è 80
		// Se la destinazione è Oslo il prezzo è 150
		// Per tutte le altre destinazioni il prezzo è 70
		// Chiedere all'utente se vuole il pranzo in aereo
		// Se risponde True, aggiungere al prezzo del biglietto il costo del pranzo (20)
		// Chiedere all'utente se vuole il posto spazioso, costo 30 
		// Stampare alla fine il prezzo del biglietto singolo e il prezzo del biglietto per 
		// il numero di passeggeeri
		
		// Dichiarazione e inizializzazione
		String destinazione = "";
		int numPasseggeri = 0;
		boolean pranzo = false;
		boolean postoXL = false;
		int bigliettoSingolo = 70;
		int bigliettiTot;
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Ciao, inserisci la tua destinazione.");
		destinazione = tastiera.nextLine();
		System.out.println("Perfetto, ora inserisci il  numero di biglietti.");
		numPasseggeri = Integer.parseInt(tastiera.nextLine());
		
		// Calcolo
		if(destinazione.equals("") || numPasseggeri == 0)
			System.out.println("Non hai inserito valori corretti.");
		else {
			if(destinazione.equalsIgnoreCase("londra"))
				bigliettoSingolo = 100;
			if(destinazione.equalsIgnoreCase("parigi"))
				bigliettoSingolo = 80;
			if(destinazione.equalsIgnoreCase("oslo"))
				bigliettoSingolo = 150;
			
			System.out.println("Perfetto, vuoi aggiungere il pranzo? Rispondi si o no");
			if(tastiera.nextLine().equalsIgnoreCase("si"))
				pranzo = true;
			System.out.println("Per ultima cosa, vuoi i posti xl? Rispondi si o no");
			if(tastiera.nextLine().equalsIgnoreCase("si"))
				postoXL = true;
			
			if(pranzo == true) 
				bigliettoSingolo += 20;
			if(postoXL == true)
				bigliettoSingolo += 30;
			
			// Output
			bigliettiTot = bigliettoSingolo * numPasseggeri;
			System.out.println(
					"Il prezzo per singolo biglietto è: " + bigliettoSingolo + "€\n"
					+ "Il prezzo totale per " + numPasseggeri + " biglietti è " + 
					bigliettiTot + "€");
		}
		
		tastiera.close();
	}
}
