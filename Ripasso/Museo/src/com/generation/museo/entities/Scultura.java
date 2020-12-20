package com.generation.museo.entities;

public class Scultura extends Opera
{
	// Proprietà
	
	private double altezza;
	private double basex;
	private double basey;
	private double peso;
	private String marmo;
	
	// Costruttori
	
	public Scultura() {}

	public Scultura(int id, String nome, String autore, int secolo, double altezza, double basex, double basey, double peso, String marmo) {
		super(id, nome, autore, secolo);
		this.altezza = altezza;
		this.basex = basex;
		this.basey = basey;
		this.peso = peso;
		this.marmo = marmo;
	}
	
	// Getters & setters

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public double getBasex() {
		return basex;
	}

	public void setBasex(double basex) {
		this.basex = basex;
	}

	public double getBasey() {
		return basey;
	}

	public void setBasey(double basey) {
		this.basey = basey;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getMarmo() {
		return marmo;
	}

	public void setMarmo(String marmo) {
		this.marmo = marmo;
	}
}
