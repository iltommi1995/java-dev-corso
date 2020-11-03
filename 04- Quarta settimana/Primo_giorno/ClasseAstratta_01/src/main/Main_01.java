package main;

import entities.Libro;
import entities.Prodotto;

public class Main_01 {
	public static void main(String[] args) {
		Prodotto p = new Libro("Titolo", 20, 300);
		System.out.println(p.toString());
	}
}
