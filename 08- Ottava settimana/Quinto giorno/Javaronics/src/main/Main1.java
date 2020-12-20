package main;

import java.util.Scanner;

import entities.Negozio;
import utility.Vik;

public class Main1 {

	public static void main(String[] args) {
		Negozio n = new Negozio("src/res/prodotti.txt");
		//System.out.println(n.toString());
		Scanner tastiera = new Scanner(System.in);
		int opzione = -20;
		boolean continua = true;
		String menu = 	"\nScegli una delle opzioni seguenti:\n"					+
						"1- Elenco prodotti\n"										+
						"2- Prezzo totale\n"										+
						"3- Prezzo medio prodotti\n"								+
						"4- Prezzo medio portatili\n"								+
						"5- Prezzo medio pc\n"										+
						"6- Elenco prodotti sotto a un prezzo dato\n"				+
						"7- Elenco prodotti per marca data\n"						+
						"8- Elenco prodotti con ram e hd numeri pari\n"				+
						"9- Numero prodotti da gaming\n"							+
						"10- Elenco prodotti da gaming per tipo dato\n"				+
						"11- Prezzo totale prodotti validi\n"						+
						"12- Elenco prodotti validi e complessi\n"					;
		do {
			System.out.println(menu);
			opzione = Integer.parseInt(tastiera.nextLine());
			
			switch(opzione) {
				case 1:
					System.out.println("\nEcco l'elenco dei prodotti" + n.toString());
					continua = Vik.continua(tastiera);
				break;
				case 2:
					System.out.println("\nPrezzo totale dei prodotti: " + n.prezzoMagazzino());
					continua = Vik.continua(tastiera);
				break;
				case 3:
					System.out.println("\nPrezzo medio totale: " + n.prezzoMedio());
					continua = Vik.continua(tastiera);
				break;
				case 4:
					System.out.println("\nPrezzo medio portatili: " + n.prezzoMedioPortatile());
					continua = Vik.continua(tastiera);
				break;
				case 5:
					System.out.println("\nPrezzo medio pc: " + n.prezzoMedioPc());
					continua = Vik.continua(tastiera);
				break;
				case 6:
					System.out.println("\nInserisci il prezzo massimo: ");
					double prezzoMax = Double.parseDouble(tastiera.nextLine());
					System.out.println("\nEcco l'elenco dei prodotti sotto a " + prezzoMax + "€: \n" + n.elenco(prezzoMax));
					continua = Vik.continua(tastiera);
				break;
				case 7:
					System.out.println("\nInserisci la marca: ");
					String marca = tastiera.nextLine();
					System.out.println("\nEcco l'elenco dei prodotti di marca " + marca + ": \n" + n.elenco(marca));
					continua = Vik.continua(tastiera);
				break;
				case 8:
					System.out.println("\nNumero prodotti con ram e hd pari: " + n.contaPari());
					continua = Vik.continua(tastiera);
				break;
				case 9:
					System.out.println("\nNumero prodotti da gaming: " + n.contaGaming());
					continua = Vik.continua(tastiera);
				break;
				case 10:
					System.out.println("\nInserisci il tipo (pc, portatile, tutti) per vedere l'elenco dei prodotti da gaming per tipo: ");
					String tipo = tastiera.nextLine();
					System.out.println("\nEcco dei prodotti da gaming di tipo " + tipo + ": \n" + n.elencoGaming(tipo));
					continua = Vik.continua(tastiera);
				break;
				case 11:
					System.out.println("\nPrezzo totale dei prodotti validi: " + n.totaleMagazzinoValidi());
					continua = Vik.continua(tastiera);
				break;
				case 12:
					System.out.println("\nElenco dei prodotti validi e complessi: \n" + n.elencoValidoComplesso());
					continua = Vik.continua(tastiera);
				break;
				default:
					System.out.println("\nLa tua scelta non è presente");
					continua = Vik.continua(tastiera);
			}
			
		} while(continua);
		System.out.println("\nCiao e alla prossima!");
	}

}
