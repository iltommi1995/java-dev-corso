package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Esercito;
import interfacce.IEsercito;
import util.Vik;

public class MainEsercito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 	Creare una classe Main_Esercito, dove testare i metodi tramite l'uso di un menù.
	Ipotizzate che il proprietario del file dati sia l'utente e che lo abbia caricato lui nel programma.
	(Cioè voi sapete in che package sarà il file ma non ne conoscete il nome)
	
	Assicuratevi che l'utente distratto possa richiedere tutte le volte che vuole le informazione con facilità e 
	che non possa rompere il programma!
	Assicuratevi anche che l'esposizione dei risultati sia chiara per l'utente (es. se il metodo non trova un risultato,
	non stampate il nulla, ma avvisate l'utente che la ricerca non ha prodotto risultati)
		 */
		
		boolean continua = true;
		String percorso = "";
		Scanner tastiera = new Scanner(System.in);
		IEsercito e = null;
		do
		{		
			percorso = "src\\res\\";		
			System.out.println("Inserisci il nome del file che vuoi cercare:");
			percorso += tastiera.nextLine();
			try {
				e = new Esercito(percorso);
				continua = false;
			} catch (FileNotFoundException ex) {
				System.out.println("Il file richiesto non è stato trovato.");
			}
		}while(continua);
		
		String menu = 	"Scegli un'opzione, e inserisci il numero corrispondente." +
						"\n1) Visualizzare la scheda di tutte le unità" +
						"\n2) Visualizzare la scheda di tutti i soldati" +
						"\n3) Visualizzare le schede dei soldati della squadra che selezioni" +
						"\n4) Visualizzare la scheda di tutti i mezzi" +
						"\n5) Visualizzare la scheda di tutti i mezzi che raggiungono le coordinate inserite" +
						"\n6) Visualizzare il conteggio di tutti i soldati con potenza di fuoco maggiore della potenza inserita" +
						"\n7) Visualizzare la potenza di fuoco media di tutti i soldati" +
						"\n8) Visualizzare l'elenco dei mezzi del tipo che selezioni" +
						"\n9) Visualizzare la lista della squadre" +
						"\n10) Visualizzare l'elenco delle distanze";
		int scelta = 0;
		boolean errore = false;
		
		do
		{
			
			do
			{
				errore = false;
				System.out.println(menu);
				try {
					scelta = Integer.parseInt(tastiera.nextLine());
				} catch (NumberFormatException ex) {
					System.out.println("Valore non valido. Inserisci solo valori numerici.");
					errore = true;
				}
			}while(errore);
			
			boolean rispCorretta = false;
			switch(scelta)
			{
				case 1:
					System.out.println(Vik.rispostaVuota(e.listaUnita()));
					continua = Vik.continua(tastiera);
				break;
				case 2:
					System.out.println(Vik.rispostaVuota(e.soldati()));
					continua = Vik.continua(tastiera);
				break;
				case 3:
					String squadra = "";
					System.out.println("Inserisci la squadra che stai cercando:");
					squadra = Vik.controlloInserimentoStr(rispCorretta, squadra, tastiera);
					System.out.println(Vik.rispostaVuota(e.soldati(squadra)));
					continua = Vik.continua(tastiera);
				break;
				case 4:
					System.out.println(e.listaMezzi());
					continua = Vik.continua(tastiera);
				break;
				case 5:
					int x = 0;
					int y = 0;
					System.out.println("Inserisci la longitudine:");
					x = Vik.controlloInserimento(rispCorretta, x, tastiera);
					System.out.println("Inserisci la latitudine:");
					y = Vik.controlloInserimento(rispCorretta, y, tastiera);
					System.out.println(Vik.rispostaVuota(e.listaUnitaCheRaggiungono(x, y)));
					continua = Vik.continua(tastiera);
				break;
				case 6:
					int potenza = 0;
					System.out.println("Inserisci la potenza di fuoco del soldato che stai cercando:");
					potenza = Vik.controlloInserimento(rispCorretta, potenza, tastiera);
					System.out.println(e.nSoldatiPotenzaFuocoMin(potenza));
					continua = Vik.continua(tastiera);
				break;
				case 7:
					System.out.println("\nLa potenza di fuoco media dei soldati è : " + e.potenzaFuocoMedia());
					continua = Vik.continua(tastiera);
				break;
				case 8:
					String tipo = "";
					System.out.println("Inserisci il tipo di mezzo che stai cercando:");
					tipo = Vik.controlloInserimentoStr(rispCorretta, tipo, tastiera);
					System.out.println(Vik.rispostaVuota(Vik.stampaArrayList(e.mezzi(tipo))));
					continua = Vik.continua(tastiera);
				break;
				case 9:
					System.out.println(Vik.stampaArrayListString(e.conteggioSoldatiPerSquadra()));
					continua = Vik.continua(tastiera);
				break;
				case 10:
					int x1 = 0;
					int y1 = 0;
					System.out.println("Inserisci la longitudine:");
					x1 = Vik.controlloInserimento(rispCorretta, x1, tastiera);
					System.out.println("Inserisci la latitudine:");
					y1 = Vik.controlloInserimento(rispCorretta, y1, tastiera);
					System.out.println(Vik.stampaArrayListEDistanza(e.ordinaPerDistanzaDa(x1, y1), x1,y1));
					continua = Vik.continua(tastiera);
				break;
				default:
					System.out.println("Scelta non valida.");
					continua = Vik.continua(tastiera);
				break;
			}// Chiusura dello switch		
		}while(continua);		
		tastiera.close();
		
		System.out.println("\nCordiali saluti.");
	}

}