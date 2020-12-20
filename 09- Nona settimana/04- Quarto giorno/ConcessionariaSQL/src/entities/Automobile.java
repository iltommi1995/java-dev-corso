package entities;

import java.sql.Date;

public class Automobile 
{
	// Proprietà 
	
	private int id;
	private String nome;
	private int cilindrata;
	private int numerocilindri;
	private String colore;
	private Date date;
	private String cittacliente;
	private int etacliente;
	private int prezzo;
	
	// Costruttore
	
	public Automobile(int id, String nome, int cilindrata, int numerocilindri, String colore, Date date,
			String cittacliente, int etacliente, int prezzo) {
		this.id = id;
		this.nome = nome;
		this.cilindrata = cilindrata;
		this.numerocilindri = numerocilindri;
		this.colore = colore;
		this.date = date;
		this.cittacliente = cittacliente;
		this.etacliente = etacliente;
		this.prezzo = prezzo;
	}
	
	
	
	
	// Getters and setters

	@Override
	public String toString() {
		return "Id : " + id + "\n" +
				"Nome: " + nome + "\n"	+
				"Cilindrata: "	+	cilindrata 	+ "\n"	+
				"Numero cilindri: "	+	numerocilindri	+	"\n"	+
				"Colore: "		+		colore			+	"\n"	+
				"Date: "		+		date			+	"\n"	+	
				"Citta cliente: "+	cittacliente		+	"\n"	+	
				"Eta cliente: "+	etacliente		+	"\n"	+	
				"prezzo: "+	prezzo		+	"\n"	;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public int getNumerocilindri() {
		return numerocilindri;
	}

	public void setNumerocilindri(int numerocilindri) {
		this.numerocilindri = numerocilindri;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCittacliente() {
		return cittacliente;
	}

	public void setCittacliente(String cittacliente) {
		this.cittacliente = cittacliente;
	}

	public int getEtacliente() {
		return etacliente;
	}

	public void setEtacliente(int etacliente) {
		this.etacliente = etacliente;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}	

}
