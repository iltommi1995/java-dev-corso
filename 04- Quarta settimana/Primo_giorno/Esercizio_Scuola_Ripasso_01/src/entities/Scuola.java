package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scuola {
	
	public ArrayList<Persona> elencoPersone;
	
	public Scuola(String path) throws FileNotFoundException {
		elencoPersone = new ArrayList<Persona>();
		
		Scanner file = new Scanner(new File(path));
		
		String[] riga;
		Persona p;
		
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			switch(riga[0].toLowerCase()) {
				case "studente":
					p = new Studente(riga[1], riga[2], Integer.parseInt(riga[3]), riga[4], Double.parseDouble(riga[5]), Double.parseDouble(riga[6]));
					elencoPersone.add(p);
				break;
				case "insegnante":
					p = new Insegnante(riga[1], riga[2], Integer.parseInt(riga[3]), riga[4], Integer.parseInt(riga[5]));
					elencoPersone.add(p);
				break;
			}
		}
		file.close();
	}
	
	
	public String nPersone() {
		int counter = 0;
		for(Persona pers : elencoPersone) {
			counter++;
		}
		return "Il numero totale di persone è: " + counter;
		
	}
	
	public String nStudenti() {
		int counter = 0;
		for(Persona pers : elencoPersone) {
			if(pers instanceof Studente)
				counter++;
		}
		return "Il numero totale di studenti è: " + counter;
	}
	
	public String nInsegnanti() {
		int counter = 0;
		for(Persona pers : elencoPersone) {
			if(pers instanceof Insegnante)
				counter++;
		}
		return "Il numero totale di insegnanti è: " + counter;
	}
	
	public String elencoPersone() {
		String risp = "";
		for(Persona pers : elencoPersone) {
			risp += pers.toString() + "\n";
		}
		return "ECCO L'ELENCO DI TUTTE LE PERSONE:\n " + risp;
	}
	
	public String elencoPersone(int eta) {
		String risp = "";
		for(Persona pers : elencoPersone) {
			if(pers.eta >= eta)
				risp += pers.toString() + "\n";
		}
		return "ECCO L'ELENCO DI TUTTE LE PERSONE CON ETA SUPERIORE A " + eta + ":\n " + risp;
	}
	
	public String elencoStudenti() {
		String risp = "";
		for(Persona pers : elencoPersone) {
			if(pers instanceof Studente)
				risp += pers.toString() + "\n";
		}
		return "ECCO L'ELENCO DI TUTTI GLI STUDENTI:\n" + risp;
	}
	
	public String elencoInsegnanti() {
		String risp = "";
		for(Persona pers : elencoPersone) {
			if(pers instanceof Insegnante)
				risp += pers.toString() + "\n";
		}
		return "ECCO L'ELENCO DI TUTTI GLI INSEGNANTI:\n" + risp;
	}
	
	public String elencoStudentiPerClasse(int scelta) {
		String risp = "";
		Studente s;
		switch(scelta) {
			case 1:
				risp += "ECCO L'ELENCO DEGLI STUDENTI DELLA CLASSE 1E:\n";
				for(int i = 0; i < elencoPersone.size(); i++) {
					if(elencoPersone.get(i) instanceof Studente) {
						s = (Studente) elencoPersone.get(i);
						if(s.classe.equalsIgnoreCase("1e")) {
							risp += elencoPersone.get(i).toString() + "\n";
						}
					}
				}
			break;
			case 2:
				risp += "ECCO L'ELENCO DEGLI STUDENTI DELLA CLASSE 2A:\n";
				for(int i = 0; i < elencoPersone.size(); i++) {
					if(elencoPersone.get(i) instanceof Studente) {
						s = (Studente) elencoPersone.get(i);
						if(s.classe.equalsIgnoreCase("2a")) {
							risp += elencoPersone.get(i).toString() + "\n";
						}
					}
				}
			break;
			case 3:
				risp += "ECCO L'ELENCO DEGLI STUDENTI DELLA CLASSE 3B:\n";
				for(int i = 0; i < elencoPersone.size(); i++) {
					if(elencoPersone.get(i) instanceof Studente) {
						s = (Studente) elencoPersone.get(i);
						if(s.classe.equalsIgnoreCase("3b")) {
							risp += elencoPersone.get(i).toString() + "\n";
						}
					}
				}
			break;
			default:
				risp = "\nNon esiste la classe da te selezionata!";
		}
		
		return risp;
	}
	
	public String elencoInsegnantiPerMateria(int scelta) {
		String risp = "";
		Insegnante in;
		switch(scelta) {
			case 1:
				risp += "ECCO L'ELENCO DEGLI INSEGNANTI DI ITALIANO:\n";
				for(int i = 0; i < elencoPersone.size(); i++) {
					if(elencoPersone.get(i) instanceof Insegnante) {
						in = (Insegnante) elencoPersone.get(i);
						if(in.materia.equalsIgnoreCase("italiano")) {
							risp += elencoPersone.get(i).toString() + "\n";
						}
					}
				}
			break;
			case 2:
				risp += "ECCO L'ELENCO DEGLI INSEGNANTI DI MATEMATICA:\n";
				for(int i = 0; i < elencoPersone.size(); i++) {
					if(elencoPersone.get(i) instanceof Insegnante) {
						in = (Insegnante) elencoPersone.get(i);
						if(in.materia.equalsIgnoreCase("matematica")) {
							risp += elencoPersone.get(i).toString() + "\n";
						}
					}
				}
			break;
			case 3:
				risp += "ECCO L'ELENCO DEGLI INSEGNANTI DI SCIENZE:\n";
				for(int i = 0; i < elencoPersone.size(); i++) {
					if(elencoPersone.get(i) instanceof Insegnante) {
						in = (Insegnante) elencoPersone.get(i);
						if(in.materia.equalsIgnoreCase("scienze")) {
							risp += elencoPersone.get(i).toString() + "\n";
						}
					}
				}
			break;
			case 4:
				risp += "ECCO L'ELENCO DEGLI INSEGNANTI DI EDUCAZIONE FISICA:\n";
				for(int i = 0; i < elencoPersone.size(); i++) {
					if(elencoPersone.get(i) instanceof Insegnante) {
						in = (Insegnante) elencoPersone.get(i);
						if(in.materia.equalsIgnoreCase("educazione fisica")) {
							risp += elencoPersone.get(i).toString() + "\n";
						}
					}
				}
			break;
			default:
				risp = "\nNon esiste la materia da te selezionata!";
		}
		
		return risp;
	}
	
	public String elencoStudentiPromossi() {
		String risp = "";
		Studente s;
		risp += "ECCO L'ELENCO DEGLI STUDENTI PROMOSSI:\n";
		for(int i = 0; i < elencoPersone.size(); i++) {
			if(elencoPersone.get(i) instanceof Studente) {
				s = (Studente) elencoPersone.get(i);
				if(s.esito().equalsIgnoreCase("promosso"))
					risp += s.toString();
			}
		}
		return risp;
	}
	
	public String insegnantiRicchi() {
		String risp = "";
		Insegnante in;
		risp += "ECCO L'ELENCO DEI PROFESSORI CON STIPENDIO SUPERIORE A 2000 €:\n";
		for(int i = 0; i < elencoPersone.size(); i++) {
			if(elencoPersone.get(i) instanceof Insegnante) {
				in = (Insegnante) elencoPersone.get(i);
				if(in.stipendio() > 2000)
					risp += in.toString();
			}
		}
		return risp;
	}
	
	public String insegnantiRicchi(int stipendio) {
		String risp = "";
		Insegnante in;
		risp += "ECCO L'ELENCO DEI PROFESSORI CON STIPENDIO SUPERIORE A " + stipendio + " €:\n";
		for(int i = 0; i < elencoPersone.size(); i++) {
			if(elencoPersone.get(i) instanceof Insegnante) {
				in = (Insegnante) elencoPersone.get(i);
				if(in.stipendio() > stipendio)
					risp += in.toString();
			}
		}
		return risp;
	}
	
}
