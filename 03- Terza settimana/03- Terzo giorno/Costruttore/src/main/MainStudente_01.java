package main;

import entities.Studente;

public class MainStudente_01 {

	public static void main(String[] args) {
		// Creare una classe Studente con le seguenti proprietà dell'oggetto:
		// nome, cognome, classe, mediaIta, mediaMate
		// creare un costruttore nella classe Studente
		// Nel main, creare un oggetto Studente tramite il costrttore
		
		//Provare poi a careare nuovo ogg studente che abbia come proprietà
		//solo nome e mediaTotale -> mediaTotale è dato dalla somma delle medie / 2
		
		Studente s = new Studente("Marco", "Bianchi", "5G", 6.5, 7.3);
		System.out.println(s.scheda());
		
		Studente st = new Studente("Luca", 6.5, 8.0);
		System.out.println(st.scheda2());
	}

}
