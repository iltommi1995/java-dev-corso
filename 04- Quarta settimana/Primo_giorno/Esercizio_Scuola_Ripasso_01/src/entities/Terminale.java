package entities;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terminale 
{
	private String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\04- Quarta settimana\\Primo_giorno\\Esercizio_Scuola_Ripasso_01\\src\\res\\DatiScuola.txt";
	
	
	
	public String output(Scanner tastiera) throws FileNotFoundException {
		
		Scuola scuola = new Scuola(path);
		String output = "";
		
		System.out.println(
				"\nScegli l'operazione da svolgere:\n"						+
				"1- Numero di persone totali\n"								+
				"2- Numero di studenti\n"									+
				"3- Numero di insegnanti\n"									+
				"4- Elenco di tutte le persone\n"							+
				"5- Elenco delle persone superiori a una certa età\n"		+
				"6- Elenco degli studenti\n"								+
				"7- Elenco degli insegnanti\n"								+
				"8- Elenco degli studenti per classe\n"						+
				"9- Elenco insegnanti per materia\n"						+
				"10- Elenco degli studenti promossi\n"						+
				"11- Elenco insegnanti sopra ai 2000 euro\n"				+
				"12- Elenco insegnanti sopra a stipendio dato\n"			);

			int scelta = Integer.parseInt(tastiera.nextLine());
			switch(scelta) {
				case 1:
					output = scuola.nPersone();
				break;
				case 2:
					output = scuola.nStudenti();
				break;
				case 3:
					output = scuola.nInsegnanti();
				break;
				case 4:
					output = scuola.elencoPersone();
				break;	
				case 5:
					System.out.println("Inserisci l'età:");
					output = scuola.elencoPersone(Integer.parseInt(tastiera.nextLine()));
				break;
				case 6:
					output = scuola.elencoStudenti();
				break;
				case 7:
					output = scuola.elencoInsegnanti();
				break;
				case 8:
					System.out.println("Inserisci il numero di una delle seguenti classi:\n" + "1- 1E\n" + "2- 2A\n" + "3- 3B\n");
					output = scuola.elencoStudentiPerClasse(Integer.parseInt(tastiera.nextLine()));
				break;
				case 9:
					System.out.println("Inserisci il numero di una delle seguenti classi:\n" + "1- Italiano\n" + "2- Matematica\n" + "3- Scienze\n" + "4- Educazione fisica\n");
					output = scuola.elencoInsegnantiPerMateria(Integer.parseInt(tastiera.nextLine()));
				break;
				case 10:
					output = scuola.elencoStudentiPromossi();
				break;
				case 11:
					output = scuola.insegnantiRicchi();
				break;
				case 12:
					System.out.println("Inserisci lo stipendio:\n");
					output = scuola.insegnantiRicchi(Integer.parseInt(tastiera.nextLine()));
				break;
				default:
					output = "\nL'opzione da te scelta non è presente.";
			}
		return output;
	}
	
	public String programmaCompleto(Scanner tastiera) throws FileNotFoundException {
		
		String ris = "";
		do {
			System.out.println(output(tastiera));
			System.out.println("Vuoi continuare? Rispondi si o no.");
			ris = tastiera.nextLine();
			ripeti(ris);
		} while (ripeti(ris));
		return "Ciao alla prossima";
		
	}
	
	public boolean ripeti(String parametro) throws FileNotFoundException {
		return parametro.equalsIgnoreCase("no") ? false : true;
		
	}
	

}
