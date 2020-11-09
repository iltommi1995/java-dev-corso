package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Terminale;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Persona abstract:
		 * 		String nome, int eta, toString(), esito(), media()
		 * 		media ed esito abstract
		 * 
		 * Studente extends Persona
		 * 		int classe, double mediaIta, double mediaMate
		 * 		toString(), media(), esito()
		 * 
		 * StudErasmus extends Studente
		 * 		double mediaIng, double mediaFra
		 * 		toString(), media(), mediaLingue(), esito()
		 * 
		 * Leggere da un file e creare gli oggetti solo se i valori sono
		 * ammissibili
		 * elenco()
		 * elenco(int classe)
		 * cerca(string nome)
		 * mediaTotInglese()
		 * 
		 * tutte le proprietà sono private e verranno lette e impostate tramite getters e 
		 * setters
		 * 
		 */
		Scanner tastiera = new Scanner(System.in);
		Terminale terminal = new Terminale(tastiera);
		System.out.println(terminal.output());
		tastiera.close();
		
	}

}
