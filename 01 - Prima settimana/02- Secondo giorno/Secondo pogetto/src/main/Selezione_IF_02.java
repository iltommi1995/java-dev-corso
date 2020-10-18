package main;
import java.util.Scanner;

public class Selezione_IF_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tastiera = new Scanner(System.in);
		String destinazione;
		double costoBiglietto = 100;
		
		System.out.println("Indica la destinazione che vuoi raggiungere");
		destinazione = tastiera.nextLine();
		
		if(destinazione.equals("londra"))
			costoBiglietto = 120;
		if(destinazione.equals("parigi"))
			costoBiglietto = 110;
		if(destinazione.equalsIgnoreCase("oslo"))
			costoBiglietto = 180;
		
		System.out.println("Biglietto: " + costoBiglietto + "€");
		
		tastiera.close();
		
		
	}

}
