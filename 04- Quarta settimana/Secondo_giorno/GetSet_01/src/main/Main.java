package main;

import entities.Persona;

public class Main 
{
	public static void main(String[] args) 
	{
		Persona p = new Persona("Tomas");
		System.out.println(p.getNome());
		
		p.setNome("Marco");
		System.out.println(p.getNome());
		
	}
}
