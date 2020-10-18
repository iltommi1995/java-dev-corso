package main;

import java.util.Scanner;

public class InputUtente01 
{
	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci il nome del tuo supereroe preferito");
		String nome = tastiera.nextLine();
		
		System.out.println("Ciao " + nome);
		tastiera.close();
	}
}
