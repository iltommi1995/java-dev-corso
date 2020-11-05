package main;

import entities.Persona;
import util.Vik;

public class Main 
{
	public static void main(String[] args) 
	{
		Persona p;
		String valoreNome = "Luca";
		
		if(Vik.controllaString(valoreNome))
			p = new Persona(valoreNome);
		
		String[] nomi = {"Luca", "Marco", "Giovanni"};
		String nomeDaVerificare = "Pippo";
		Vik.controllaNumeri(2);
		System.out.println(Vik.appartieneA(nomeDaVerificare, nomi));
	}
}
