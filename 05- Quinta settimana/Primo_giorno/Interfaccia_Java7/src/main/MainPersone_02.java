package main;

import java.io.FileNotFoundException;

import entities.Aggregatore;
import interfacce.IAggregatore;

public class MainPersone_02 {

	public static void main(String[] args) {

		try {
			IAggregatore a = new Aggregatore("src/res/ElencoPersone.txt");
			System.out.println(a.scheda());
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato");
		}
	}
}
