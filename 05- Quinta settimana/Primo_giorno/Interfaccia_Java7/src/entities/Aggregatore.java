package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import interfacce.IAggregatore;

// La parola implements indica che Aggregatore stipula un contratto con IAggregatore
// deeve implementare i metodi contenuti in IAggregatore

public class Aggregatore implements IAggregatore
{
	private ArrayList<Persona> elenco;
	
	public Aggregatore(String percorso) throws FileNotFoundException {
		Scanner file = new Scanner(new File(percorso));
		elenco = new ArrayList<Persona>();
		String[] riga;
		Persona p;
		
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			p = new Persona(riga[0], Integer.parseInt(riga[1]));
			elenco.add(p);
		}
		file.close();
	}
	
	public String stampa() {
		String ris = "";
		for(Persona p : elenco) {
			ris += p.toString() + "\n";
		}
		return ris;
	}

	// scheda() è un metodo dell'interfaccia IAggregatore con la quale la classe 
	// Aggregatore ha un contratto
	@Override
	public String scheda() {
		// il metodo scheda() ritorna il valore del metodo stampa()
		return stampa();
	}
}
