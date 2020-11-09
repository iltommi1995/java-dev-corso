package entities;

public abstract class Persona {
	
	// Proprietà di Persona
	
	private String nome;
	private String cognome;
	private String dob;
	
	//	Costruttore di Persona
	
	public Persona(String nome, String cognome, String dob) {
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
	}
	
	// Getters and Setters di Persona

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	// Metodi di Presona
	
	public String toString() {
		return			nome			+	" "		+	cognome		+		"\n"		+
						"--- Data di nascita: "		+ 	dob			+		"\n"		+
						"--- Eta: "					+	eta()		+		"\n"		;
	}	
	
	public int eta() {
		return 2020 - Integer.parseInt(dob.split("-")[2]);
	}
	

}
