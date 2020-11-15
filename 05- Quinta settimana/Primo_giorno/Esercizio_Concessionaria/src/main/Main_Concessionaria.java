package main;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import entities.Concessionaria;
import interfacce.IConcessionaria;
import util.Util;

public class Main_Concessionaria 
{
	public static void main(String[] args) 
	{
		// Creo oggetto Concessionaria
		
		IConcessionaria conc = null;
		
		try {
			conc = new Concessionaria("src/res/Concessionaria.txt");
		} catch (FileNotFoundException e) {
			System.out.println("\nIl percorso indicato è sbagliato!");
		}
		
		// Scelta utente
		Scanner tastiera = new Scanner(System.in);
		boolean continua = false;

		do {
			// TRY CATCH DA FARE
			boolean coErr = false;
			int scelta = -2000;
			do {
				coErr = false;
				try {
					System.out.println(	
							"\nQuale delle seguenti operazioni vuoi:\n"							+
							"1- Lista di tutti i prodotti\n"									+
							"2- Lista delle moto\n"												+	
							"3- Lista prodotti immatricolati da meno di 8 anni\n"				+
							"4- Schede dei mezzi che possono fare più km\n"						+
							"5- Lista auto potenti\n"											+
							"6- Lista mezzi di una certa categoria\n"							+
							"7- Lista della frequenza per categoria\n"							+
							"8- Schede di tutti i mezzi della marca ricercata\n"				+
							"9- Lista ordinata per prezzo dei mezzi\n"							);
					scelta = Integer.parseInt(tastiera.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("\nDevi inserire valori numerici.");
					coErr = true;
				}
			} while(coErr == true);
			
			
			switch(scelta) {
			case 1:
				System.out.println(Util.stampa(conc.listaCompleta()));
				continua = Util.continua(tastiera);
			break;
			case 2:
				System.out.println(Util.stampa(conc.listaMoto()));
				continua = Util.continua(tastiera);
			break;
			case 3:
				System.out.println(Util.stampa(conc.listaVecchie()));
				continua = Util.continua(tastiera);
			break;
			case 4:
				System.out.println(conc.maxDistanza());
				continua = Util.continua(tastiera);
			break;
			case 5:
				System.out.println(Util.stampa(conc.autoSuper()));
				continua = Util.continua(tastiera);
			break;
			case 6:
				System.out.println("inserisci la categoria che stai cercardo");
                String categoria= tastiera.nextLine();
                System.out.println(Util.stampa(conc.cercaCategoria(categoria)));
				continua = Util.continua(tastiera);
			break;
			case 7:
				Map<String, Integer> freq =  conc.frequenza();
				String ris = "";
				 
				for(String s : freq.keySet()) {
					ris += "La quantità di " + s + " è: " + freq.get(s) + "\n";
				}
				System.out.println(ris);
				continua = Util.continua(tastiera);
			break;
			case 8:
				System.out.println("Inserisci la marca che stai cercando:");
                String marca = tastiera.nextLine();
				System.out.println(conc.cercaMarca(marca));
				continua = Util.continua(tastiera);
			break;
			case 9:
				System.out.println(Util.stampa(conc.ordinati()));
				continua = Util.continua(tastiera);
			break;
			default:
				System.out.println("\nLa scelta selezionata non è presente.\n");
				continua = Util.continua(tastiera);
			}
		}while(continua);
		System.out.println("\nGrazie e arrivederci.");
		tastiera.close();
	}
}
