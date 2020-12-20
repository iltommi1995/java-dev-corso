package entities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Negozio {
	private List<Prodotto> prodotti;
	
	public Negozio(String percorso) 
	{
		Scanner file = null;
		
		try {
			file = new Scanner(new File(percorso));
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		prodotti = new ArrayList<Prodotto>();
		while(file.hasNextLine()) {
			
			String [] riga = file.nextLine().split(",");
			switch(riga[0].toLowerCase()) {
				case "pc":
					prodotti.add(
								new Pc(	Integer.parseInt(riga[1]), 
										riga[2], 
										riga[3], 
										riga[4], 
										Integer.parseInt(riga[5]), 
										Integer.parseInt(riga[6])
										)
								);
		
				break;
				case "portatile":
					prodotti.add(
								new Portatile(Integer.parseInt(riga[1]), 
										riga[2], 
										riga[3], 
										riga[4], 
										Integer.parseInt(riga[5]), 
										Integer.parseInt(riga[6]),
										Double.parseDouble(riga[7]),
										Integer.parseInt(riga[8])
										)
								);
					break;
				default:
					System.out.println("TIPO NON RICONOSCIUTO");	
			}
		}
	}
	
	public String toString() {
		String ris = "";
		for(Prodotto p : prodotti)
			ris += p.toString() + "\n\n";
		
		return ris;
	}
	
	/*
	 Creare all'interno di Negozio il metodo double prezzoMagazzino()
	 che ritorna il prezzo totale dei vari prodotti. 
	 Il prezzo di un Pc si calcola in questo modo:
	 di base si parte da 200€ a cui aggiungiamo 140 se la marca è asus, 
	 180 se la marca è hp o acer, 300 se la marca è apple. 
	 
	 Poi aggiungiamo
	 120 se il processore è "i3", 180 se è "i5", 270 in tutti gli altri casi.
	 
	 
	 
	 Aggiungere 0.2 * hd se il tipoHd è "hdd", se invece il tipoHd è "ssd"
	 aggiungere 0.45 * hd.
	 
	 
	 Aggiungere 5 * ram.
	 Infine aggiungere il 15% se il processore è "i7", la ram è > 8 e
	 il tipoHd è "ssd".
	 
	 Il calcolo del prezzo di un portatile è uguale ma aggiungiamo anche
	 pollici * 3 e aggiungiamo 2.5 * batteria.
	 */
	
	public double prezzoMagazzino() {

		double prezzoTot = 0;
		
		for(Prodotto p : prodotti) {
			double prezzoBase = 200;
			Pc pc = (Pc) p;
			
			// di base si parte da 200€ a cui aggiungiamo 140 se la marca è asus, 
			// 180 se la marca è hp o acer, 300 se la marca è apple. 
			
			switch(pc.getMarca().toLowerCase()) {
				case "asus":
					prezzoBase += 140;
				break;
				case "hp":
				case "acer":
					prezzoBase += 180;
				break;
				case "apple":
					prezzoBase += 300;
				break;
			}
			
			// 120 se il processore è "i3", 180 se è "i5", 270 in tutti gli altri casi.
			
			switch(pc.getProcessore().toLowerCase()) {
				case "i3":
					prezzoBase += 120;
				break;
				case "i5":
					prezzoBase += 180;
				break;
				default:
					prezzoBase += 270;
			}
			
			//Aggiungere 0.2 * hd se il tipoHd è "hdd", se invece il tipoHd è "ssd"
			// aggiungere 0.45 * hd.
			
			switch(pc.getTipoHd().toLowerCase()) {
			case "hdd":
				prezzoBase += (0.2 * pc.getHd());
			break;
			case "ssd":
				prezzoBase += (0.45 * pc.getHd());
			break;
			}
			
			//Aggiungere 5 * ram.
			
			prezzoBase += (pc.getRam() * 5);
			
			//Infine aggiungere il 15% se il processore è "i7", la ram è > 8 e
			//il tipoHd è "ssd".
			
			if(		(pc.getProcessore().equalsIgnoreCase("i7")) && 
					(pc.getRam() > 8) 							&& 
					pc.getTipoHd().equalsIgnoreCase("ssd")		 ) {
				prezzoBase += ((prezzoBase/100) * 15);
			}
			
			// Il calcolo del prezzo di un portatile è uguale ma aggiungiamo anche
			//pollici * 3 e aggiungiamo 2.5 * batteria.
			
			if(pc instanceof Portatile) {
				Portatile port = (Portatile) pc;
				
				prezzoBase += port.getPollici() * 3;
				prezzoBase += port.getBatteria() * 2.5;
			}
			
			prezzoTot += prezzoBase;
		}
		
		return prezzoTot;
		
	}
	
	// Pprezzo medio
	
	public double prezzoMedio() {
		double prezzoMedio = 0;
		
		for(Prodotto p : prodotti) {
			prezzoMedio += p.prezzo();
		}
		
		return (prezzoMedio/prodotti.size());
	}
	
	// Prezzo medio portatile
	
	public double prezzoMedioPortatile() {
		double prezzoMedio = 0;
		int count = 0;
		
		for(Prodotto p : prodotti) {
			if(p instanceof Portatile) {
				prezzoMedio += p.prezzo(); 
				count++;
			}
		}
		return (prezzoMedio/count);
	}
	
	
	// Prezzo medio pc
	
		public double prezzoMedioPc() {
			double prezzoMedio = 0;
			int count = 0;
			
			for(Prodotto p : prodotti) {
				if(!(p instanceof Portatile)) {
					prezzoMedio += p.prezzo(); 
					count++;
				}
			}
			return (prezzoMedio/count);
		}
		
		
	// elenco prodotti con prezzo < parametro
		
		public String elenco(double prezzoMax)  {
			String ris = "";
			
			for(Prodotto p : prodotti) {
				if(p.prezzo() < prezzoMax) {
					ris+= p.toString() + "\n";
				}
			}
			return ris;
		}
		
	// Elenco prodotti per marca
		
		public String elenco(String marca) {
			String ris = "";
			
			for(Prodotto p : prodotti) {
				Pc pc = (Pc) p;
				if(pc.getMarca().equalsIgnoreCase(marca))
					ris += p.toString() + "\n";
			}
			return ris;
		}
		
		
		// Numero Prodotti che hanno ram e hd pari 
		
		public int contaPari() {
			int count = 0;
			
			for(Prodotto p : prodotti) {
				Pc pc = (Pc) p;
				if((pc.getRam()%2 == 0) && (pc.getHd()%2 == 0)) 
					count++;
			}
			return count;
		}
		
		// Numero di prodotti da gaming
		
		public int contaGaming() {
			int count = 0;
			
			for(Prodotto p : prodotti) {
				Pc pc = (Pc) p;
				if(pc.gaming())
					count++;
			}
			
			return count;
		}
		
		// elenco prodotti da gaming per tipo
		
		public String elencoGaming(String tipo) {
			String ris = "";

			switch(tipo) {
				case "pc":
					for(Prodotto p : prodotti) {
						Pc pc = (Pc) p;
						if((!(p instanceof Portatile)) && pc.gaming())
							ris += pc.toString() + "\n";
					}
				break;
				case "portatile":
					for(Prodotto p : prodotti) {
						Pc pc = (Pc) p;
						if(((p instanceof Portatile)) && pc.gaming())
							ris += pc.toString() + "\n";
					}
				break;
				case "tutti":
					for(Prodotto p : prodotti) {
						Pc pc = (Pc) p;
						if(pc.gaming())
							ris += pc.toString() + "\n";
					}
				break;
				default:
					System.out.println("Non hai inserito un valore valido");
			}	
			return ris;
		}
		
		
		// Prezzo totale dei prodotti validi
		
		public double totaleMagazzinoValidi() {
			double totale = 0;
			
			for(Prodotto p : prodotti) {
				Pc pc = (Pc) p;
				
				if(pc.valido())
					totale += pc.prezzo();
			}
			
			return totale;
		}
		
		
		// toString prodotti validocomplesso 
		
		public String elencoValidoComplesso() {
			
			String ris = "";
			
			for(Prodotto p : prodotti) {
				Pc pc = (Pc) p;
				
				if(pc.validoComplesso())
					ris += pc.toString() + "\n";
			}
			
			return ris;
		}
}
