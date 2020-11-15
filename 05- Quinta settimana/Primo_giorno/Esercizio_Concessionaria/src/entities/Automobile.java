package entities;

public class Automobile extends Prodotto
{
	
	// Proprietà Prodotto
	
	private String annoImmatricolazione;
	private int cilindrata;
	private double velocitaMax;
	private double consumoMedioAKm; 
	private double litriCarburante;
	
	// Costruttore Prodotto
	
	public Automobile(int id, String categoria, String marca, 
			String modello, String annoImmatricolazione, int cilindrata, 
			double velocitaMax, double consumoMedioAKm, double litriCarburante) 
	{
		super(id, categoria, marca, modello);
		setAnnoImmatricolazione(annoImmatricolazione);
		setCilindrata(cilindrata);
		setVelocitaMax(velocitaMax);
		setConsumoMedioAKm(consumoMedioAKm);
		setLitriCarburante(litriCarburante);
	}
	
	
	// Getters e setters Prodotto
	
	public String getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}
	public void setAnnoImmatricolazione(String annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	public double getVelocitaMax() {
		return velocitaMax;
	}
	public void setVelocitaMax(double velocitaMax) {
		this.velocitaMax = velocitaMax;
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

	
	// Metodi Automobile
	
	public boolean potente() {
		return (cilindrata > 2000 && super.famoso()) ? true : false;
	}
	
	public int eta() {
		return 2020 - Integer.parseInt(annoImmatricolazione);
	}
	
	double kmPercorribili() {
		return litriCarburante / consumoMedioAKm;
	}
	
	
	@Override
	public double prezzo() {
		double prezzo = 20000;
		prezzo += eta() >= 5 ? -500 : 0;
		prezzo += eta() >= 10 ? -1000 : 0;
		prezzo += eta() >= 15 ? -2000 : 0;
		
		return prezzo;
	}
	
	// ToString Automobile
	
	public String toString() {
		return 	super.toString()																+
				"--- Anno di immatricolazione: "	+	annoImmatricolazione		+	"\n"	+
				"--- Cilindrata: "					+	cilindrata					+	"\n"	+
				"--- Velocità massima: "			+	velocitaMax					+	"\n"	+
				"--- Consumo medio al km: "			+	consumoMedioAKm				+	"\n"	+
				"--- Litri carburante: "			+	litriCarburante				+	"\n"	+
				"--- Auto potente: "				+	(potente() ? "si" : "no")	+	"\n"	+
				"--- Età: "							+	eta()						+	"\n"	+
				"--- Prezzo: "						+	prezzo()					+	"\n"	+
				"--- Km percorribili: "				+	kmPercorribili()			+	"\n"	;
	}
}
