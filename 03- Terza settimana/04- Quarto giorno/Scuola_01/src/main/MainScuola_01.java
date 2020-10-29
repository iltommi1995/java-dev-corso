package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Insegnante;
import entities.Studente;

public class MainScuola_01 {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Siete i gestori di una scuola media. 
		 * Vi viene dato un file formattato in questo modo:
		 * STUDENTE,NOME,COGNOME,SESSO,ETA,CLASSE,MEDIAITA,MEDIAMATE,MEDIAFRA,MEDIAING
		 * INSEGNANTE,NOME,COGNOME,SESSO,ETA,MATERIA,ANNILAVORO
		 * Vi si chiede di stampare:
		 * 1- Numero totale delle persone della scuola (studenti + insegnanti)
		 * 2- Elenco degli studenti
		 * 3- Elenco degli insegnanti
		 * Nella stampa di ogni studente, oltre ai dati che si trovano nel file, si chiede:
		 * 1- Media personale
		 * 2- Esito (se la classe è 3 e ha più di una insuff -> bocciato
		 * 			 se la classe è 1 o 2 e ha più di 2 insuff -> bocciato)
		 * 3- Erasmus (per andare in Erasmus uno studente deve essere promosso ed avere 
		 * 			   almeno una delle due materie linguistiche sopra l'8)
		 * 
		 * Elenco insegnanti, nella stampa di ogni insegnante, oltre ai dati del file, si chiede:
		 * 1- stipendio -> lo stipendio base è di 1000 euro. 
		 * 				   se lavora da più di 10 anni, aggiungere 500 euro
		 *                 se lavora da più di 20 anni aggiungere 1000 euro
		 * 2- anni alla pensione (se è donna pensione a 65 anni, uomo a 70)
		 * 
		 */
		
		String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\03- Terza settimana\\04- Quarto giorno\\Scuola_01\\src\\res\\ScuolaMedia.txt";
		Scanner file = new Scanner(new File(path));
		
		// Leggo dati da file e creo due ArrayList
		
		ArrayList<Studente> studenti = new ArrayList();
		ArrayList<Insegnante> insegnanti = new ArrayList();
		
		Studente s;
		Insegnante in;
		
		String[] rigaFile;
		
		while(file.hasNextLine()) {
			rigaFile = file.nextLine().split(",");
			
			switch(rigaFile[0].toLowerCase()) {
				case "studente":
					s = new Studente(rigaFile[1], rigaFile[2], rigaFile[3], Integer.parseInt(rigaFile[4]), 
							Integer.parseInt(rigaFile[5]), Double.parseDouble(rigaFile[6]), 
							Double.parseDouble(rigaFile[7]), Double.parseDouble(rigaFile[8]), Double.parseDouble(rigaFile[9]));
					studenti.add(s);
				break;
				case "insegnante":
					in = new Insegnante(rigaFile[1], rigaFile[2], rigaFile[3], Integer.parseInt(rigaFile[4]),
							rigaFile[5], Integer.parseInt(rigaFile[6]));
					insegnanti.add(in);
			}
		}
		
		file.close();
		
		// Iniziano scelte utente
		
		Scanner tastiera = new Scanner(System.in);
		
		boolean continua = false;
		int risposta;
		
		do {
			System.out.println("Scegli una delle seguenti opzioni:\n" + "1- Numero totale delle persone della scuola\n" + "2- Elenco studenti\n" + "3- Elenco professori\n");
			risposta = Integer.parseInt(tastiera.nextLine());
			String output = "";
			switch(risposta) {
				// Numero persone scuola
				case 1:
					int nPersone = studenti.size() + insegnanti.size();
					output = "\nIl numero delle persone totali è: " + nPersone + "\n---- Numero studenti: " + studenti.size() + "\n---- Numero insegnanti: " + insegnanti.size();
					System.out.println(output);
					
					System.out.println("\nVuoi fare un'altra operazione? Rispondi 'si' o 'no'.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Elenco studenti
				case 2:
					output = "ECCO L'ELENCO DEGLI STUDENTI: \n";
					for(int i = 0; i < studenti.size(); i++) {
						output += (i+1) + "- " + studenti.get(i).scheda() + "\n";
					}
					System.out.println(output);
					
					System.out.println("\nVuoi fare un'altra operazione? Rispondi 'si' o 'no'.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Elenco professori
				case 3:
					output = "ECCO L'ELENCO DEGLI INSEGNANTI: \n";
					for(int i = 0; i < insegnanti.size(); i++) {
						output += (i+1) + "- " + insegnanti.get(i).scheda() + "\n";
					}
					System.out.println(output);
					
					System.out.println("\nVuoi fare un'altra operazione? Rispondi 'si' o 'no'.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Default
				default:
					System.out.println("\nL'operazione da te richiesta non è riconosciuta.");
					
					System.out.println("\nVuoi fare un'altra operazione? Rispondi 'si' o 'no'.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
			}
		} while (continua == true);
		
		System.out.println("\nGrazie e alla prossima!");
		tastiera.close();
	}

}
