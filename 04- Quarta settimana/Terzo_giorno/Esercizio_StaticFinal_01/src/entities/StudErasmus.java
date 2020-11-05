package entities;

public class StudErasmus extends Studente {
	private double mediaIng;
	private double mediaFra;
	
	public StudErasmus(String nome, int eta, String classe, double mediaIta, double mediaMate, double mediaIng, double mediaFra) {
		super(nome, eta, classe, mediaIta, mediaMate);
		setMediaIng(mediaIng);
		setMediaFra(mediaFra);
	}

	public double getMediaIng() {
		return mediaIng;
	}

	public void setMediaIng(double mediaIng) {
		this.mediaIng = mediaIng;
	}

	public double getMediaFra() {
		return mediaFra;
	}

	public void setMediaFra(double mediaFra) {
		this.mediaFra = mediaFra;
	}
	
	
	public String toString() {
		return 		super.getNome() 										+ 		"\n" 	+ 
					"--- Età: " 				+ 	super.getEta() 			+ 		"\n"	+
					"--- Classe: "				+ 	super.getClasse()		+		"\n"	+
					"--- Media italiano: "		+	super.getMediaIta()		+		"\n"	+
					"--- Media Matematica: "	+	super.getMediaMate()	+		"\n"	+
					"--- Media inglese: "		+	mediaIng				+		"\n"	+
					"--- Media Francese: "		+	mediaFra				+		"\n"	+
					"--- Media: "				+	media()					+		"\n"	+
					"--- Esito: "				+	esito()					+		"\n"	;			
	}
	
	@Override
	public String esito() {
		String risp = "Promosso";
		int insuf = 0;
		int anno = Integer.parseInt(super.getClasse().split("")[0]);
		insuf += mediaFra < 6 ? 1 : 0;
		insuf += mediaIng < 6 ? 1 : 0;
		insuf += super.getMediaIta() < 6 ? 1 : 0;
		insuf += super.getMediaMate() < 6 ? 1 : 0;
		
		if((anno >= 1 && anno <4) && (insuf >= 2))
			risp = "Bocciato";
		
		if((anno >= 1 && anno <4) && (insuf >= 1))
			risp = "Bocciato";
		return risp;
	}

	@Override
	public double media() {
		return (mediaFra + mediaIng + super.getMediaIta() + super.getMediaMate()) / 4;
	}
}
