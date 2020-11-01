package entities;

public class Studente extends Persona {
	
	public int classe;
	
	public Studente(String name, int classe) {
		super(name);
		this.classe = classe;
	}
	
	public String toString() {
		return super.toString() + " " + classe;
	}
}
