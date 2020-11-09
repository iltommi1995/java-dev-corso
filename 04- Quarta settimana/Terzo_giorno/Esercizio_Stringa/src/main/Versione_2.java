package main;

public class Versione_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "AAABBCCCDE";
		String[] splittato = input.split("");
		String output = "";
		
		for(String l : splittato) {
			if(l.equalsIgnoreCase("a")) {
				if (output.length() == 0) {
					output += l;
				}
			}
			if(l.equalsIgnoreCase("c")) {
				if(output.length() == 1) {
					output += l;
				}
			}
		}
		
		if(output.length() == 2) {
			System.out.println("Prima ----->  " + input);
			System.out.println("Dopo  ----->  " + output);
		}
		else if(output.length() == 1){
			System.out.println("Nella stringa di input non è presente la lettera 'C'.");
		}
		else {
			System.out.println("Nella stringa di input non è presente la 'A'.");
		}
		
	}

}
