package main;

import java.util.ArrayList;

import entities.Persona;
import entities.Studente;

public class MainScuola 
{
	public static void main(String[] args) 
	{
		Object p = new Persona("Luca", 34);
		
		System.out.println(p);
		
		Persona stud = new Studente("Marco", 28, 7.5, 8.6, 8, 6.7);
		
		System.out.println(stud);
		
		double mediaItaStud;
		
		if(stud instanceof Studente) {
			Studente stud1;
			stud1 = (Studente) stud;
			
			mediaItaStud = stud1.mediaIta;
			System.out.println(mediaItaStud);
		}
		
		// immaginate di avere un ArrayList di oggetti Persona e di voler contare 
		// il numero di oggetti Studente al suo interno
		
		ArrayList<Persona> elenco = new ArrayList<Persona>();
		Persona pers1 = new Persona("Persona 1", 10);
		Persona pers2 = new Persona("Persona 2", 20);
		Persona pers3 = new Persona("Persona 3", 30);
		Studente stud01 = new Studente("Studente 1", 17, 3, 4, 5, 6);
		elenco.add(pers1);
		elenco.add(pers2);
		elenco.add(pers3);
		elenco.add(stud01);
		
		for(int i = 0; i < elenco.size(); i++) {
			System.out.println(i);
			if(elenco.get(i) instanceof Studente) {
				Studente stud1;
				stud1 = (Studente) elenco.get(i);
				
				mediaItaStud = stud1.mediaIta;
				System.out.println("La media è: " + mediaItaStud);
			}
		}
	}
}