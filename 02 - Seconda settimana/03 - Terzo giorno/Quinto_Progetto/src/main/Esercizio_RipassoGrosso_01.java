package main;
import java.util.Scanner;

public class Esercizio_RipassoGrosso_01 
{
	public static void main(String[] args) 
	{
		/*
		 * Immaginate di dover creare una forma di login e di dover
		 * chiedere all'utente di inserire username e password
		 * Iniziate con lo USER: fate in modo che la domanda si ripeta finchè
		 * l'utente inserisce un valore valido (se lascia vuoto, ripetete la domanda).
		 * Una volta inserito l'utente, chiedere la PASSWORD.
		 * Verificare che la password sia valida e abbinata a quell'utente
		 * se la password è errata, stampare: password errata per quell'user.
		 * se la password è corretta, stampare un MESSAGGIO DI BENVENUTO;
		 * contenete il nome vero dell'utente che si è appena loggato!
		 * Pensiamo di avere almeno 3 UTENTI.
		 */

		// Dichiarazione
		Scanner tastiera = new Scanner(System.in);
		
		String username, password;
		boolean verifica = false;
		int counter = 0;
		
		// Calcolo
		do {
			System.out.println("Benvenuto, vuoi accedere a questo terminale? Beh, prima devi loggare. Inserisci lo username");
			username = tastiera.nextLine();
		} 
		while (username.equals(""));
		
		do {
			System.out.println("Ok, ora metti la pw plz");
			password = tastiera.nextLine();
			counter ++;
			switch(password) {
				case "pippo":
					if(username.equals("utente1"))
						verifica = true;
					else {
						System.out.println("Ehhh, voleeeevi! La password è sbagliata.");
					}
				break;
				case "pluto":
					if(username.equals("duckfiction"))
						verifica = true;
					else {
						System.out.println("Ehhh, voleeeevi! La password è sbagliata.");
					}
				break;
				case "paperino":
					if(username.equals("tiziocaio"))
						verifica = true;
					else {
						System.out.println("Ehhh, voleeeevi! La password è sbagliata.");
					}
				break;
				default :
					System.out.println("Ehhh, voleeeevi! La password è sbagliata.");
				break;
			}
		}
		while(verifica != true && counter < 4);
		
		// Output
		if(verifica == false || counter == 4)
			System.out.println("Mi dispiace, " + username + ", ma hai sbagliato " + counter + " volte di seguito, aspetta 15 minuti prima di riprovare!");
		else
			System.out.println("\nBravo " + username + " sei riuscito ad accedere al " + counter + " tentativo, benvenuto !");
		
		tastiera.close();
	}
}
