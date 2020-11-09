package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Esercizio_mappe_01 
{
	public static void main(String[] args) 
	{
		String path = "src/res/Menu.txt";
		Scanner tastiera = new Scanner(System.in);
		Scanner file = null;
		try {
			file = new Scanner(new File(path));
			
		} catch (FileNotFoundException e) {
			boolean fileOk = false;
			do {
				System.out.println("Il percorso indicato è sbagliato, inseriscilo di nuovo:");
				path = "src/res/"	+	tastiera.nextLine();
				
				try {
					 file = new Scanner(new File(path));
					fileOk = true;
				} catch (FileNotFoundException e1) {
					fileOk = false;
				}
			} while(fileOk == false);
		}
		
		
		String[] riga;
		ArrayList<Map<String,Double>> elenco = new ArrayList<Map<String,Double>>();
		Map<String,Double> piatto;
		
		while(file.hasNextLine()) {
			riga = file.nextLine().split(":");
			piatto = new LinkedHashMap<String,Double>();
			piatto.put(riga[0], Double.parseDouble(riga[1]));
			elenco.add(piatto);
		}
		
		
		// piatto più caro
		
		double prezzo = 0;
		double prezzoMedio = 0;
		String res = "";
		for (int i = 0; i < elenco.size(); i++) {
			for(String s : elenco.get(i).keySet()) {
				if(elenco.get(i).get(s) == prezzo) {
					prezzo = elenco.get(i).get(s);
					res += s + " " + prezzo + "\n";
				}
				if(elenco.get(i).get(s) > prezzo) {
					prezzo = elenco.get(i).get(s);
					res = s + " " + prezzo + "\n";
				}
				prezzoMedio += elenco.get(i).get(s);
			}
			
		}
		System.out.println(
						"ELENCO PRODOTTI PIU CARI:\n" 	+ 
						res 							+ 		
						"\nIl prezzo medio è: " 		+ 	(prezzoMedio/elenco.size())	+ "€");
		
	}

}
