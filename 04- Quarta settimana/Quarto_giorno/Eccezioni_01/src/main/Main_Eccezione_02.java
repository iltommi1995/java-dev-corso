package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_Eccezione_02 {

	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File(""));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// throws fileNotFoundException significa che il programma non gestisce l'eccezione
		// filenotfoundexception. All'interno di un programma infatti, una classe può in certi
		// casi decidere di non gestire l'eccezione ma di rimandare ad altri. 
		// In pratica puoi gestire l'eccezione o fare scaricabarile.

	}

}
