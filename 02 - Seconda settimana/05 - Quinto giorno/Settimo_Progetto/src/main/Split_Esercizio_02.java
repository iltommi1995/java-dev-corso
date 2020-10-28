package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Split_Esercizio_02 {

	public static void main(String[] args) throws FileNotFoundException {
		//Leggere da un file la riga
		//Nome-Cognome-Eta
		//Fare in modo che il programma stampi
		//Cognome-Eta-Nome
		
		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\05 - Quinto giorno\\Settimo_Progetto\\src\\res\\SplitEs2.txt";
		Scanner file = new Scanner( new File(percorso));
		
		String[] riga;
		String risposta = "";
		
		while(file.hasNextLine()) {
			riga = file.nextLine().split("-");
			risposta = riga[1] + "-" + riga[2] + "-" + riga[0];
		}
		System.out.println(risposta);
		file.close();
	}

}
