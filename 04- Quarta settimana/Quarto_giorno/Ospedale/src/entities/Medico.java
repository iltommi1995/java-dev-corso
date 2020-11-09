package entities;

public class Medico extends Persona {
	
	// Proprietà di Medico
	
	private String reparto;
	private int nInterventi;
	private int nInterventiOk;
	
	public Medico(String nome, String cognome, String dob, String reparto, int nInterventi, int nInterventiOk) {
		super(nome, cognome, dob);
		setReparto(reparto);
		setnInterventi(nInterventi);
		setnInterventiOk(nInterventiOk);
	}
	
	
	// Getters and setters di Medico

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public int getnInterventi() {
		return nInterventi;
	}

	public void setnInterventi(int nInterventi) {
		this.nInterventi = nInterventi;
	}

	public int getnInterventiOk() {
		return nInterventiOk;
	}

	public void setnInterventiOk(int nInterventiOk) {
		this.nInterventiOk = nInterventiOk;
	}

	
	// Metodi di Medico
	
	public String toString() {
		return		super.toString()																		+
					"--- Reparto: "					+		reparto								+	"\n"	+
					"--- Numero di interventi: "	+	nInterventi 							+	"\n"	+
					"--- Numero interventi ok: "	+	nInterventiOk							+	"\n"	+
					"--- Buon medico: " 			+ 	(buonMedico() == true ? "si" : "no") 	+ 	"\n"	+
					"--- Serial killer: "			+	(serialKiller() == true ? "si" : "no") 	+	"\n"	+
					"--- Stipendio: "				+	stipendio()								+	"\n"	;
	}
	
	public boolean buonMedico() {
		if((nInterventiOk >= ((nInterventi / 4) * 3)) || reparto.equalsIgnoreCase("pediatria"))
			return true;
		else 
			return false;
	}
	
	public boolean serialKiller() {
		if(((nInterventi - nInterventiOk) >= (3 * nInterventiOk)) && !reparto.equalsIgnoreCase("pediatria"))
			return true;
		else 
			return false;
	}
	
	public double stipendio() {
		double stipendio = 0;
		if(reparto.equalsIgnoreCase("pediatria") || reparto.equalsIgnoreCase("fisiatria"))
			stipendio = 1600;
		else if(reparto.equalsIgnoreCase("neurologia") || reparto.equalsIgnoreCase("chirurgia"))
			stipendio = 2200;
		else
			stipendio = 1800;
		
		stipendio += 0.2 * (nInterventiOk);
		stipendio += - 0.5 * (nInterventi - nInterventiOk);
		
		return stipendio;
	}
}
