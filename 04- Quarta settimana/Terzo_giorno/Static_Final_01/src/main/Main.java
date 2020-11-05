package main;

import entities.Persona;

public class Main {
	public static void main (String[] args) {

		Persona p = new Persona("l");
		System.out.println(Persona.ETAMINIMA);
		
		Persona.LUNGHEZZAMINIMANOME = -1;
		
		System.out.println(p.toString());
	}
}
