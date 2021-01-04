package com.myproject.imdb.test;

public class Logica {

	public static void main(String[] args) 
	{
		System.out.println(criptare("AAAAABBCDDDDEEE aaaegsvssss    sad"));
	}
	
	public static String criptare(String frase)
	{
		String[] lettere = frase.split("");
		
		int counter = 0;
		String lettera = "";
		
		String ris = "";
		// AAAAABBCDDDDEEB 
		for(int i = 0; i < lettere.length; i++)
		{	
			if(i == 0)
			{
				counter++;
				lettera = lettere[i];
			}
			else
			{
				if(lettera.equalsIgnoreCase(lettere[i]))
				{
					counter++;
				}
				else
				{
					if(counter < 3)
					{
						for(int e = 0; e < counter; e++)
							ris += lettera;
					}
					else
					{
						ris += counter + lettera;
					}
					lettera = lettere[i];
					counter = 1;
				}
			}
		}
		if(counter < 3)
		{
			for(int e = 0; e < counter; e++)
				ris += lettera;
		}
		else
		{
			ris += counter + lettera;
		}
		return ris;
	}
}
