package main;

import java.util.Scanner;

import entities.Terminal;

public class MainBlockBuster {

	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		
		Terminal t = new Terminal();
		System.out.println(t.program(tastiera));
		tastiera.close();
	}
}
