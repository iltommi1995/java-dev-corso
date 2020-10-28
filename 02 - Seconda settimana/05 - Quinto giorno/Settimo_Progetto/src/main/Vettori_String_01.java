package main;

public class Vettori_String_01 {

	public static void main(String[] args) 
	{
		String[] parola = {"c", "i", "a", "o"};
		
		String parolaa = "ciao";
		
		String[] prova = parolaa.split("");
		
		for(int i = 0; i < parola.length; i++) {
			System.out.println(prova[i]);
		}
		
		
		
		String stampa = "";
		
		String stampaContrario = "";
		
		for(int i = 0; i < parola.length; i++) {
			stampa += parola[i];
		}
		
		System.out.println(stampa);
		
		for(int i = (parola.length -1); i >= 0; i--) {
			stampaContrario += parola[i];
		}
		
		System.out.println(stampaContrario);
		
		
		
	}
}
