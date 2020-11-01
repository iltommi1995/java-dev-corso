package entities;

public class Studente extends Persona
{
	public double mediaIta;
	public double mediaMate;
	public double mediaIng;
	public double mediaFra;
	
	public Studente(String nome, int eta, double mediaIta, double mediaMate, double mediaIng, double mediaFra) {
		super(nome, eta);
		this.mediaIta = mediaIta;
		this.mediaMate = mediaMate;
		this.mediaIng = mediaIng;
		this.mediaFra = mediaFra;
	}
	
	public double media() {
		return (mediaIta + mediaMate + mediaIng + mediaFra) / 4;
	}
	
	public double media(int nMaterie) {
		return (mediaIng + mediaFra) / nMaterie;
	}
	
	public String toString() {
		return super.toString() + " " + mediaIta + " " + mediaMate + " " + mediaIng + " " + mediaFra;
	}
}
