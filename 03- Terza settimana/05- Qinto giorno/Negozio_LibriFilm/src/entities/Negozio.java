package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Negozio {
	
	public ArrayList<Prodotto> catalogo;
	
	public Negozio(String percorso) throws FileNotFoundException 
	{
		catalogo = new ArrayList<Prodotto>();
		
		Scanner file = new Scanner(new File(percorso));
		
		
		String[] riga;
		Prodotto p;
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			switch(riga[0].toLowerCase()) {
				case "film":
					p = new Film(riga[1], riga[2], riga[3], Integer.parseInt(riga[4]), Double.parseDouble(riga[5]));
					catalogo.add(p);
				break;
				case "libro":
					boolean saga = riga[6].equalsIgnoreCase("si") ? false : true;
					p = new Libro(riga[1], riga[2], riga[3], Integer.parseInt(riga[4]), Integer.parseInt(riga[5]), saga);
					catalogo.add(p);
				break;
			}
		}
		file.close();
	}
	
	
	public String elencoProdotti() {
		String output = "\nEcco la lista di tutti i prodotti:\n ";
		
		for(int i = 0; i < catalogo.size(); i++) {
			output += "\n" + (i+1) + "- " + catalogo.get(i) + "\n";
		}
		
		return output;
	}
	
	public String elencoFilm() {
		String output = "\nEcco la lista di tutti i film:\n";
		
		for(int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i) instanceof Film)
			output += "\n" + (i+1) + "- " + catalogo.get(i) + "\n";
		}
		
		return output;
	}
	
	public String elencoLibri() {
		String output = "\nEcco la lista di tutti i libri:\n";
		
		for(int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i) instanceof Libro)
			output += "\n" + (i+1) + "- " + catalogo.get(i) + "\n";
		}
		
		return output;
	}
	
	public String mediaPagTot() {
		String output = "\nEcco la media delle pagine di tutti i libri: ";
		int media = 0;
		int counter = 0;
		for(int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i) instanceof Libro) {
				Libro l;
				l = (Libro) catalogo.get(i);
				media += l.nPagine;
				counter++;
			}
		}
		output += (media/counter) + " pagine.";
		return output;
	}
	
	public String mediaPagSciFi() {
		String output = "\nEcco la media delle pagine dei libri sci-fi: ";
		int media = 0;
		int counter = 0;
		for(int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i) instanceof Libro && catalogo.get(i).tipo.equalsIgnoreCase("fantascienza")) {
				Libro l;
				l = (Libro) catalogo.get(i);
				media += l.nPagine;
				counter++;
			}
		}
		output += (media/counter) + " pagine.";
		return output;
	}
	
	public String mediaDurataFilm() {
		String output = "\nEcco la durata media dei film in ore è: ";
		double media = 0;
		int counter = 0;
		for(int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i) instanceof Film) {
				Film f;
				f = (Film) catalogo.get(i);
				media += f.durata;
				counter++;
			}
		}
		output += ((media / 60) / counter) + " ore.";
		return output;
	}
	
	public String durataTotFilmSciFi() {
		String output = "\nEcco la durata totale dei film sci-fi: ";
		double durataTot = 0;
		for(int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i) instanceof Film && catalogo.get(i).tipo.equalsIgnoreCase("fantascienza")) {
				Film f;
				f = (Film) catalogo.get(i);
				durataTot += f.durata;
			}
		}
		output += (durataTot / 60) + " ore.";
		return output;
	}
	
	public String libriSerie() {
		String output = "\nEcco l'elenco dei libri appartenenti a una serie:\n";
		for(int i = 0; i < catalogo.size(); i++) {
			if(catalogo.get(i) instanceof Film) {
				Libro l;
				l = (Libro) catalogo.get(i);
				if(l.singolo == false) {
					output += "\n" + (i+1) + "- " + catalogo.get(i) + "\n";
				}
			}
		}
		return output;
	}

}
