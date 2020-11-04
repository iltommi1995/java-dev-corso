package entities;

public class Persona 
{
	private String nome;
	
	public Persona(String nome)
	{
		setNome(nome);
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		if(nome.length() > 0) 
			this.nome = nome;
		else
			this.nome = "ERRORE - CAMPO VUOTO";
	}


	public String toString() {
		return nome;
	}
}
