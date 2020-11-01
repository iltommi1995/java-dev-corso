package entities;

public class Prodotto {

	public String titolo;
	public String tipo;
	public String autore;
	public int anno;
	
	public Prodotto(String titolo, String tipo, String autore, int anno) {

		this.titolo = titolo;
		this.tipo = tipo;
		this.autore = autore;
		this.anno = anno;
	}
	
	public String toString() {
		String ris = 	titolo			+	":\n"		+
						"--- Autore: "	+	autore		+ "\n" 	+
						"--- Genere: "	+	tipo		+	"\n" +
						"--- Anno: "	+	anno		;
		return ris;
	}
}
