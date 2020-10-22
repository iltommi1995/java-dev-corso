package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vettori_Esercizio_03 {

	public static void main(String[] args) throws FileNotFoundException {
		// Siete i gestori di un'agenzia viaggi.
		// Usando un ciclo while inserite un numero di luoghi a vostra scelta
		// Ogni luogo ha il nome, la capitale e il numero di abitanti
		// Stampare elenco di nomi
		// Chiedere a utente di quale luogo vuole vedere la scheda.
		// Stampare la scheda solo di quel luogo
		// Per i pro: provate a leggere da un file i dati dei luoghi, compreso il numero
		// di essi.
		// Per i super pro: prima delle destinazioni stampate il nome dell'agenzia
		// leggendolo dal file.
		
		// Dichiarazione e Inizializzazione
		
		String percorsoFile = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\03 - Terzo giorno\\Quinto_Progetto\\src\\res\\viaggi.txt";
		
		Scanner fileLineCounter = new Scanner(new File(percorsoFile));
		Scanner file = new Scanner(new File(percorsoFile));
		Scanner tastiera = new Scanner(System.in);
		
		int i = 0;
		String destinazione = "";
		String riepilogoPaesi = "";
		
		// Calcolo numero righe del file
		
		while(fileLineCounter.hasNextLine()) {
			fileLineCounter.nextLine();
			i ++;
		}
		
		// Dichiaro e inizializzo i 3 vettori
		
		String paesi[] = new String[i/3];
		String capitali[] = new String[i/3];
		int popolazioni[] = new int[i/3];
		
		// Inizio a leggere dati dal file
		
		i = 0;
		
		while(file.hasNextLine()) {
			paesi[i] = file.nextLine();
			capitali[i] = file.nextLine();
			popolazioni[i] = Integer.parseInt(file.nextLine());
			riepilogoPaesi += "\n" + (i + 1) +"- " + paesi[i];
			i ++;
		}
		
		// Chiedo all'utente la destinazione
		
		System.out.println("Scrivi il numero del paese che ti interessa, per vederne la scheda: " + riepilogoPaesi);
		int scelta = Integer.parseInt(tastiera.nextLine());
		
		System.out.println("\nEcco i dati richiesti: " + paesi[scelta - 1] + ", capitale " + capitali[scelta - 1] + ", popolazione " + popolazioni[scelta - 1]);
		
		// Chiudo tutti gli scanner
		
		tastiera.close();
		fileLineCounter.close();
		file.close();
	}

}
