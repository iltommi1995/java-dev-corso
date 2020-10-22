package main;

import java.util.Scanner;

public class Iterazione_CicloFor_03 
{
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Quanti numeri vuoi considerare?");
		int grandezza = Integer.parseInt(tastiera.nextLine());
		
		int[] numeri = new int[grandezza];
		
		for(int i = 0; i < numeri.length; i++)
		{
			numeri[i] = i;
		}
		
		String numeriPari = "";
		String numeriDispari = "";
		for(int i = 0; i < numeri.length; i++) {
			if((i % 2) == 0)
				numeriPari += numeri[i];
			else
				numeriDispari += numeri[i];
		}
		
		System.out.println(numeriPari + "\n" + numeriDispari);
		tastiera.close();
	}
}
