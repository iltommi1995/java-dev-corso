package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import interfacce.IConcessionaria;

public class Concessionaria implements IConcessionaria
{ 	
	// Proprietà Concessionaria
	
	private ArrayList<Prodotto> prodotti;
	
	// Costruttore Concessionaria
	
	public Concessionaria(String path) throws FileNotFoundException {
		
		Scanner file = new Scanner(new File(path));
		String[] riga;
		Automobile a;
		Moto m;
		prodotti = new ArrayList<Prodotto>();
		
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			switch(riga[0].toLowerCase()) {
				// Caso automobile
				case "automobile":
					a = new Automobile(Integer.parseInt(riga[1]), riga[0], riga[2], riga[3], riga[4], 
							Integer.parseInt(riga[5]), Double.parseDouble(riga[6]), Double.parseDouble(riga[7]),
							Double.parseDouble(riga[8]));
					prodotti.add(a);
				break;
				// Caso moto
				case "moto":
					m = new Moto(Integer.parseInt(riga[1]), riga[0], riga[2], riga[3], riga[4], 
							Double.parseDouble(riga[5]), Double.parseDouble(riga[6]),
							riga[7].equalsIgnoreCase("si") ? true : false);
					prodotti.add(m);
				break;
				default:
			}
		}
		file.close();
	}
	
	// Metodi Concessionaria
	
	@Override
	public ArrayList<Prodotto> listaCompleta() {
		return prodotti;
	}

	@Override
	public ArrayList<Prodotto> listaMoto() {
		ArrayList<Prodotto> elencoMoto = new ArrayList<Prodotto>();
		
		for(Prodotto moto : prodotti) {
			if(moto instanceof Moto) 
				elencoMoto.add(moto);
		}
		return elencoMoto;
	}

	@Override
	public ArrayList<Prodotto> listaVecchie() {
		ArrayList<Prodotto> elencoVecchi = new ArrayList<Prodotto>();
		
		for(Prodotto p : prodotti) {
				switch(p.getCategoria().toLowerCase()) {
					case "automobile":
						Automobile a = (Automobile) p;
						if(a.eta() >= 8)
							elencoVecchi.add(a);
					break;
					case "moto":
						Moto m = (Moto) p;
						if(m.eta() >= 8)
							elencoVecchi.add(m);
					break;
					default:
				}
		}
		return elencoVecchi;
	}

	@Override
	public String maxDistanza() {
		// String maxDistanza() -> Ritorna le schede dei mezzi che possono fare più km(Sia per le macchine che per le moto)
		String ris = "";
		String ris2 = "";
		double km = 0;
		for(Prodotto p : prodotti) {
			if(p instanceof Automobile) {
				Automobile a = (Automobile) p;
				if(km < a.kmPercorribili()) {
					km = a.kmPercorribili();
					ris = a.toString();
				}
				else if(km == a.kmPercorribili()) {
					km = a.kmPercorribili();
					ris += a.toString();
				}
			}
			if(p instanceof Moto) {
				Moto m = (Moto) p;
				if(km < m.kmPercorribili()) {
					km = m.kmPercorribili();
					ris2 = m.toString();
				}
				else if(km == m.kmPercorribili()) {
					km = m.kmPercorribili();
					ris2 += m.toString();
				}
			}
		}
		return "L'auto con più km percorribili è:\n" + ris + "\nLa moto con più km percorribili è:\n" + ris2;
	}

	@Override
	public ArrayList<Prodotto> autoSuper() {
		ArrayList<Prodotto> elenco = new ArrayList<Prodotto>();

        for(Prodotto m : prodotti)
        {
            switch(m.getCategoria().toLowerCase())
            {
            case "automobile" :
                Automobile a = (Automobile) m;
                if(a.potente() == true)
                    elenco.add(a);
                break;
            }
        }
        return elenco;
	}

	@Override
	public ArrayList<Prodotto> cercaCategoria(String categoria) {
		   //AL<Prodotto> cerca(String categoria) -> Ritorna tutti i mezzi che appartengono alla categoria cercata
        ArrayList<Prodotto> cerca = new ArrayList<Prodotto>();
        //è un metodo condionato e parametizzato
        for(Prodotto p : prodotti) {
            if(p.getCategoria().equalsIgnoreCase(categoria))
            cerca.add(p);
        }//end each for
        return cerca;
	}

	@Override
	public Map<String, Integer> frequenza() {
		// Map<String,Integer> frequenza() -> Ritorna la lista ti frequrnza per categoria(es: Moto = 2, Automobile = 4)
		
		Map<String, Integer>frequenza = new LinkedHashMap<String,Integer>();
		int counterA = 0;
		int counterM = 0;
		for(Prodotto p : prodotti)
        {
           if(p instanceof Automobile) {
        	   counterA++;
           }
           if(p instanceof Moto) {
        	   counterM++;
           }
        }
		
		frequenza.put("Automobile", counterA);
		frequenza.put("Moto", counterM);
		
		return frequenza;
	}

	@Override
	public String cercaMarca(String marca) {
		String ris = "";
        for(Prodotto p : prodotti)
        {
            if(p.getMarca().equalsIgnoreCase(marca))
                ris += p.toString() + "\n-------------\n";
        }
        return ris;
	}

	@Override
	public ArrayList<Prodotto> ordinati() {
		// CHIEDERE
		ArrayList<Prodotto> copiaProdotti = new ArrayList<Prodotto>(prodotti);
		
		ArrayList<Prodotto> elencoOrdinati = new ArrayList<Prodotto>();
		
		double prezzo = Double.MAX_VALUE;
		Prodotto pr = null;
		for(int i = 0; i < prodotti.size(); i++) {
			System.out.println(i);
			prezzo = Double.MAX_VALUE;
			pr = null;
			
			for(Prodotto p : copiaProdotti) {
			
				if(p.prezzo() < prezzo) {
					pr = p;
					prezzo = p.prezzo();
				}
			}
			copiaProdotti.remove(pr);
			elencoOrdinati.add(pr);
		}
		
		return elencoOrdinati;
	}
}
