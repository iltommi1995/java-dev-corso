package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vettori_String_LetturaFile_01 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\05 - Quinto giorno\\Settimo_Progetto\\src\\res\\ElencoLibri.txt";
		Scanner file =  new Scanner(new File(percorso));
		
		String nomeLibreria = file.nextLine();
		int dimensioneVettore = Integer.parseInt(file.nextLine());
		
		String[] titoli = new String[dimensioneVettore];
		String[] autori = new String[dimensioneVettore];
		double[] prezzi = new double[dimensioneVettore];
		
		String[] rigaFile;
		int indice = 0;
		while(file.hasNextLine()) {
			rigaFile = file.nextLine().split(",");
			titoli[indice] = rigaFile[0];
			autori[indice] = rigaFile[1];
			prezzi[indice] = Double.parseDouble(rigaFile[2]);
			indice ++;
		}
		
		String elenco = "";
		for(int i = 0; i < titoli.length; i++) {
			elenco += titoli[i] + ", " + autori[i] + ", " + prezzi[i] + "€\n";
		}
		
		System.out.println(nomeLibreria + "\n" + elenco);
		
		file.close();

	}
}
