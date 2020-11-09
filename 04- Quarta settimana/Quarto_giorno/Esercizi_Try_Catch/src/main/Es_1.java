package main;

import java.util.Scanner;

public class Es_1 {

	public static void main(String[] args) {
		// Scrivere un programma che chiede all'utente un numero
		// Se riceve una String gestire l'eccezione con un try catch
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci un numero:");
			
		int numero = 0;
		
		try {
			numero = Integer.parseInt(tastiera.nextLine());
		} catch (java.lang.NumberFormatException e) {
			System.out.println("Devi inserire un valore numerico");
		}
		
		System.out.println(numero);
		tastiera.close();
	}

}
