package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import util.Util;

public class Ospedale 
{	
	// Proprietà di Ospedale
	
	ArrayList<Persona> elencoPersone;
	
	
	// Costruttore di Ospedale
	
	public Ospedale(String path) throws FileNotFoundException {
		
		Scanner file = new Scanner(new File(path));
		String [] riga;
		Medico m;
		Paziente p;
		elencoPersone = new ArrayList<Persona>();
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			switch(riga[0].toLowerCase()) {
			
				case "paziente":
					if(Util.controllaPaziente(riga[1], riga[2], riga[3], riga[4], riga[5])) {
						p = new Paziente(riga[1], riga[2], riga[3], riga[4], (riga[5].equalsIgnoreCase("si") ? true : false));
						elencoPersone.add(p);
					}
				break;
				
				case "medico":
					if(Util.controllaMedico(riga[1], riga[2], riga[3], riga[4], Integer.parseInt(riga[5]), Integer.parseInt(riga[6]))) {
						m = new Medico(riga[1], riga[2], riga[3], riga[4], Integer.parseInt(riga[5]), Integer.parseInt(riga[6]));
						elencoPersone.add(m);
					}
				break;
				
				default:
			}
			
		}
		
		file.close();
	}
	
	// 1- Scheda di tutte le persone
	
	public String elencoPersone() {
		
		String ris = "\nECCO L'ELENCO DI TUTTE LE PERSONE:\n";
		
		for(Persona p : elencoPersone) {
			ris += p.toString() + "\n";
		}
		
		return ris;
	}
	
	
	// 2- Scheda di tutti i pazienti 
	
	public String elencoPazienti() {
		
		String ris = "\nECCO L'ELENCO DI TUTTI I PAZIENTI:\n";
		
		for(Persona p : elencoPersone) {
			if(p instanceof Paziente)
				ris += p.toString() + "\n";
		}
		
		return ris;
	}
	
	
	// 3- Lista medici di un reparto specifico
	
	public ArrayList<Medico> elencoMedici(int reparto) {
		
		ArrayList<Medico> list = new ArrayList<Medico>();
		
		switch(reparto) {
		
			case 1:
				list = mediciString("ostetricia");
			break;
			
			case 2:
				list = mediciString("cardiologia");
			break;
			
			case 3:
				list =  mediciString("chirurgia");
			break;
			
			case 4:
				list =mediciString("neurologia");
			break;
			
			case 5:
				list =  mediciString("pediatria");
			break;
			
		}
		return list;
	}
	
	private ArrayList<Medico> mediciString(String parametro) {
		ArrayList<Medico> list = new ArrayList<Medico>();
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				if(m.getReparto().equalsIgnoreCase(parametro))
					list.add(m);
			}
		}
		return list;
	}
	
	
	// 4- Lista dei pazienti infettivi (solo nominativo)
	
	public String pazientiInfettivi() {
		String ris = "";
		for(Persona p : elencoPersone) {
			if(p instanceof Paziente) {
				Paziente pa = (Paziente) p;
				if(pa.infettivo())
					ris += "- " + pa.getNome() + " " + pa.getCognome() + "\n";
			}
		}
		return ris;
	}
	
	
	// 5- Numero di medici con 'buon medico'
	
	public int nBuoniMedici() {
		int counter = 0;
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				if(m.buonMedico())
					counter++;
			}
		}
		return counter;
	}
	
	
	// 6- Numero di medici con 'buon medico' in un dato reparto
	
	private int mediciStringN(String parametro) {
		int counter = 0;
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				if(m.getReparto().equalsIgnoreCase(parametro) && m.buonMedico())
					counter += 1;
			}
		}
		return counter;
	}
	
	public String nBuoniMedici(int reparto) {
		int counter = 0;
		String ris = "";
		switch(reparto) {
			// "\nQuesti sono i reparti disponibili:\n1- Ostetricia\n2- Cardiologia\n3- Chirurgia\n4- Neurologia\n5- Pediatria"
			case 1:
				ris = "\nEcco il numero di medici buoni del reparto di ostetricia: " + mediciStringN("ostetricia");
			break;
			
			case 2:
				ris = "\nEcco il numero di medici buoni del reparto di cardiologia: " + mediciStringN("cardiologia");
			break;
			
			case 3:
				ris = "\nEcco il numero di medici buoni del reparto di chirurgia: " + mediciStringN("chirurgia");
			break;
			
			case 4:
				ris = "\nEcco il numero di medici buoni del reparto di neurologia: " + mediciStringN("neurologia");
			break;
			
			case 5:
				ris = "\nEcco il numero di medici buoni del reparto di pediatria: " + mediciStringN("pediatria");
			break;
			
			default:
				ris = "\nNon è presente il reparto da te selezionato.";
		}
		return ris;
	}
	
	
	// 7- Lista pazienti con almeno una delle patologie indicate
	
	public String elencoPazienti(String[] listaPatologie) {
		String ris = "";
		for(Persona p : elencoPersone) {
			if(p instanceof Paziente) {
				Paziente pa = (Paziente) p;
				for(int i = 0; i < listaPatologie.length; i++) {
					if(listaPatologie[i].equalsIgnoreCase(pa.getPatologia())) {
						ris += p.toString() + "\n";
					}
				}
			}
		}
		
		return ris;
	}
	
	
	// 8- Stipendio medio dei medici in un dato reparto
	
	private double stipendioMedioReparto(String parametro) {
		int counter = 0;
		double stip = 0;
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				if(m.getReparto().equalsIgnoreCase(parametro)) {
					stip += m.stipendio();
					counter += 1;
					
				}
			}
		}
		return (stip / counter);
	}
	
	public String stipendoMedio(int reparto) {
		String ris = "";
		switch(reparto) {
			// "\nQuesti sono i reparti disponibili:\n1- Ostetricia\n2- Cardiologia\n3- Chirurgia\n4- Neurologia\n5- Pediatria"
			case 1:
				ris = "\nEcco lo stipendio medio dei medici del reparto di ostetricia: " + stipendioMedioReparto("ostetricia");
			break;
			
			case 2:
				ris = "\nEcco lo stipendio medio dei medici del reparto di cardiologia: " + stipendioMedioReparto("cardiologia");
			break;
			
			case 3:
				ris = "\nEcco lo stipendio medio dei medici del reparto di chirurgia: " + stipendioMedioReparto("chirurgia");
			break;
			
			case 4:
				ris = "\nEcco lo stipendio medio dei medici del reparto di neurologia: " + stipendioMedioReparto("neurologia");
			break;
			
			case 5:
				ris = "\nEcco lo stipendio medio dei medici del reparto di pediatria: " + stipendioMedioReparto("pediatria");
			break;
			
			default:
				ris = "\nNon è presente il reparto da te selezionato.";
		}
		return ris;
	}
	
	
	// 9- Totale stipendi di tutti i medici
	
	public String stipendioTot() {
		String ris = "Lo stipendio totale di tutti i medici è: ";
		double stip = 0;
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				stip += m.stipendio();
			}
		}
		return ris + stip + "€";
	}
	
	
	// 10- Scheda del medico più anziano
	
	public ArrayList<Medico> medicoAnziano() {
		ArrayList<Medico> list = new ArrayList<Medico>();
		int maxEta = 0;
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				if(m.eta() > maxEta) {
					maxEta = m.eta();
					list = new ArrayList<Medico>();
					list.add(m);
				}
					
				else if(m.eta() == maxEta)
				{
					maxEta = m.eta();
					list.add(m);
				}
			}
		}
		return list;
	}
	
	
	//11- Scheda del paziente più giovane
	
	public ArrayList<Paziente> pazienteGiovane() {
		ArrayList<Paziente> list = new ArrayList<Paziente>();
		int minEta = 1000;
		for(Persona p : elencoPersone) {
			if(p instanceof Paziente) {
				Paziente pa = (Paziente) p;
				if(pa.eta() < minEta) {
					minEta = pa.eta();
					list = new ArrayList<Paziente>();
					list.add(pa);
				}
					
				else if(pa.eta() == minEta)
				{
					minEta = pa.eta();
					list.add(pa);
				}
			}
		}
		return list;
	}
	
	
	// 12- Scheda del medico con più interventi falliti			
	
	public String medicoPiuIntFalliti() {
		String ris = "";
		int maxIntFall = 0;
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				if((m.getnInterventi() - m.getnInterventiOk()) > maxIntFall) {
					maxIntFall = (m.getnInterventi() - m.getnInterventiOk());
					ris = m.toString();
				}
					
				else if((m.getnInterventi() - m.getnInterventiOk()) == maxIntFall)
				{
					maxIntFall = (m.getnInterventi() - m.getnInterventiOk());
					ris += "\n" + m.toString();
				}
			}
		}
		return ris;
	}
	
	
	// 13- Scheda del medico con più interventi riusciti
	
	public String medicoPiuIntRiusc() {
		String ris = "";
		int maxIntOk = 0;
		for(Persona p : elencoPersone) {
			if(p instanceof Medico) {
				Medico m = (Medico) p;
				if(m.getnInterventiOk() > maxIntOk) {
					maxIntOk = m.getnInterventiOk();
					ris = m.toString();
				}
					
				else if(m.getnInterventiOk() == maxIntOk)
				{
					maxIntOk = m.getnInterventiOk();
					ris += "\n" + m.toString();
				}
			}
		}
		return ris;
	}
}
