package main;

import java.util.Scanner;

public class Operatore_Ternario_01 
{
	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Quanti anni hai?");
		int eta = Integer.parseInt(tastiera.nextLine());
		
		String risposta = eta >= 8 ? "Maggiorenne" : "Minorenne";
		
		tastiera.close();
	}
}
