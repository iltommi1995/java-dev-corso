package main;

public class Main {

	public static void main(String[] args) {
		// AAABBCCCDE -> AC
		
		String input = "AAABBCCCDE";
		String[] splittato = input.split("");
		String output = splittato[0] + splittato[6];
		System.out.println("Prima ----->  " + input);
		System.out.println("Dopo  ----->  " + output);
	}

}
