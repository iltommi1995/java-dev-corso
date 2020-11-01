package entities;

public class Film extends Prodotto {
	
	public double durata;
	
	public Film(String titolo, String tipo, String autore, int anno, double durata) {
		super(titolo, tipo, autore, anno);
		this.durata = durata;
	}
	
	public String prezzo() {
		double prezzoBase = 15;
		int anniFilm = 2020 - anno;
		
		if(anniFilm >= 5) {
			prezzoBase =  (prezzoBase/2);
		}
		if(anniFilm > 1 & anniFilm < 5) {
			prezzoBase = prezzoBase - 2;
		}
		
		return "--- Prezzo: " + prezzoBase + "€";
	}
	
	public String toString() {
		String ris =	super.toString()	+						"\n"	+
						"--- Durata: " 		+		durata		+	"'\n"	+
						prezzo()											;
		
		return ris;
	}

}
