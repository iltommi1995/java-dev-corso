package main;

import java.util.Scanner;

public class Main_Eccezione_01 
{
	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci un numero");
		
		try {
			
			int numero = Integer.parseInt(tastiera.nextLine());
			
			System.out.println(numero);
		}
		catch(NumberFormatException e) {
			System.out.println("Hai inserito un valore non valido " + e);
		}
		
		tastiera.close();
	}
}
