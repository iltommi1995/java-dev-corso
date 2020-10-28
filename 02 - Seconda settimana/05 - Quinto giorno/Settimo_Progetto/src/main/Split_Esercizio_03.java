package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Split_Esercizio_03 
{
	public static void main(String[] args) throws FileNotFoundException 
	{

		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\05 - Quinto giorno\\Settimo_Progetto\\src\\res\\SplitEsercizio3.txt";
		Scanner file = new Scanner( new File(percorso));
		
		String[] step1;
		String[] step2;
		String[] step3;
		String risposta = "";
		double mediaMate = 0;
		double mediaIta = 0;
		
		// Leggo il file e faccio il primo split, ottenendo il primo vettore
		
		step1 = file.nextLine().split(",");
		
		// Ho già nome e cognome separati negli elementi di indice 0 e 1. In indice 2 ho l'ultimo elemento, ancora da splittare
		
		risposta = "\nNome: " + step1[0] + "\nCognome: " +step1[1];
		
		// Splitto per la seconda volta, questa volta per "/", ottenendo un vettore con 4 elementi, tutti da splittare
		
		step2 = step1[2].split("/");
		
		// Con un for splitto i 4 elementi ottenendo un terzo vettore
		
		for(int i = 0; i < step2.length; i++) {
			
			step3 = step2[i].split("-");
			
			// Qui vedo se è mate o ita e aggiorno la media
			
			if(step3[0].equalsIgnoreCase("matematica"))
				mediaMate += Double.parseDouble(step3[1]);
			if(step3[0].equalsIgnoreCase("italiano"))
				mediaIta += Double.parseDouble(step3[1]);
			
		}
		
		// Stampo risposta
		
		risposta += "\nMedia italiano: " + mediaIta/2;
		risposta += "\nMedia matematica: " + mediaMate/2;
		System.out.println(risposta);
		
		
		file.close();
	}
}
