package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Libro;

public class Main_01 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		/*
		 * Leggete un file di oggetti di tipo Libro
		 * La classe Libro ha le seguenti proprietà:
		 * 			-String titolo
		 * 			-String autore
		 * 			-String genere
		 * 			-double prezzo
		 * Utilizzare i getters e i setters:
		 * fare in modo che se ci sono errori nel file, come ad esempio un campo vuoto
		 * o un prezzo minore di 0, non vi stampi il libro
		 * Stampare l'elenco SOLO dei libri i cui valori sono ammissibili
		 * 
		 * File:
		 * Necronomicon,Lovercraft,Horror,-1
		 * Guida galattica per autostoppisti,Adams,Fantascienza,10
		 * I pilastri della terra,,Storico,18
		 * 
		 * Deve stampare solo guida galattica
		 * 
		 * Rifattorizzare esercizio precedente di Scuola con get, set
		 * 
		 * Fare in modo che il programm controlli il genere del libro, se il genere non rientra in 
		 * quelli possibili, non stamparlo
		 */
		String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\04- Quarta settimana\\Secondo_giorno\\Esercizio_GetSet_01\\src\\res\\Libri.txt";
		Scanner file = new Scanner(new File(path));
		
		ArrayList<Libro> elencoLibri = new ArrayList<Libro>();
		
		Libro l;
		String[] rigafile;
		while(file.hasNextLine()) {
			rigafile = file.nextLine().split(",");
			l = new Libro(rigafile[0], rigafile[1], rigafile[2], Double.parseDouble(rigafile[3]));
			elencoLibri.add(l);
		}
		String elenco = "";
		for(Libro li : elencoLibri) {
			if(li.getAutore().equalsIgnoreCase("ERROR - L'AUTORE DA TE INSERITO NON E' VALIDO") || li.getPrezzo() == 0)
				elenco += "";
			else
				elenco+= li.toString();
		}
		
		System.out.println(elenco);
	}
}
