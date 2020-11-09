package main;

import java.util.Scanner;

public class Main_TryCatch {

	public static void main(String[] args) {
		// Quando gestiamo un'eccezione con un blocco try/catch, in verità c'è la possibilità di
		// inserire un codice che viene eseguito indipendentemente che il programma finisca nel 
		// try oppure nel catch.
		// Questo codice viene inserito in un blocco chiamato FINALLY
		
		Scanner tastiera = new Scanner(System.in);
		String ris = "";
		try {
			System.out.println("Inserisci un numero");
			int numero = Integer.parseInt(tastiera.nextLine());
			ris = "Il try è andato a buon fine e l'utente ha inserito il numero " + numero;
		} catch(NumberFormatException e) {
			
		    ris = "L'utente è finito nel catch";
		    		
		}
		finally {
			// Questo blocco di codice lavora in modo indipendente dal try e dal catch. 
			// Ciò che scriviamo all'interno di questo blocco viene infatti eseguito in ogni caso.
			// Finally non è obbligatorio quando si crea un try/catch ma è utile quando alcune operazioni
			// sono necessarie a prescindere dal verificarsi di un try o di un catch
			
			tastiera.close();
			System.out.println("Scanner chiuso");
			
			// La chiusura di uno scanner ad esempio è una di quelle operazioni da fare a prescindere
		}
		System.out.println(ris);
	}

}
