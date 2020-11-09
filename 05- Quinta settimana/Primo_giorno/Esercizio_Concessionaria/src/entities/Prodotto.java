package entities;

public abstract class Prodotto extends Entity
{
	// Proprietà di Prodotto
	
	private String categoria;
	private String marca;
	private String modello;
	
	// Costruttore di Prodotto
	
	public Prodotto(int id, String categoria, String marca, String modello) {
		super(id);
		setCategoria(categoria);
		setMarca(marca);
		setModello(modello);
	}
	
	// Getters and setters di Prodotto
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	} 
	
	// ToString Prodotto
	
	public String toString() {
		return 	super.toString()								+
				"--- Categoria: "	+	categoria	+	"\n"	+
				"--- Marca: "		+	marca		+	"\n"	+
				"--- Modello: "		+	modello		+	"\n"	;
	}
	
	
	// Metodi di Prodotto
	
	public abstract double prezzo();
	
	public boolean famoso() {
		boolean famoso;
		switch(marca.toLowerCase()) {
			case "ducati":
			case "ferrari":
			case "fiat":
			case "yamaha":
				famoso = true;
			break;
			default:
				famoso = false;
		}
		return famoso;
	}
}
