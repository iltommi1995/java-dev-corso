package entities;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terminale 
{
	
	private Scanner tastiera;
	
	public Terminale(Scanner tastiera) {
		this.tastiera = tastiera;
	}
	
	public String output() throws FileNotFoundException {
		String output = "";
		int risposta;
		
		String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\04- Quarta settimana\\Terzo_giorno\\Esercizio_StaticFinal_01\\src\\res\\Scuola.txt";
		Scuola scuola = new Scuola(path);
		boolean continua = false;
		do {
			
			System.out.println(
							"Scegli quale operazione svolgere:\n"		+
							"1- Elenco di tutte le persone\n"			+
							"2- Elenco per classe\n"					+
							"3- Cerca persona per nome\n"				+
							"4- Media totale in inglese\n"				+
							"5- Cerca per qualsiasi key\n"				+
							"6- Elenco promossi/bocciati\n"				+ 
							"7- Elenco promossi/bocciati per classe\n"	 );
			risposta = Integer.parseInt(tastiera.nextLine());
			
			switch(risposta) {
				case 1:
					System.out.println(scuola.elenco());
					continua = continua(tastiera);
				break;
				
				case 2: 
					System.out.println("\nScegli la classe: \n 1- 3A\n 2- 5B");
					System.out.println(scuola.elenco(Integer.parseInt(tastiera.nextLine())));
					continua = continua(tastiera);
				break;
				
				case 3: 
					System.out.println("\nInserisci un nome da cercare:");
					System.out.println(scuola.cerca(tastiera.nextLine()));
					continua = continua(tastiera);
				break;
				
				case 4:
					System.out.println("\nLa media totale degli studenti in inglese è: " + scuola.mediaTotIng());
					continua = continua(tastiera);
				break;
				
				case 5:
					System.out.println("\nScegli il campo di ricerca:\n1- Nomi\n2- Classi\n3- Anni\n4- Voti\n5- Esito\n");
					int campo = Integer.parseInt(tastiera.nextLine());
					System.out.println("\nScegli ora l'elemento che vuoi cercare:\n");
					// System.out.println(scuola.cercaTutto(tastiera.nextLine(), campo));
					continua = continua(tastiera);
				break;
				
				case 6:
					System.out.println("\nVuoi cercare gli studenti:\n1- Bocciati\n2- Promossi");
					System.out.println(scuola.esito(Integer.parseInt(tastiera.nextLine())));;
					continua = continua(tastiera);
				break;
				
				case 7:
					System.out.println("\nVuoi cercare gli studenti:\n1- Bocciati\n2- Promossi");
					int esito = Integer.parseInt(tastiera.nextLine());
					System.out.println("\nIn che classe vuoi controllare?\n1- 3A\n2- 5B");
					System.out.println(scuola.esito(Integer.parseInt(tastiera.nextLine()), esito));
					continua = continua(tastiera);
				break;
				
				default:
					System.out.println("L'operazione da te indicata non è riconosciuta!");
					continua = continua(tastiera);
			}
			
		} while (continua == true);
		
		return "\nGrazie e alla prossima!";
	}
	
	public boolean continua(Scanner tastiera) {
		System.out.println("\nVuoi efettuare un'altra operazione? Rispondi si o no.");
		return tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
	}
}
