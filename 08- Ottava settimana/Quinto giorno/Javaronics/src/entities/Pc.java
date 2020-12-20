package entities;

public class Pc extends Prodotto
{
	
	private String marca;
	private String processore;
	private String tipoHd;
	private int hd;
	private int ram;
	
	public Pc(int id, String marca, String processore, String tipoHd, int hd, int ram) {
		super(id);
		this.marca = marca;
		this.processore = processore;
		this.tipoHd = tipoHd;
		this.hd = hd;
		this.ram = ram;
	}
	
	public String toString() {
		return 		super.toString()									+
					"Marca: "				+	marca		+		"\n"	+
					"Processore: "			+	processore	+		"\n"	+
					"Tipo HD: "				+	tipoHd		+		"\n"	+
					"HD: "					+	hd			+		"\n"								+
					"Ram: "					+	ram			+		"\n"								+
					"Prezzo: "				+	prezzo()	+		"\n"								+
					"Da gaming: "			+	(gaming() == true ? "si" : "no")	+		"\n"		+
					"Valido: "				+	(valido() == true ? "si" : "no")	+		"\n"		+
					"Valido e complesso: " + (validoComplesso() == true ? "si" : "no")	+		"\n"	;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProcessore() {
		return processore;
	}

	public void setProcessore(String processore) {
		this.processore = processore;
	}

	public String getTipoHd() {
		return tipoHd;
	}

	public void setTipoHd(String tipoHd) {
		this.tipoHd = tipoHd;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double prezzo()
	{
		double prezzo = 200;
		
		switch(marca.toLowerCase())
		{
			case "asus" :
				prezzo += 140;
			break;
			
			case "acer" :
				case "hp":
				prezzo += 180;
			break;
			
			case "apple" :
				prezzo += 300;
			break;
		}
		
		switch(processore.toLowerCase())
		{
			case "i3" :
				prezzo += 120;
			break;
			
			case "i5" :
				prezzo += 180;
			break;
			
			default:
				prezzo += 270;
			break;
		}
		
//		prexxo base + (0.2 * hd) se tipoHd = hdd, se ssd (0.45*hd)
		switch(tipoHd.toLowerCase())
		{
			case "hdd" :
				prezzo += (0.2 * hd);
			break;
			
			case "ssd" :
				prezzo += (0.45 * hd);
			break;
		}
		
//		prezzo base + 5 * ram
		//		prezzo base *= 0.15 se proc = i7, ram > 8 e tipohd ssd
		prezzo += 5 * ram;
		
		if(processore.equalsIgnoreCase("i7") && ram > 8 && tipoHd.equalsIgnoreCase("ssd"))
			prezzo *= 0.15;
		
		return prezzo;
	}
	
	
	// pc da caming
	
	public boolean gaming() {
		return ((ram >= 16) && (tipoHd.equalsIgnoreCase("ssd") 
				&& (processore.equalsIgnoreCase("i5") || processore.equalsIgnoreCase("i7"))) 
				? true : false) ;
	}
	
	// computer valido
	
	public boolean valido() {
		return (
				(	(processore.equalsIgnoreCase("i3") || processore.equalsIgnoreCase("i5") || processore.equalsIgnoreCase("i5")) &&
						(ram > 0 && hd > 0) &&
						(tipoHd.equalsIgnoreCase("hdd") || tipoHd.equalsIgnoreCase("ssd"))
				) ? true : false
		);
	}
	
	
	// Valido e complesso?
	
	public boolean validoComplesso() {
		double num = hd;
		do {
			num = num/2;
		} while(num != 2 && num > 2);
		
		return ((valido()) && (ram % 2 == 0) && (num == 2) ? true : false);
	}
}
