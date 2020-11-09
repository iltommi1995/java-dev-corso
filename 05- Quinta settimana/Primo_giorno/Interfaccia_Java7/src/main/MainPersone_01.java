package main;

import java.io.FileNotFoundException;

import entities.Aggregatore;

public class MainPersone_01 {

	public static void main(String[] args) {
		try {
			Aggregatore a = new Aggregatore("src/res/ElencoPersone.txt");
			System.out.println(a.scheda());
		} catch(FileNotFoundException e) {
			System.out.println("File non trovato");
		}
	}
}
