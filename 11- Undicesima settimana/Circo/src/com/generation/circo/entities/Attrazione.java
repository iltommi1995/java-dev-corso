package com.generation.circo.entities;

import java.sql.Date;

import com.generation.utility.entities.Entity;

public class Attrazione extends Entity
{
	// Proprietà 
	
	private String nome;
	private int costoBiglietto;
	private int altezzaMinima;
	private Date dataAcquisto;
	private Date scadenzaCollaudo;
	
	// Costruttori
	
	public Attrazione() {}

	public Attrazione(int id, String nome, int costoBiglietto, int altezzaMinima, Date dataAcquisto,
			Date scadenzaCollaudo) {
		super(id);
		this.nome = nome;
		this.costoBiglietto = costoBiglietto;
		this.altezzaMinima = altezzaMinima;
		this.dataAcquisto = dataAcquisto;
		this.scadenzaCollaudo = scadenzaCollaudo;
	}
	
	// Getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCostoBiglietto() {
		return costoBiglietto;
	}

	public void setCostoBiglietto(int costoBiglietto) {
		this.costoBiglietto = costoBiglietto;
	}

	public int getAltezzaMinima() {
		return altezzaMinima;
	}

	public void setAltezzaMinima(int altezzaMinima) {
		this.altezzaMinima = altezzaMinima;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public Date getScadenzaCollaudo() {
		return scadenzaCollaudo;
	}

	public void setScadenzaCollaudo(Date scadenzaCollaudo) {
		this.scadenzaCollaudo = scadenzaCollaudo;
	}
	
	
}
