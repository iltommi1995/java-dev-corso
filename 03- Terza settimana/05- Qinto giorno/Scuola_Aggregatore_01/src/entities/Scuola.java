package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scuola {
	public ArrayList<Persona> elenco;
	
	// Al costruttore di Scuola viene passato il eprcorso di un file
	// Il costruttore si occupa di creare gli oggetti e di inserirli all'interno
	// dell'arraylist elenco
	
	public Scuola(String percorso) throws FileNotFoundException 
	{	
		// Per prima cosa creo l'ArrayList
		elenco = new ArrayList<Persona>();
		
		Scanner file = new Scanner(new File(percorso));
		
		
		String[] riga;
		Persona p;
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			switch(riga[0].toLowerCase()) {
				case "persona":
					p = new Persona(riga[1]);
					elenco.add(p);
				break;
				case "studente":
					p = new Studente(riga[1], Integer.parseInt(riga[2]));
					elenco.add(p);
				break;
			}
		}
		file.close();
	} // Fine costruttore
	
	public String elencoPersone() 
	{
		String ris = "";
		for(int i = 0; i < elenco.size(); i++) {
			if(elenco.get(i) instanceof Studente) {
				ris += elenco.get(i).toString() + "\n";
			}
		}
		return ris;
	}

}
