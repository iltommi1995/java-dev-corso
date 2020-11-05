package entities;

import util.Vik;

public class Persona {
	
	private String nome;
	
	public Persona(String nome) {
		setNome(nome);
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		 
			this.nome = nome;

	}
	
	public String toString() {
		return nome;
	}
}
