package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mappe_02 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		// Creo un insieme che contenga mappe
		// Siccome le mappe sono oggetti, posso inserirle in un ArrayList o in un 
		// Vettore
		ArrayList<Map<String,String>> elenco;
		
		// inizializzo l'elenco
		
		elenco = new ArrayList<Map<String,String>>();
		
		String percorso = "src/res/ElencoLibri.txt";
		
		Scanner file = new Scanner(new File(percorso));
		
		String[] chiavi = file.nextLine().split(",");
		
		// A questo punto dichiaro una mappa che ha come copopia chiave valore String String
		
		Map<String,String> libro;
		
		String[] riga;
		while(file.hasNextLine()) {
			// Ogni riga che legge il programma corrisponde a dei valori da associare alle chiavi
			riga = file.nextLine().split(",");
			
			libro = new HashMap<String,String>();
			
			for(int i = 0; i < chiavi.length; i++) {
				libro.put(chiavi[i], riga[i]);
				
			}
			elenco.add(libro);
		}
		file.close();
		
		String ris = "";
		
		for(Map<String,String> m : elenco) {
			System.out.println(m);
		}
		System.out.println(elenco);
	}
}
