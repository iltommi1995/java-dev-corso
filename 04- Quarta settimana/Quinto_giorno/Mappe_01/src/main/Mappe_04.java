package main;

import java.util.LinkedHashMap;
import java.util.Map;

public class Mappe_04 {

	public static void main(String[] args) {
		// Mappa: è un insieme di coppie chiave-valore. 
		// In una mappa le chiavi devono essere univoche
		// Le chiavi e i valori possono essere di qualunque tipo,
		// l'importante è che siano tipi boxati, non primitivi
		
		Map<String, Integer> elenco = new LinkedHashMap<String, Integer>();
		
		// Inserimento nelle mappe
		elenco.put("Alice", 23);
		elenco.put("Luca", 31);
		elenco.put("Marco", 14);
		elenco.put("Mario", 20);
		
		// Grandezza di una mappa
		
		int i = elenco.size();
		System.out.println(i);
		
		// Ciclare una mappa 
				// .keySet() è un metodo che ritorna l'insieme delle chiavi di una 
				// mappa. Legge unicamente le chiavi
		
		for (String k : elenco.keySet()) {
			System.out.println("Chiave " + k);
			System.out.println("Valore: " + elenco.get(k));
			
		}


		elenco.containsKey(12);
		elenco.containsValue("Marco");
	}

}
