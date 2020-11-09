package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import util.Utils;

public class Scuola {
	
	private ArrayList<Persona> elencoPersone;
	
	public Scuola(String path) throws FileNotFoundException {
		Scanner file = new Scanner(new File(path));
		String[] riga;
		Studente s;
		StudErasmus se;
		elencoPersone = new ArrayList<Persona>();
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			if(riga[0].equalsIgnoreCase("studente")) {
				if(	Utils.controllaString(riga[1]) 						&&
					Utils.controllaInt(Integer.parseInt(riga[2])) 		&& 
					Utils.controllaString(riga[3]) 						&&
					Utils.controllaDouble(Double.parseDouble(riga[4])) 	&& 
					Utils.controllaDouble(Double.parseDouble(riga[5]))	) 
				{
					s = new Studente( riga[1], Integer.parseInt(riga[2]), riga[3], Double.parseDouble(riga[4]), Double.parseDouble(riga[5]));
					elencoPersone.add(s);
				}
			}
			
			if(riga[0].equalsIgnoreCase("studerasmus")) {
				if(	Utils.controllaString(riga[1]) 						&&
					Utils.controllaInt(Integer.parseInt(riga[2])) 		&& 
					Utils.controllaString(riga[3]) 						&&
					Utils.controllaDouble(Double.parseDouble(riga[4])) 	&& 
					Utils.controllaDouble(Double.parseDouble(riga[5]))	&&
					Utils.controllaDouble(Double.parseDouble(riga[6])) 	&& 
					Utils.controllaDouble(Double.parseDouble(riga[7])) 	) 
				{
					se = new StudErasmus( riga[1], Integer.parseInt(riga[2]), riga[3], Double.parseDouble(riga[4]), Double.parseDouble(riga[5]), Double.parseDouble(riga[6]), Double.parseDouble(riga[7]));
					elencoPersone.add(se);
				}
			}
		}
	}
	
	/*
	 * elenco()
		 * elenco(int classe)
		 * cerca(string nome)
		 * mediaTotInglese()
	 */
	
	public String elenco() {
		String ris = "ECCO L'ELENCO DELLE PERSONE:\n";
		
		for(Persona p : elencoPersone) {
			ris += p.toString() + "\n";
		}
		
		return ris;
	}
	
	public String elenco(int classe) {
		String ris = "ECCO L'ELENCO DELLE PERSONE DELLA CLASSE " + classe + ":\n";
		switch(classe) {
			case 1:
				ris = perClasse("3a", ris);
			break;
			case 2:
				ris = perClasse("5b", ris);
			break;
			default:
				ris = "\nNon esiste la classe da te selezionata!";
		}
		
		return ris;
	}
	
	private String perClasse(String classe, String ris) {
		for(Persona p : elencoPersone) {
			if(p instanceof Studente) {
				Studente stud;
				stud = (Studente) p;
				if(stud.getClasse().equalsIgnoreCase(classe))
					ris += p.toString() + "\n";
			}
		}
		
		return ris;
	}
	
	public String cerca(String nome) {
		String ris = "";
		for(Persona p : elencoPersone) {
			if(p.getNome().toLowerCase().contains(nome))
				ris += p.toString() + "\n";
		}
		ris += ris.length() == 0 ? "Non esiste uno studente con quel nome" : "";
		
		return ris;
	}
	
	public double mediaTotIng() {
		double media = 0;
		int counter = 0;
		
		for(Persona p : elencoPersone) {
			if(p instanceof StudErasmus)
			{
				StudErasmus studer;
				studer = (StudErasmus) p;
				media += studer.getMediaIng();
				counter++;
			}
		}
		return media/counter;
	}
	
	public String esito(int scelta) {
		String ris = "";
		
		switch(scelta) {
			case 1: 
				ris = "\nECCO L'ELENCO DEGLI STUDENTI BOCCIATI:\n\n";
				for(Persona p : elencoPersone) {
					if(p.esito().equalsIgnoreCase("bocciato")) 
						ris += p.toString() + "\n";
				}
			break;
			case 2: 
				ris = "ECCO L'ELENCO DEGLI STUDENTI PROMOSSI:\n";
				for(Persona p : elencoPersone) {
					if(p.esito().equalsIgnoreCase("promosso")) 
						ris += p.toString() + "\n";
				}
			break;
			default:
				ris = "\nLa scelta da te selezionata non è disponibile!";
		}
		
		return ris;
	}
	
	public String esito(int classe, int scelta) {
		String classeScelta;
		if(classe == 1) 
			classeScelta = "3A";
		else if(classe == 2)
			classeScelta = "5B";
		else
			classeScelta = "La classe da te scelta non è disponibile";
		String ris = "";
		
		switch(scelta) {
			case 1: 
				ris = "\nECCO L'ELENCO DEGLI STUDENTI BOCCIATI:\n\n";
				if(classeScelta.length() > 2)
					ris = classeScelta;
				else {
					for(Persona p : elencoPersone) {
						Studente pi = (Studente) p;
						if(p.esito().equalsIgnoreCase("bocciato") && pi.getClasse().equalsIgnoreCase(classeScelta)) {
							ris += p.toString() + "\n";
						}
					}
				}
			break;
			case 2: 
				ris = "ECCO L'ELENCO DEGLI STUDENTI PROMOSSI:\n";
				if(classeScelta.length() > 2)
					ris = classeScelta;
				else {
					for(Persona p : elencoPersone) {
						Studente pi = (Studente) p;
						if(p.esito().equalsIgnoreCase("promosso") && pi.getClasse().equalsIgnoreCase(classeScelta)) 
							ris += p.toString() + "\n";
					}
				}
			break;
			default:
				ris = "\nLa scelta da te selezionata non è disponibile!";
		}
		
		return ris;
	}
	
	
}
