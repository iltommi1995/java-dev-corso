package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import interfacce.Interf;

public class Negozio implements Interf {
	private ArrayList<Film> elencoFilm;
	
	public Negozio(String path) throws FileNotFoundException {
		Scanner file = new Scanner(new File(path));
		
		String[] riga;
		Film f;
		elencoFilm = new ArrayList<Film>();
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			f = new Film(riga[0], Double.parseDouble(riga[1]));
			elencoFilm.add(f);
		}
	}

	@Override
	public double prezzoMedio() {
		double prezzoMedio = 0;
		for(Film f : elencoFilm) {
			prezzoMedio += f.getPrezzo();
		}
		return prezzoMedio / elencoFilm.size();
	}

	@Override
	public String elencoTitoli() {
		String risp = "";
		for(Film f : elencoFilm) {
			risp += f.toString() + "\n";
		}
		return risp;
	}
	
	
}
