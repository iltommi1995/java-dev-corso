package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainStudente {
	public static void main(String[] args) throws FileNotFoundException 
	{
		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\03- Terza settimana\\01- Primo giorno\\Ottavo progetto\\src\\res\\ElencoStudenti.txt";
		Scanner file = new Scanner(new File(percorso));
		
		int dimensione = Integer.parseInt(file.nextLine());
		
		Studente[] studenti = new Studente[dimensione];
		int indice = 0;
		Studente s;
		String[] riga;
		
		// prima riga
		double totItaliano = 0;
		double mediaTot= 0;
		
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			s = new Studente();
			s.nome = riga[0];
			s.eta = Integer.parseInt(riga[1]);
			s.classe = Integer.parseInt(riga[2]);
			s.mediaIta = Double.parseDouble(riga[3]);
			s.mediaMate = Double.parseDouble(riga[4]);
			
			// secconda riga
			totItaliano += s.mediaIta;
			mediaTot += (s.mediaMate + s.mediaIta) / 2;
			
			studenti[indice] = s;
			indice++;
		} // Fine di while
		
		String elenco = "";
		for(int i = 0; i < studenti.length; i++) {
			elenco += studenti[i].scheda() + "\n";
		}
		System.out.println(elenco 
				+ "\nLa media di italiano della classe è: " + (totItaliano/studenti.length) 
				+ "\nLa media totale è :" + (mediaTot / studenti.length));
		
		// Calcolare la media di italiano dell'intera classe!
	}
}
