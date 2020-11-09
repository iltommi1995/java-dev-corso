package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Mappe_03 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Dichiaro un insieme che contenga mappe
		//Siccome le mappe sono oggetti, posso inserirle in un ArrayList o in un vettore
		//elenco sarà un ArrayList che conterrà oggetti di tipo Map<String,String>
		//Attenzione perché un oggetto di tipo Map<String,String> è diverso da un oggetto
		//di tipo map<String,int> ad esempio
		//Il tipo di chiave e il tipo di valore modificano l'oggetto Map
		ArrayList<Map<String,String>> elenco;
		
		//Inizializzo elenco
		elenco = new ArrayList<Map<String,String>>();
		
		//String percorsoLibri = "src/res/ElencoLibri.txt";
		String percorsoSpesa = "src/res/ElencoSpesa.txt";
		Scanner file = new Scanner(new File(percorsoSpesa));
		
		//Siccome nel mio file le chiavi sono tutte uguali e si ripetono,
		//leggo la prima riga e la splitto per avere le chiavi
		//CHIAVI -> autore,titolo,nPagine,genere
		String[] chiavi = file.nextLine().split(",");
		
		//A questo punto dichiaro una mappa che ha come coppia chiave valore String, String
		Map<String,String> libro;
		
		//Ciclo il file dalla seconda riga
		String[] rigaLibro;
		while(file.hasNextLine())
		{
			//Ogni riga che legge il programma corrisponde a dei valori da associare alle chiavi
			//La prima riga sarà: Licia Troisi,Cronache del mondo emerso,300,Fantasy
			rigaLibro = file.nextLine().split(",");
			
			//Inizializzo la mappa
			//Le HashMap ordinano le coppie chiave valore in modo disordinato
			//Le LinkedHashMap invece le ordinano
			//libro = new HashMap<String,String>();
			libro = new LinkedHashMap<String,String>();
			
			//Ciclo rigaLibro e associo i valori al suo interno alle chiavi attravero un ciclo for
			for(int i = 0; i < chiavi.length; i++)
			{
				//Al primo giro del for, i vale 0 quindi
				//chiavi[i] -> autore
				//rigaLibro[i] -> Licia Troisi
				libro.put(chiavi[i], rigaLibro[i]);
			}
			
			//Una volta creato il libro, quindi una volta che tutte le chiavi sono state
			//associate al proprio valore, aggiungo la mappa libro all'ArrayList di mappe elenco
			elenco.add(libro);
		}//Fine del while
		//A questo punto, il mio elenco conterrà tanti libri quante sono le righe del file
		//dopo la seconda
		file.close();
		
		String ris = "";
		for(Map<String,String> m : elenco)
			ris += m + "\n-----------------------\n";
		//System.out.println(ris);
		
		String valoreCercato = "cheddar";
		ris = "Cibi del reparto " + valoreCercato + "\n";
		for(Map<String,String> m : elenco)
			if(m.containsValue(valoreCercato))
				ris += m + "\n----------------------------\n";
		//System.out.println(ris);
		
		valoreCercato  = "10";
		ris = "Cibi che hanno come valore o chiave " + valoreCercato + "\n";
		for(Map<String,String> m : elenco)
			if(m.containsValue(valoreCercato) || m.containsKey(valoreCercato))
				ris += m + "\n----------------------------\n";
		System.out.println(ris);
		
		//Proviamo a fare lo scontrino
		double scontrino = 0;
		double prezzoSingolo;
		int quantita;
		for(Map<String,String> m : elenco)
		{
			prezzoSingolo = Double.parseDouble(m.get("prezzo"));
			quantita = Integer.parseInt(m.get("quantita"));
			scontrino += (prezzoSingolo * quantita);
		}
		System.out.println("Scontrino: " + scontrino + "€");
	}

}
