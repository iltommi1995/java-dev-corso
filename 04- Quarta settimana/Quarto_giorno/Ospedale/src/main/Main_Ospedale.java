package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Terminale;

public class Main_Ospedale {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner tastiera = new Scanner(System.in);
		
		Terminale ter = new Terminale(tastiera);
		
		System.out.println(ter.output());
		
		tastiera.close();
	}

}
