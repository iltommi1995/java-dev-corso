package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scuola {
	// Questa classe dimostra il funzionamento delle eccezioni non gestite
	// Questa classe è da considerarsi insieme al file mainEccezione_03 
	
	ArrayList<String> elenco = new ArrayList<String>();
	
	public Scuola(String percorsoFile) throws FileNotFoundException {
		
		Scanner file = new Scanner(new File(percorsoFile));
	}
}
