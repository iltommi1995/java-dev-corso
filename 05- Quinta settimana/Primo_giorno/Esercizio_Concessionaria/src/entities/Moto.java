package entities;

public class Moto extends Prodotto {
	
	// Proprietà Moto
	
	private String annoImmatricolazione;
	private double consumoMedioAKm;
	private double litriCarburante;
	private boolean passeggeri;

	// Costruttore Moto
	
	public Moto(int id, String categoria, String marca, String modello,
				String annoImmatricolazione, double consumoMedioAKm, 
				double litriCarburante, boolean passeggeri) 
	{
		super(id, categoria, marca, modello);
		setAnnoImmatricolazione(annoImmatricolazione);
		setConsumoMedioAKm(consumoMedioAKm);
		setLitriCarburante(litriCarburante);
		setPasseggeri(passeggeri);
	}
	
	// Getters and setters Moto

	public String getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(String annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public double getConsumoMedioAKm() {
		return consumoMedioAKm;
	}

	public void setConsumoMedioAKm(double consumoMedioAKm) {
		this.consumoMedioAKm = consumoMedioAKm;
	}

	public double getLitriCarburante() {
		return litriCarburante;
	}

	public void setLitriCarburante(double litriCarburante) {
		this.litriCarburante = litriCarburante;
	}

	public boolean isPasseggeri() {
		return passeggeri;
	}

	public void setPasseggeri(boolean passeggeri) {
		this.passeggeri = passeggeri;
	}

	

	// Metodi Moto
	
	@Override
	public double prezzo() {
		double prezzo = 20000;
		prezzo += eta() >= 5 ? -500 : 0;
		prezzo += eta() >= 10 ? -1000 : 0;
		prezzo += eta() >= 15 ? -2000 : 0;
		
		return prezzo;
	}
	
	public int eta() {
		return 2020 - Integer.parseInt(annoImmatricolazione);
	}
	
	public double kmPercorribili() {
		return litriCarburante / consumoMedioAKm;
	}
	
	public boolean inCompagnia() {
		return ( passeggeri && kmPercorribili() > 100 ) ? true : false ;
	}
	
	// ToString Moto
	
	
	public String toString() {
		return 	super.toString()																	+
				"--- Anno di immatricolazione: "	+	annoImmatricolazione			+	"\n"	+
				"--- Consumo medio al km: "			+	consumoMedioAKm					+	"\n"	+
				"--- Litri carburante: "			+	litriCarburante					+	"\n"	+
				"--- Passeggeri: "					+	(passeggeri ? "si" : "no")		+	"\n"	+
				"--- Età: "							+	eta()							+	"\n"	+
				"--- Km percorribili: "				+	kmPercorribili()				+	"\n"	+
				"--- Prezzo: "						+	prezzo()						+	"\n"	+
				"--- In compagnia: "				+   (inCompagnia() ? "si" : "no")	+	"\n"	;
	}
}
