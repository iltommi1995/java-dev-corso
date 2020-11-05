package util;

public abstract class Vik {
	// In questa classe inseriremo tutto quello che può servire per fare
	// controlli preventivi o successivi alla creazione di un oggetto
	
	//La classe VIK, conterrà solo ed esclusivamente proprietà e metodi 
	// STATIC o STATIC FINAL
	
	public static int MINCARATTERI = 2;
	public static int MAXCARATTERI = 120;
	public static final double MINNUMERI = 0;
	
	public static boolean controllaString(String parametro) {
		boolean ris = false;
		if (parametro.length() > MINCARATTERI)
			ris = true;
		return ris;
	}
	
	/**
	 * QUESTO E' UN JAVADOC - UNA SPECIE DI COMMENTO INTERATTIVO
	 * Il metodo controllaNumeri serve per verificare che un valore passato
	 * come parametro sia superiore al valore della proprietà di clsse 
	 * MINNUMERI. 
	 * @param parametro
	 * @return boolean
	 */
	public static boolean controllaNumeri(double parametro) {
		boolean ris = false;
		if(parametro > MINNUMERI)
			ris = true;
		return ris;
	}
	
	//Questo metodo verifica l'appartenenza di una stringa ad un insieme di stringhe
	// serve per validare l'appartenenza di un valore a un insieme di valori
	public static boolean appartieneA(String parametro, String[] vettore) {
		boolean ris = false;
		
		for(int i = 0; i < vettore.length; i++) {
			if(vettore[i].equalsIgnoreCase(parametro))
				ris = true;
		}
		return ris;
	}
}
