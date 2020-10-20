package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lettura_File_01 {
	public static void main(String[] args) throws FileNotFoundException 
	{
		String percorsoFile = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\02 - Secondo giorno\\Quarto_Progetto\\src\\res\\Elenco.txt";
		
		Scanner file = new Scanner(new File(percorsoFile));
		
		String riepilogo = "";
		
		while(file.hasNextLine()) {
			riepilogo += "- " + file.nextLine() + "\n";
		}
		
		System.out.println(riepilogo);
		file.close();
		
	}
}
