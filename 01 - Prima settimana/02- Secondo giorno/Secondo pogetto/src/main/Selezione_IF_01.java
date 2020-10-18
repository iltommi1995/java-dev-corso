package main;

import java.util.Scanner;

public class Selezione_IF_01 
{
	public static void main(String[] args) 
	{
		// Dichiarazione
		Scanner tastiera = new Scanner(System.in);
		String nome;
		String risposta;
		
		// Inizializzazione o Input
		risposta = "Tu non puoi... passare!!!";
		System.out.println("Come ti chiami?");
		nome = tastiera.nextLine();
		
		// If
		if(nome.equals("tomas")) 
			risposta = "benvenuto!";
		
		
		System.out.println(risposta);;
		tastiera.close();
	}
}
