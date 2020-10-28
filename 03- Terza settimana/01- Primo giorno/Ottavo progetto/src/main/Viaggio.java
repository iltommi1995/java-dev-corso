package main;

public class Viaggio 
{
	public String destinazione;
	public String periodoMigliore;
	public double prezzoBase;
	
	public String stampaViaggio() {
		String risp = destinazione + "\n---- Periodo migliore: " + periodoMigliore + "\n---- Prezzo base: " + prezzoBase;
		return risp;
	}
}
