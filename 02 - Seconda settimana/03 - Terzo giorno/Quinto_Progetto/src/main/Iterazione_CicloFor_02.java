package main;

public class Iterazione_CicloFor_02 
{
	public static void main(String[] args) 
	{
		int[] numeri;
		
		String numeriPari = "";
		String numeriDispari = "";
		
		numeri = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0; i < numeri.length; i++) {
			if((i % 2) == 0)
				numeriPari += numeri[i];
			else
				numeriDispari += numeri[i];
		}
		
		System.out.println(numeriPari + "\n" + numeriDispari);
	}
}
