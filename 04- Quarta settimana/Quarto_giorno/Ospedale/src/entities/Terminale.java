package entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Terminale {
	
	public Scanner tastiera;
	
	public Terminale(Scanner tastiera) {
		this.tastiera = tastiera;
	}
	/*
	 * 1- String listaCompleta() ---------------------------> La scheda di tutte le persone(sia medici che pazienti)
		2- String listaPazienti() ---------------------------> La scheda di tutti i pazienti
		3- ArrayList<String> mediciReparto(String reparto) -------------> La lista dei medici di uno specifico reparto
		4- String listaPazientiInfettivi() ------------------> La lista dei pazienti infettivi(solo nominativo)
		5- int nMediciBuoni() -------------------------------> Il numero di medici con buonMedico() == true
		6- int nMediciBuoniReparto(String reparto) ----------> Come il precedente ma sul reparto del parametro
		7- String pazientiConPatologie(String[] patologie) --> La lista dei pazienti che hanno almeno una delle patologia passate come parametro
		8- double stipendioMedio(String reparto) ------------> Lo stipendio medio in base a un reparto preso come parametro
		9- double totaleStipendi() --------------------------> Il totale degli stipendi di tutti i medici
		10- ArrayList<Medico> medicoAnziano() ---------------------------> La scheda del medico più anziano
		11- ArrayList<Paziente> pazienteGiovane() -------------------------> La scheda del paziente più giovane
		12- String medicoKiller() ----------------------------> La scheda del medico più killer dell'ospedale(maggior numero di interventi falliti)
		13- String medicoSicuro() ----------------------------> La scheda del medico che ha il maggior numero di interventi riusciti
	 */
	public String output()  {
		boolean continua = false;
		
		String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\04- Quarta settimana\\Quarto_giorno\\Ospedale\\src\\res\\sadd.txt";

		Ospedale osp = null;
		try {
			osp = new Ospedale(path);
		} catch (FileNotFoundException e1) {
			boolean ok = true;
			do {
				try {
					ok = true;
					System.out.println("Il percorso del file è sbagliato, prova a inserirlo nuovamente:");
					path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\04- Quarta settimana\\Quarto_giorno\\Ospedale\\src\\res\\" + tastiera.nextLine();
					osp = new Ospedale(path);
					
				} catch (FileNotFoundException e2) {
					ok = false;
				}
			} while (ok == false);
		}
		
					
		do {
			System.out.println(
							"Scegli una delle seguenti operazioni:\n" 							+
							"1- Scheda di tutte le persone\n"									+
							"2- Scheda di tutti i pazienti\n"									+
							"3- Lista medici di un reparto specifico\n"							+
							"4- Lista dei pazienti infettivi (solo nominativo)\n"				+
							"5- Numero di medici con 'buon medico'\n"							+
							"6- Numero di medici con 'buon medico' in un dato reparto\n"		+
							"7- Lista pazienti con almeno una delle patologie indicate\n"		+
							"8- Stipendio medio dei medici in un dato reparto\n"				+
							"9- Totale stipendi di tutti i medici\n"							+
							"10- Scheda del medico più anziano\n"								+
							"11- Scheda del paziente più giovane\n"								+
							"12- Scheda del medico con più interventi falliti\n"				+
							"13- Scheda del medico con più interventi riusciti\n"				);
			
			int scelta = 1000;
			try {
				scelta = Integer.parseInt(tastiera.nextLine());
				
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Il valore da inserire deve essere numerico.");
			}
			
			switch(scelta) {
			
			case 1: 
				System.out.println(osp.elencoPersone());
				continua = continua();
				break;
				
			case 2: 
				System.out.println(osp.elencoPazienti());
				continua = continua();
				break;
				
			case 3: 
				try {
					System.out.println("\nQuesti sono i reparti disponibili:\n1- Ostetricia\n2- Cardiologia\n3- Chirurgia\n4- Neurologia\n5- Pediatria");
					ArrayList<Medico> medi = osp.elencoMedici(Integer.parseInt(tastiera.nextLine()));
					String rispo = "";
					for(Medico p : medi) {
						rispo += p.toString() + "\n";
					}
					System.out.println("ECCO LA LISTA DEI MEDICI DEL REPARTO DA TE INDICATO:\n\n" + rispo); 
				} catch(java.lang.NumberFormatException e) {
					System.out.println("\nDevi inserire solo valori numerici!");
				}
				continua = continua();
				break;
				
			case 4: 
				System.out.println(osp.pazientiInfettivi());
				continua = continua();
				break;
				
			case 5: 
				System.out.println(osp.nBuoniMedici());
				continua = continua();
				break;
				
			case 6: 
				try {
					
					System.out.println("\nQuesti sono i reparti disponibili:\n1- Ostetricia\n2- Cardiologia\n3- Chirurgia\n4- Neurologia\n5- Pediatria");
					System.out.println(osp.nBuoniMedici(Integer.parseInt(tastiera.nextLine())));
				} catch(java.lang.NumberFormatException e) {
					System.out.println("\nDevi inserire solo valori numerici!");
				}
				continua = continua();
				break;
				
			case 7: 
				System.out.println("Inserisci la lista delle patologie da verificare, separate per ', ':\n");
				System.out.println(osp.elencoPazienti(tastiera.nextLine().split(", ")));
				continua = continua();
				break;
				
			case 8: 
				try {
					
					System.out.println("\nQuesti sono i reparti disponibili:\n1- Ostetricia\n2- Cardiologia\n3- Chirurgia\n4- Neurologia\n5- Pediatria");
					System.out.println(osp.stipendoMedio(Integer.parseInt(tastiera.nextLine())));
				} catch(java.lang.NumberFormatException e) {
					System.out.println("\nDevi inserire solo valori numerici!");
				}
				continua = continua();
				break;
				
			case 9: 
				System.out.println(osp.stipendioTot());
				continua = continua();
				break;
				
			case 10: 
				ArrayList<Medico> med = osp.medicoAnziano();
				String risp = "";
				for(Medico p : med) {
					risp += p.toString() + "\n";
				}
				System.out.println("ECCO LA LISTA DEI MEDICI PIU' ANZIANI:\n\n" + risp);
				continua = continua();
				break;
				
			case 11: 
				ArrayList<Paziente> paz = osp.pazienteGiovane();
				String ris = "";
				for(Paziente p : paz) {
					ris += p.toString() + "\n";
				}
				System.out.println("ECCO LA LISTA DEI PAZIENTI PIU' GIOVANI:\n\n" + ris);
				continua = continua();
				break;
				
			case 12: 
				System.out.println(osp.medicoPiuIntFalliti());
				continua = continua();
				break;
				
			case 13: 
				System.out.println(osp.medicoPiuIntRiusc());
				continua = continua();
				break;
				
			case 1000:
				continua = continua();
				break;
				
			default:
				System.out.println("\nNon esiste la scelta da te selezionata.");
				continua = continua();
				
			}
		} while (continua == true);
		
		return "Ciao e alla prossima!";
		
	}
	
	public boolean continua() {
		System.out.println("\nVuoi effettuare un'altra operazione? Rispondi si o no.");
		return tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
	}

}
