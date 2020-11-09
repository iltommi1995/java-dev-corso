package main;

import java.util.Scanner;

public class Es_2 {

	public static void main(String[] args) {
		// Scrivere un programma che chiede all'utente un numero
		// se riceve una String o il numero non è compreso tra 10 e 20
		// fare in modo che il programma ripeta nuovamente la domanda
		
		Scanner tastiera = new Scanner(System.in);
		
		
		
		int num = 0;
		boolean c = false;
		do {
			System.out.println("Inserisci un numero tra 10 e 20");
			try {
				num = Integer.parseInt(tastiera.nextLine());
				if(num > 10 && num < 20) {
					System.out.println(num);
					c = true;
				}
			} catch(java.lang.NumberFormatException e) {
				c = false;
				System.out.println("Devi inserie un valore numerico");
			}
			
		}while(c == false);
		
		tastiera.close();
		
	}

}
