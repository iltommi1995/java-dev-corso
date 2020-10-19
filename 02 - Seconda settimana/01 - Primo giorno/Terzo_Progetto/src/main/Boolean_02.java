package main;

import java.util.Scanner;

public class Boolean_02 {
	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		String filmPreferito;
		boolean amico = false;
		String risposta;
		
		System.out.println("Indica il tuo film preferito");
		
		filmPreferito = tastiera.nextLine();
		
		if(filmPreferito.equalsIgnoreCase("jurassic park")) 
			amico = true;
		if(filmPreferito.equalsIgnoreCase("goonies")) 
			amico = true;
		if(filmPreferito.equalsIgnoreCase("twilight")) 
			amico = true;
		if(filmPreferito.equalsIgnoreCase("artemis fowl")) 
			amico = true;
		
		if(amico == true)
			risposta = "sei mio amico";
		else
			risposta = "Non sei mio amico";
		
		System.out.println(risposta);
		tastiera.close();
		
	}
}
