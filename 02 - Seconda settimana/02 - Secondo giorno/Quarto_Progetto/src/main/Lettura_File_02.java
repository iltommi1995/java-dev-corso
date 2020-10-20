package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lettura_File_02 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		String percorsoFile = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\02 - Secondo giorno\\Quarto_Progetto\\src\\res\\ElencoDestinazioni.txt";
		Scanner file = new Scanner(new File(percorsoFile));
		
		String destinazione = "";
		double prezzo = 0;
		double prezzoTotale = 0;
		int nDestinazioni = 0;
		String elenco = "";
		String capitali = "";
		
		while(file.hasNextLine()) {
			destinazione = file.nextLine();
			capitali = file.nextLine();
			prezzo = Double.parseDouble(file.nextLine());
			nDestinazioni ++;
			prezzoTotale += prezzo;
			elenco += destinazione + " " + capitali + " " + prezzo + "€\n";
			
		}
		System.out.println(elenco + "Prezzo totale: " + prezzoTotale + "€\n" + "Prezzo medio: " + ( prezzoTotale / nDestinazioni) + "€");
		file.close();
	}
}
