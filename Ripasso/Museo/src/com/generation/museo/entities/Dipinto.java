package com.generation.museo.entities;

public class Dipinto extends Opera 
{
	// Proprietà
	
	private double altezza;
	private double base;
	
	// Costruttori
	
	public Dipinto() {}

	public Dipinto(int id, String nome, String autore, int secolo, double altezza, double base) {
		super(id, nome, autore, secolo);
		this.altezza = altezza;
		this.base = base;
	}
	
	// Getters & setters

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
}
