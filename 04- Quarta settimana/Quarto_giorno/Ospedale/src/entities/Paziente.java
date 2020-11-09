package entities;

public class Paziente extends Persona
{
	
	// Proprietà di Paziente
	
	private String patologia;
	private boolean ricovero;
	
	
	// Costruttore di Paziente
	
	public Paziente(String nome, String cognome, String dob, String patologia, boolean ricovero) {
		super(nome, cognome, dob);
		setPatologia(patologia);
		setRicovero(ricovero);
	}

	
	// Getters and setters di Paziente
	
	public String getPatologia() {
		return patologia;
	}


	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}


	public boolean isRicovero() {
		return ricovero;
	}


	public void setRicovero(boolean ricovero) {
		this.ricovero = ricovero;
	}

	
	// Metodi di Paziente
	
	public String toString() {
		
		return			super.toString()																	+
						"--- Patologia: "		+		patologia		+	"\n"				+
						"--- Ricovero: "		+		(ricovero == true ? "si" : "no")		+	"\n"	+
						"--- Infettivo: "		+		(infettivo() == true ? "si" : "no")		+	"\n"	;
	}
	
	public boolean infettivo() {
		if(	patologia.equalsIgnoreCase("peste bubbonica")			||
			patologia.equalsIgnoreCase("ebola")						||
			patologia.equalsIgnoreCase("zombie")					||
			patologia.equalsIgnoreCase("raffreddore radioattivo")	)
			return true;
		else
			return false;
	}
}
