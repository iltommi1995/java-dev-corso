package main;

public class MainLibro {

	public static void main(String[] args) {
		/*
		 * Creare una classe modello Libro con proprietà: autore, titolo, genere, prezzo. 
		 * nel main creare 3 oggetti di tipo libro e stamparli
		 */
		
		Libro libro1 = new Libro();
		libro1.autore = "Tolkien";
		libro1.titolo = "Il signore degli anelli";
		libro1.genere = "Fantasy";
		libro1.prezzo = 20.5;
		
		Libro libro2 = new Libro();
		libro2.autore = "Ballard";
		libro2.titolo = "La mostra delle atrocità";
		libro2.genere = "Romanzo";
		libro2.prezzo = 10.0;
		
		Libro libro3 = new Libro();
		libro3.autore = "Palahniuk";
		libro3.titolo = "Fight Club";
		libro3.genere = "Thriller";
		libro3.prezzo = 12.5;
		
		Libro libro4 = new Libro();
		libro4.autore = "Tolkien";
		libro4.titolo = "Il Silmarillion";
		libro4.genere = "Fantasy";
		libro4.prezzo = 25.0;
		
		System.out.println(libro1.stampaLibro() + libro2.stampaLibro() + libro3.stampaLibro() + libro4.stampaLibro());
	}

}
