package entities;

public class Libro extends Prodotto {
	public int nPagine;
	public boolean singolo;
	
	public Libro(String titolo, String tipo, String autore, int anno, int nPag, boolean singolo) {
		super(titolo, tipo, autore, anno);
		this.nPagine = nPag;
		this.singolo = singolo;
	}
	
	public String prezzo() {
		double prezzoBase = 16;
		String ris = "--- Prezzo: ";
		
		if(tipo.equalsIgnoreCase("fantascienza") & singolo == true) {
			prezzoBase += -1;
		}
		if((2020 - anno) > 1) {
			prezzoBase += -2;
		}
		ris += prezzoBase + "€";
		return ris;
	}
	
	public String toString() {
		String serie = singolo == true ? "No" : "Sì";
		String ris =	super.toString()	+						"\n"	+
						"--- Pag: " 		+		nPagine		+	"'\n"	+
						"--- Serie: " 		+		serie		+	"'\n"	+
						prezzo()											;
		
		return ris;
	}
}
