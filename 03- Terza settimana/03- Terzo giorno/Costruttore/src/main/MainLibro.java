package main;

import entities.Libro;

public class MainLibro 
{
	public static void main(String[] args) 
	{
		String parametroTitolo = "1984";
		String parametroAutore = "Orwell";
		int parametroPrezzo = 15;
		
		Libro l;
		
		l = new Libro(parametroAutore, parametroAutore, parametroPrezzo);
		
		
		
		System.out.println(l.scheda());
	}
}
