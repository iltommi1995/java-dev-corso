package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Cd;
import entities.Fumetto;
import entities.Movie;

public class MainNegozio {
	public static void main(String[] args) throws FileNotFoundException 
	{
		// Stampare l'elenco dei fumetti
		// Stampare l'elenco dei film
		// Stampare l'elenco dei cd
		
		String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\03- Terza settimana\\02- Secondo giorno\\Negozio_01\\src\\res\\Medias.txt";
		Scanner file = new Scanner(new File(path));
		
		// Per prima cosa capisco quanti elementi di ogni tipo ci sono
		
		String[] rigaFile;
		int nFilm = 0;
		int nCd = 0;
		int nFumetti = 0;
		
		while(file.hasNextLine()) {
			rigaFile = file.nextLine().split(",");
			
			switch(rigaFile[0].toLowerCase()) {
				case "film":
					nFilm ++;
				break;
				case "fumetto":
					nFumetti ++;
				break;
				case "cd":
					nCd ++;
				break;
				default:
				break;
			}
		}
		file.close();
		
		// Dichiaro e inizializzo un array di oggetti per ogni tipo di dato
		
		file = new Scanner(new File(path));
		
		Movie movies[] = new Movie[nFilm];
		int movieCount = 0;
		Movie m;
		
		Cd cds[] = new Cd[nCd];
		int cdCount = 0;
		Cd c;
		
		Fumetto fumetti[] = new Fumetto[nFumetti];
		int fumCount = 0;
		Fumetto f;
		
		while(file.hasNextLine()) {
			rigaFile = file.nextLine().split(",");
			switch(rigaFile[0].toLowerCase()) {
			case "film":
				m = new Movie();
				m.title = rigaFile[1];
				m.director = rigaFile[2];
				m.genre = rigaFile[3];
				m.year = Integer.parseInt(rigaFile[4]);
				movies[movieCount] = m;
				movieCount++;
			break;
			case "fumetto":
				f = new Fumetto();
				f.title = rigaFile[1];
				f.author = rigaFile[2];
				f.genre = rigaFile[3];
				f.pages = Integer.parseInt(rigaFile[4]);
				f.year = Integer.parseInt(rigaFile[5]);
				fumetti[fumCount] = f;
				fumCount++;
			break;
			case "cd":
				c = new Cd();
				c.title = rigaFile[1];
				c.artist = rigaFile[2];
				c.genre = rigaFile[3];
				c.tracks = Integer.parseInt(rigaFile[4]);
				c.year = Integer.parseInt(rigaFile[5]);
				cds[cdCount] = c;
				cdCount++;
			break;
			default:
			break;
			}
		}
		
		file.close();
		
		// Iniziano le scelte dell'utente
		
		boolean continua = false;
		int risposta;
		
		Scanner tastiera = new Scanner(System.in);
		
		do {
			System.out.println(	"\nScegli una delle seguenti opzioni:\n" 	+
								"1- Stampa l'elenco dei film\n"				+
								"2- Stampa l'elenco dei cd\n"				+
								"3- Stampa l'elenco dei fumetti\n"		);
			risposta = Integer.parseInt(tastiera.nextLine());
			String output = "";
			switch(risposta) {
			
				//1- Stampa lista di film
				case 1:
					output += "\nQuesta è la lista dei film presenti nel database:\n"; 
					for(int i = 0; i < movies.length; i++) {
						output += (i+1) + "- " + movies[i].scheda() + "\n";
					}
					
					System.out.println(output);
					
					System.out.println("Vuoi compiere un'altra operazione? Rispondi 'si' o 'no'.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false; 
				break;
				
				//2- Stampa lista di cd
				case 2:
					output += "\nQuesta è la lista dei cd presenti nel database:\n"; 
					for(int i = 0; i < cds.length; i++) {
						output += (i+1) + "- " + cds[i].scheda() + "\n";
					}
					
					System.out.println(output);
					
					System.out.println("Vuoi compiere un'altra operazione? Rispondi 'si' o 'no'.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				//3- Stampa lista di fumetti
				case 3:
					output += "\nQuesta è la lista dei fumetti presenti nel database:\n"; 
					for(int i = 0; i < fumetti.length; i++) {
						output += (i+1) + "- " + fumetti[i].scheda() + "\n";
					}
					
					System.out.println(output);
					
					System.out.println("Vuoi compiere un'altra operazione? Rispondi 'si' o 'no'.");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				default:
				System.out.println("L'operazione da te indicata non è riconosciuta.\n");
				
				System.out.println("Vuoi compiere un'altra operazione? Rispondi 'si' o 'no'.");
				continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
			}
		}
		while( continua == true);
		
		System.out.println("\nGrazie e alla prossima!");
		tastiera.close();
	}
}
