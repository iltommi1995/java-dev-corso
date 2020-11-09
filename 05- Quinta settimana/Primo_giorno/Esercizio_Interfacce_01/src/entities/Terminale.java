package entities;

import java.io.FileNotFoundException;
import java.util.Scanner;

import interfacce.Interf;

public class Terminale {
	
	public String output() {
		String path = "src/res/Negozio.txt";
		Scanner tastiera = new Scanner(System.in);
		Interf n = null;
		try {
			 n = new Negozio(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Non hai inserito un file esistente");
		}
		
		boolean continua = false;
		do {
			System.out.println("\nSceglio cosa fare:\n" + "1- Prezzo medio dei libri\n" + "2- Elenco libri\n");
			int scelta = Integer.parseInt(tastiera.nextLine());
			switch(scelta) {
			case 1:
				System.out.println(n.prezzoMedio());
				continua = continua(tastiera);
				break;
			case 2:
				System.out.println(n.elencoTitoli());
				continua = continua(tastiera);
				break;
			default:
				System.out.println("\nNon esiste l'operazione da te indicata");
				continua = continua(tastiera);
			}
		} while(continua == true);
		return "\nCiao e alla prossima!";
	}
	
	private boolean continua(Scanner tastiera) {
		System.out.println("\nVuoi effettuare un'altra operazione? Rispondi si o no");
		return tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
	}

}
