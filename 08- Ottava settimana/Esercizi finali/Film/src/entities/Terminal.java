package entities;

import java.io.FileNotFoundException;
import java.util.Scanner;

import interfaces.IBlockBuster;
import utility.Vik;

public class Terminal {
	
	public String program(Scanner tastiera) {
		
		boolean continua = false;
		boolean checkTry = false;
		
		String path = "src/res/file.txt";
		IBlockBuster ib = null;
		
		// Lettura del file con try catch
		
		try {
			ib = new Blockbuster(path);
		} catch(FileNotFoundException e) {
			do {
				System.out.println("\nIl percorso indicato è sbagliato!");
				try {
					System.out.println("\nInserisci il nome del file: ");
					ib = new Blockbuster("src/res/" + tastiera.nextLine());
					checkTry = true;
				} catch(FileNotFoundException e1) {
					checkTry = false;
				}
			} while(!checkTry);
		}
		
		
		// Switch scelta utente
		
		
		int scelta = -2000;
		String opzioni = 		"\nSeleziona una delle seguenti operazioni:\n"													+
								"1- Durata media di tutti i film\n"																+
								"2- Lista dei film con durata massima\n"														+
								"3- Lista dei film con durata minima\n"															+
								"4- Lista dei film con popolarità maggiore di 85\n"												+
								"5- Lista dei titoli dei film che hanno vinto premi\n"											+
								"6- Lista dei nominativi per tipo (actor, actress o director)\n"								+
								"7- Cerca film per nome della persona\n"														+
								"8- Elenco dei generi con numero dei film per genere\n"											+
								"9- Elenco dei generi con prezzo medio dei film per genere\n"									+
								"10- Nome e stipendio di tutte le persone\n"													+
								"11- Elenco dei film in cui non sono presenti attrici\n"										+
								"12- Elenco dei film in cui non sono presenti i registi ma sono presenti le attrici\n"			+
								"13- Elenco dei film in cui sono presenti solo attrici\n"										;
		
		//Do While con switch scelta
		
		do {
			
			// Do While con il Try catch scelta utente
			
			do {
				checkTry = true;
				try {
					System.out.println(opzioni);
					scelta = Integer.parseInt(tastiera.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("\nDevi inserire solo valori numerici");
					checkTry = false;
				}
			} while(!checkTry);
			
			// Inizio switch scelta utente
			
			String risp = "";
			
			switch(scelta) {
			
				// Durata media di tutti i film
				case 1:
					risp = "\nLa durata media di tutti i film è: " + ib.avglength() + " minuti.";
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Lista dei film con durata massima
				case 2:
					risp = "\nLista dei film con durata massima: \n\n" + Vik.stampaFilm(ib.maxlength());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				//Lista dei film con durata minima
				case 3:
					risp = "\nLista dei film con durata minima: \n\n" + Vik.stampaFilm(ib.minlength());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Lista dei film con popolarità maggiore di 85
				case 4:
					risp = "\nLista dei film con popolarità maggiore di 85: \n\n" + Vik.stampaFilm(ib.mostpopular());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Lista dei titoli dei film che hanno vinto premi
				case 5:
					risp = "\nLista dei film che hanno vinto premi: \n\n" + Vik.stampaALString(ib.award());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				//Lista dei nominativi per tipo (actor, actress o director)
				case 6:
					String tipo = "";
					do {
						System.out.println("\nInserisci il tipo della persona che cerchi:");
						tipo = tastiera.nextLine();
						checkTry = Vik.controlloString(1, 100, tipo);
						if(!checkTry) {
							System.out.println("\nDevi inserire un tipo valido!");
						}
					} while(!checkTry);
					risp = "Lista dei nominativi delle persone di tipo " + tipo + ":\n\n" + Vik.stampaALString(ib.type(tipo));
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Cerca film per nome della persona
				case 7:
					String nome = "";
					do {
						System.out.println("\nInserisci il nome della persona che cerchi:");
						nome = tastiera.nextLine();
						checkTry = Vik.controlloString(1, 100, nome);
						if(!checkTry) {
							System.out.println("\nDevi inserire un nome valido!");
						}
					} while(!checkTry);
					risp = "Lista dei film in cui è presente " + nome + ":\n\n" + Vik.stampaFilm(ib.search(nome));
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				//Elenco dei generi con numero dei film per genere
				case 8:
					risp = "\nElenco dei generi con quantità film per genere: \n\n" + Vik.stampaMapInteger(ib.subjectcount());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Elenco dei generi con prezzo medio dei film per genere
				case 9:
					risp = "\nElenco dei generi con prezzo medio dei film per genere: \n\n" + Vik.stampaMapDouble(ib.avgprice());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Nome e stipendio di tutte le persone
				case 10:
					risp = "\nElenco dei nomi e stipendi: \n\n" + Vik.stampaALString(ib.salary());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Elenco dei film in cui non sono presenti attrici
				case 11:
					risp = "\nElenco dei film in cui non sono presenti attrici: \n\n" + Vik.stampaFilm(ib.noWoman());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Elenco dei film in cui non sono presenti i registi ma sono presenti le attrici
				case 12:
					risp = "\nElenco dei film in cui non sono presenti registi ma sono presenti le attrici: \n\n" + Vik.stampaFilm(ib.free());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Elenco dei film in cui sono presenti solo attrici
				case 13:
					risp = "\nElenco dei film in cui sono presenti solo attrici: \n\n" + Vik.stampaFilm(ib.noMan());
					System.out.println(risp);
					continua = Vik.continua(tastiera);
				break;
				
				// Opzione non presente
				default:
					System.out.println("\nNon esiste l'opzione selezionata.");
					continua = Vik.continua(tastiera);
			}
		}while(continua);
		
		
		
		return "\nArrivederci e alla prossima!";
	}

}
