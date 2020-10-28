package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Split_Esercizio_Weekend_01 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		// Creo gli scanner che mi servono e leggo il file
		
		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\05 - Quinto giorno\\Settimo_Progetto\\src\\res\\FileEsercizioSplitWeekend.txt";
		Scanner file = new Scanner (new File(percorso));
		Scanner tastiera = new Scanner(System.in);
		
		// Dichiaro i due vettori che utilizzerò
		
		String riga [];
		int nStudenti = 0;
		int nInsegnanti = 0;
		String studentiInit ="";
		String insegnantiInit ="";
		String studenti[];
		String insegnanti[];
		double totStipendi = 0;
		
		// Leggo i dati dal file e inizializzo i vettori
		
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			if(riga[0].equalsIgnoreCase("studente")) {
				nStudenti++;
				studentiInit += riga[1] + "," + riga[2] + "," + riga[3] + ","; 
			}
			else {
				nInsegnanti++;
				insegnantiInit += riga[1] + "," + riga[2] + "," + riga[3] + ","; 
				totStipendi += Double.parseDouble(riga[3]);
			}
		}
		
		file.close();
		
		studenti = studentiInit.split(",");
		insegnanti = insegnantiInit.split(",");
				
		// Definisco le altre variabili che mi servono
		
		boolean repeat = false;
		int scelta;
		
		// Apro il do esterno
		
		do {
			System.out.println(
					"Scegli una delle seguenti opzioni:\n"			+
					"1- Elenco degli studenti\n"					+
					"2- Elenco degli insegnanti\n"					+
					"3- Studenti per classe\n"						+
					"4- Media stipendi insegnanti\n"					+
					"5- Nome dell'insegnante che guadagna di più"	
			);
			scelta = Integer.parseInt(tastiera.nextLine());
			
			// Parte l'elenco delle scelte
			
			switch(scelta) {
				// Opzione 1: stampare elenco degli studenti
				case 1:
					String elencoStudenti = "";
					int countSt = 1;
					for(int i = 0; i < (studenti.length - 1); i += 3) {
						elencoStudenti += countSt + "- " + studenti[i] + " " + studenti[i + 1] + " ------ classe " + studenti[i + 2] + "\n";
						countSt ++;
					}
					
					System.out.println("\nEcco l'elenco degli studenti:\n" + elencoStudenti);
				
					// Uguale per ogni case, permette di ripetere il do while esterno
					System.out.println("Vuoi eseguire un'altra operazione? Rispondi 'si' o 'no'.");
					repeat = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Opzione 2: stampare elenco degli insegnanti
				case 2:
					String elencoInsegnanti = "";
					int countIn = 1;
					for(int i = 0; i < (insegnanti.length - 1); i += 3) {
						elencoInsegnanti += countIn + "- " + insegnanti[i] + " " + insegnanti[i + 1] + " ------ classe " + insegnanti[i + 2] + "\n";
						countIn ++;
					}
					
					System.out.println("\nEcco l'elenco degli insegnanti:\n" + elencoInsegnanti);
				
					// Uguale per ogni case, permette di ripetere il do while esterno
					System.out.println("Vuoi eseguire un'altra operazione? Rispondi 'si' o 'no'.");
					repeat = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Opzione 3: studenti per classe
				case 3:
					String classi = "";
					int selezione;
					String studentiClasse = "";
					for(int i = 0; i < (studenti.length - 1); i += 3) {
						classi += "\n- " + studenti[i + 2];
					}
					System.out.println("Queste sono le classi, scegline una per vedere gli studenti della classe: " + classi);
					selezione = Integer.parseInt(tastiera.nextLine());
					switch(selezione) {
					
						case 4:
							for(int i = 0; i < (studenti.length - 1); i += 3) {
								if(Integer.parseInt(studenti[i + 2]) == selezione)
									studentiClasse += "- " + studenti[i] + " " + studenti[i + 1] + "\n";
							}
							System.out.println("\nEcco gli studenti della classe " + selezione + "\n" + studentiClasse );
						break;
						
						case 3:
							for(int i = 0; i < (studenti.length - 1); i += 3) {
								if(Integer.parseInt(studenti[i + 2]) == selezione)
									studentiClasse += "- " + studenti[i] + " " + studenti[i + 1] + "\n";
							}
							System.out.println("\nEcco gli studenti della classe " + selezione + "\n" + studentiClasse );
						break;
						
						case 2:
							for(int i = 0; i < (studenti.length - 1); i += 3) {
								if(Integer.parseInt(studenti[i + 2]) == selezione)
									studentiClasse += "- " + studenti[i] + " " + studenti[i + 1] + "\n";
							}
							System.out.println("\nEcco gli studenti della classe " + selezione + "\n" + studentiClasse );
						break;
						
						default:
							System.out.println("Non esiste la classe da te selezionata.");
					}
					
					// Uguale per ogni case, permette di ripetere il do while esterno
					System.out.println("Vuoi eseguire un'altra operazione? Rispondi 'si' o 'no'.");
					repeat = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Opzione 4: media stipendi insegnanti
				case 4:
					System.out.println("\nEcco la media degli stipendi degli insegnanti:   " + (totStipendi / nInsegnanti) + "€");
				
					// Uguale per ogni case, permette di ripetere il do while esterno
					System.out.println("Vuoi eseguire un'altra operazione? Rispondi 'si' o 'no'.");
					repeat = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Opzione 5: nome insegnante che guadagna di più
				case 5:
					double guadagno = 0;
					String nomiInsegnanti = "";
					for(int i = 0; i < (insegnanti.length - 1); i += 3) {
						if(guadagno == Double.parseDouble(insegnanti[i + 2])) {
							nomiInsegnanti += ", " + insegnanti[i] + " " + insegnanti[i + 1];
							guadagno = Double.parseDouble(insegnanti[i + 2]);
						}
						if(guadagno < Double.parseDouble(insegnanti[i + 2])) {
							nomiInsegnanti = insegnanti[i] + " " + insegnanti[i + 1];
							guadagno = Double.parseDouble(insegnanti[i + 2]);
						}
					}
					
					System.out.println("\nInsegnanti che guadagnano di più: " + nomiInsegnanti);
				
					// Uguale per ogni case, permette di ripetere il do while esterno
					System.out.println("Vuoi eseguire un'altra operazione? Rispondi 'si' o 'no'.");
					repeat = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Default, se utente sbaglia scelta opzione
				default:
					System.out.println("La scelta da te selezionata non è disponibile.");
					
					// Uguale per ogni case, permette di ripetere il do while esterno
					System.out.println("Vuoi eseguire un'altra operazione? Rispondi 'si' o 'no'.");
					repeat = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
			}
		}
		while (repeat == true);
		
		System.out.println("Ciao umano! Alla prossima.");
		tastiera.close();
	}
}
