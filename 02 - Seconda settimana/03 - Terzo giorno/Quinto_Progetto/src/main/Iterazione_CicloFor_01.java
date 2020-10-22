package main;

public class Iterazione_CicloFor_01 
{
	public static void main(String[] args)
	{
		int[] numeri = new int[5];
		
		numeri[0] = 10;
		numeri[1] = 10;
		numeri[2] = 10;
		numeri[3] = 10;
		numeri[4] = 10;
		
		int somma = 0;
		
		for(int i = 0; i < numeri.length; i++) {
			somma += numeri[i];
		}
		
		System.out.println(somma);
	}
}
