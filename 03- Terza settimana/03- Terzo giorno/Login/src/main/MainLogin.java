package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.User;

public class MainLogin {
	public static void main(String[] args) throws FileNotFoundException 
	{
		// Un login è un programma che chiede a un utente di inserie una user e una password
		// Creare un programma in cui l'utente inserisce user e pw
		// se quelle credenziali corrisondono a un utente, stampare messaggio di 
		// benvenuto nel quale appare il vero nome utente
		// se credenziali non corrispondono, stampare msg errore
		
		Scanner tastiera = new Scanner(System.in);
		String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\03- Terza settimana\\03- Terzo giorno\\Login\\src\\res\\UsersAndPws.txt";
		Scanner file = new Scanner(new File(path));
		
		String rigaFile[];
		ArrayList<User> users = new ArrayList();
		User u;
		
		while(file.hasNextLine()) {
			u = new User();
			rigaFile = file.nextLine().split(",");
			u.username = rigaFile[0];
			u.password = rigaFile[1];
			users.add(u);
		}
		
		file.close();
		
		// Inizio programma
		
		boolean riprova = false;
		String utente;
		String password;
		
		do {
			System.out.println("Inserisci l'utente");
			utente = tastiera.nextLine();
			boolean presente = false;
			for(int i = 0; i < users.size() && presente != true; i++) {
				presente = users.get(i).checkUser(utente);
			}
			
			if(presente == true) {
				int errorCount = 0;
				boolean pwPresente = false;
				
				while ((pwPresente == false) && (errorCount <= 2)) {
					System.out.println("\nBene " + utente + ", ora inserisci la password!");
					password = tastiera.nextLine();
					for(int i = 0; i < users.size() && pwPresente != true; i++) {
						pwPresente = users.get(i).checkPw(password);
					}
					
					if(pwPresente == true) {
						System.out.println("Benvenuto nel terminale.");
					} 
					else {
						errorCount ++;
						System.out.println("La password è sbagliata. Ti rimangono " + (3 - errorCount) + " tentativi.");
						
					}
				};
				if(pwPresente == false)
					System.out.println("\nHai fatto troppi errori, riprova tra 5 minuti.");
				riprova = false;
			}
			else {
				System.out.println("L'utente non è presente, vuoi riprovare? Rispondi si o no");
				riprova = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
 			}
		}while(riprova == true);
		
		System.out.println("\nGrazie e ciao");
		tastiera.close();
	}
}
