package com.myproject.imdb.entities;

import java.sql.Date;

public class SerieTv extends Prodotto
{
	// PROPRIETA'
	
	private Date dataInizio;
	private Date dataFine;
	private int numeroEpisodi;
	private boolean bafta;
	
	// COSTRUTTORE
	
	public SerieTv() {}

	public SerieTv(int id, String titolo, boolean daVedere, boolean visto, Date dataInizio, Date dataFine,
			int numeroEpisodi, boolean bafta) {
		super(id, titolo, daVedere, visto);
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.numeroEpisodi = numeroEpisodi;
		this.bafta = bafta;
	}
	
	// GETTERS & SETTERS

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public int getNumeroEpisodi() {
		return numeroEpisodi;
	}

	public void setNumeroEpisodi(int numeroEpisodi) {
		this.numeroEpisodi = numeroEpisodi;
	}

	public boolean isBafta() {
		return bafta;
	}

	public void setBafta(int bafta) {
		this.bafta = bafta == 0 ? false : true;
	}
}
