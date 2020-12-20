package entities;

public class Portatile extends Pc{
	private double pollici;
	private int batteria;
	
	public Portatile(int id, String marca, String processore, String tipoHd, int hd, int ram, double pollici,
			int batteria) {
		super(id, marca, processore, tipoHd, hd, ram);
		this.pollici = pollici;
		this.batteria = batteria;
	}
	
	public String toString() {
		return 		super.toString()											+
					"Pollici: "				+		pollici			+	"\n"	+
					"Battera: "				+		batteria		+	"\n"	+
					"Prezzo: "				+		prezzo()		+	"\n"	;
	}
	
	public double getPollici() {
		return pollici;
	}
	public void setPollici(double pollici) {
		this.pollici = pollici;
	}
	public int getBatteria() {
		return batteria;
	}
	public void setBatteria(int batteria) {
		this.batteria = batteria;
	}
	
	public double prezzo()
	{
		double prezzo = super.prezzo();
		
		prezzo += (3 * pollici) + (2.5 * batteria);
		
		return prezzo;
	}
	
	
}
