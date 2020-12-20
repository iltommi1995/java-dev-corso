package utility;

import java.util.Scanner;

public class Vik {
	
	public static boolean continua(Scanner tastiera) {
		System.out.println("\nVuoi effettuare altre operazioni? Si o no");
		return tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
	}
}
