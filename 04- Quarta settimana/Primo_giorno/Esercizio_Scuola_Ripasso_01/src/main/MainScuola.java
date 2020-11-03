package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Terminale;

public class MainScuola 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		//Persona: nome,cognome,eta
		//Studente: figlio di persona, classe,mediaIta,mediaMate
		//			esito(), media()
		//Insegnante: figlio di persona, materia,anniLavoro,
		//			  stipendio()
		//Scuola: aggregatore, numeroPersone(), numeroStudenti(),numeroInsegnanti(),elenco()
		//			elenco(int eta) (prende come parametro e verifica quali persone hanno
		//			età superiore di quella del parametro)
		//			elencoStudenti(), elencoInsegnanti(), elencoStudenti(int classe),
		// 			elencoInsegnanti(String materia), elencoPromossi(), insegnanteRicco(),
		//			insegnanteRicco(double stipendio)
		//l'ultimo metodo prende in ingresso un parametro e verifica gli insegnanti con
		// uno stipendio maggiore di quello passato.
		//
		// Stampare tutti i metodi
		Scanner tastiera = new Scanner(System.in);
		Terminale ui = new Terminale();
		
		System.out.println(ui.programmaCompleto(tastiera));
		
		tastiera.close();
	}
}
