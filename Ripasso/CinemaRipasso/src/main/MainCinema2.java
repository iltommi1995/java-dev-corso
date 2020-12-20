package main;

import java.util.Scanner;

import dao.DAOAttore;
import dao.DAOFilm;
import utils.Vik;

public class MainCinema2 {

	public static void main(String[] args) 
	{
		DAOAttore a = new DAOAttore();
		
		DAOFilm f = new DAOFilm();


		boolean continua = false;
		int scelta = -2000;
		Scanner tastiera = new Scanner(System.in);
		do {
			String opzioni = 	"\nScegli una delle seguenti opzioni:\n" 	+
								"1- Stampa tutti gli attori\n" 				+
								"2- Stampa attori che recitano in un film x\n"				+
								"3- Stampa attori che guadagnano meno di x\n"				+
								"4- Stampa tutti i film\n"									+
								"5- Cerca film per titolo\n"								+
								"6- Cerca film per attore\n"								;
			System.out.println(opzioni);
			
			scelta = Integer.parseInt(tastiera.nextLine());
			String [] param;
			String ris = "";
			double media = 0;
			switch(scelta) {
				case 1:
					System.out.println(Vik.stampaListaAttori(a.listaAttori()));
					continua = Vik.continua(tastiera);
				break;
				case 2:
					System.out.println("\nScrivi l'id del film di cui vuoi vedere gli attori");
					System.out.println(Vik.stampaListaAttori(a.listaAttoriFilm(Integer.parseInt(tastiera.nextLine()))));
					continua = Vik.continua(tastiera);
				break;
				case 3:
					System.out.println("\nScrivi il costo max");
					System.out.println(Vik.stampaListaAttori(a.listaAttori(Integer.parseInt(tastiera.nextLine()))));
					continua = Vik.continua(tastiera);
				break;
				case 4:
					System.out.println(Vik.stampaListaFilm(f.listaFilm()));
					continua = Vik.continua(tastiera);
				break;
				case 5:
					System.out.println("\nInserisci la parola chiave");
					System.out.println(Vik.stampaListaFilm(f.cercaFilm(tastiera.nextLine())));
					continua = Vik.continua(tastiera);
				break;
				case 6:
					System.out.println("\nInserisci il cognome");
					System.out.println(Vik.stampaListaFilm(f.cercaPerAttore(tastiera.nextLine())));
					continua = Vik.continua(tastiera);
				break;
			}
			
			
			
		} while(continua);
		
		
		System.out.println("\nGrazie e ciao");	
	}

}
