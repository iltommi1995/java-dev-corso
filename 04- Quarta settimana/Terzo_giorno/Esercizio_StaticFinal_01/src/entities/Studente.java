package entities;

public class Studente extends Persona {
	
	
	private String classe;
	private double mediaIta;
	private double mediaMate;
	
	public Studente(String nome, int eta, String classe, double mediaIta, double mediaMate) {
		super(nome, eta);
		setClasse(classe);
		setMediaIta(mediaIta);
		setMediaMate(mediaMate);
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public double getMediaIta() {
		return mediaIta;
	}

	public void setMediaIta(double mediaIta) {
		this.mediaIta = mediaIta;
	}

	public double getMediaMate() {
		return mediaMate;
	}

	public void setMediaMate(double mediaMate) {
		this.mediaMate = mediaMate;
	}
	
	public String toString() {
		return 		super.toString() 	 											+
					"--- Classe: "				+ 		classe		+		"\n"	+
					"--- Media italiano: "		+		mediaIta	+		"\n"	+
					"--- Media Matematica: "	+		mediaMate	+		"\n"	+
					"--- Media: "				+		media()		+		"\n"	+
					"--- Esito: "				+		esito()		+		"\n"	;
	}

	@Override
	public String esito() {
		String risp = "Promosso";
		int anno = Integer.parseInt(classe.split("")[0]);
		if((anno >= 1 && anno <4) && (mediaIta < 6 && mediaMate < 6))
			risp = "Bocciato";
		
		if((anno >= 4 && anno <=5) && (mediaIta < 6 || mediaMate < 6))
			risp = "Bocciato";
		return risp;
	}

	@Override
	public double media() {
		return (mediaIta + mediaMate) / 2;
	}

}
