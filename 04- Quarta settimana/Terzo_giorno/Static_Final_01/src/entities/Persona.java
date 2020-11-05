package entities;

public class Persona {
	public String nome;
	
	public static int ETAMINIMA = 0;
	public static int LUNGHEZZAMINIMANOME = 2;
	
	
	public static final int LUNGHEZZAMASSIMANOME = 120;
	
	public Persona(String nome) {
		setNome(nome);
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(		nome.length() > LUNGHEZZAMINIMANOME 	&& 
				nome.length() <= LUNGHEZZAMASSIMANOME		)
			this.nome = nome;
		else
			this.nome = "Errore";
	}
	
	public String toString() {
		return nome;
	}
}
