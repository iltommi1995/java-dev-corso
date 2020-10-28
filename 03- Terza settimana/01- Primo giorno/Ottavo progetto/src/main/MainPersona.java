package main;

public class MainPersona 
{
	public static void main(String[] args) 
	{
		Persona p;
		
		p = new Persona();
		
		p.nome = "Tizio";
		System.out.println(p.nome);
		
		Persona p1 = new Persona();
		p1.nome = "Marco";
		p1.eta = 20;
		
		System.out.println(p1.nome);
		
	}
}
