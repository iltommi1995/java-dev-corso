package entities;

public class Persona 
{
	public String nome;
	public int eta;
	
	public Persona(String nome, int eta)
	{
		this.nome = nome;
		this.eta = eta;
	}
	
	public String toString() {
		return nome + " " + eta;
	}
}
