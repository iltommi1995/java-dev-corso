package main;

import java.util.Scanner;

public class Iterazione_01 
{
	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		int numero;
		
		System.out.println("Scrivi un numero e conterò a ritroso fino a zero");
		numero = Integer.parseInt(tastiera.nextLine());

		while(numero > 0 ) {
			System.out.println(numero);
			numero --;
		}
	}
}
