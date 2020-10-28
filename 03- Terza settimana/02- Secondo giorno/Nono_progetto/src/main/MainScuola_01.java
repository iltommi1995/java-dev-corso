package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Insegnante;
import entities.Studente;

public class MainScuola_01 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\03- Terza settimana\\02- Secondo giorno\\Nono_progetto\\src\\res\\ElencoScuola_01.txt";
		Scanner file = new Scanner(new File(percorso));
		
		// Creo una variabile dimensione inizializzata a zero

		int nStud = 0;
		int nIns = 0;
		String[] riga;
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			switch(riga[0].toLowerCase()) {
			case "studente":
				nStud++;
			break;
			case "insegnante":
				nIns++;
			break;
			}
		}
		file.close();
		
		// A questo punto ho chiuso il file e devo riaprirlo
		// Perchè ha finito di leggere le righe;
		
		file = new Scanner(new File(percorso));
		
		int indiceStudenti = 0;
		int indiceInsegnanti =0;
		// Creo un vettore che conterrà oggetti di tipo Studente
		Studente[] studenti = new Studente[nStud];
		Insegnante[] insegnanti = new Insegnante[nIns];
		
		Studente s;
		Insegnante in;
		String[] rigaFile;
		
		
		while(file.hasNextLine()) {
			
			rigaFile = file.nextLine().split(",");
			switch(rigaFile[0].toLowerCase()) {
				case "studente":
					s = new Studente();
					s.nome = rigaFile[1];
					s.eta= Integer.parseInt(rigaFile[2]);
					s.mediaIta = Double.parseDouble(rigaFile[3]);
					s.mediaMate = Double.parseDouble(rigaFile[4]);
					s.classe = Integer.parseInt(rigaFile[5]);
					studenti[indiceStudenti] = s;
					indiceStudenti++;
				break;
				case "insegnante":
					in = new Insegnante();
					in.nome = rigaFile[1];
					in.eta = Integer.parseInt(rigaFile[2]);
					in.materia = rigaFile[3];
					in.stipendio = Double.parseDouble(rigaFile[4]);
					insegnanti[indiceInsegnanti] = in;
					indiceInsegnanti++;
				default:
				break;
			}
		}
		file.close();
		String menu = 	"1- Elenco studenti\n" 							+
						"2- Media età studenti\n" 						+
						"3- Studenti promossi\n" 						+
						"4- Studenti bocciati\n" 						+
						"5- Elenco insegnanti\n" 						+
						"6- Insegnante più pagato\n" 					+
						"7- Insegnante di matematica più pagato\n" 		+
						"8- Media degli stipendi\n"						;
		System.out.println(menu);
		Scanner tastiera = new Scanner(System.in);
		int azione = Integer.parseInt(tastiera.nextLine());
		
		String riepilogo = "";
		switch(azione) {
			case 1:
				for(int i = 0; i < studenti.length; i++) {
					riepilogo += (i+1) + "- " + studenti[i].scheda() + "\n";
				}
			break;
			case 2:
				double media = 0;
				for(int i = 0; i < studenti.length; i++) {
					media += studenti[i].eta;
				}
				riepilogo = "La media delle età degli studenti è: " + (media/nStud) + " anni.";
			break;
			
			// Elenco promossi
			case 3:
				for(int i = 0; i < studenti.length; i++) {
					if(studenti[i].esito() == true) {
						riepilogo += "- " + studenti[i].nome + "\n";
					}
				}
			break;
			
			
			// Elenco bocciati
			case 4:
				for(int i = 0; i < studenti.length; i++) {
					if(studenti[i].esito() == false) {
						riepilogo += "- " + studenti[i].nome + "\n";
					}
				}
			break;
			
			// Elenco insegnanti
			case 5:
				for(int i = 0; i < insegnanti.length; i++) {
					riepilogo += (i+1) + "- " + insegnanti[i].scheda() + "\n";
				}
			break;	
			
			// Insegnante più pagato
			case 6:
				double stip = 0;
				riepilogo = "Gli insegnanti più pagati sono:\n";
				for(int i = 0; i < insegnanti.length; i++) {
					if(insegnanti[i].stipendio == stip) {
						stip = insegnanti[i].stipendio;
						riepilogo += "- " + insegnanti[i].scheda() + "\n";
					}
					if(insegnanti[i].stipendio > stip) {
						stip = insegnanti[i].stipendio;
						riepilogo = "- " + insegnanti[i].scheda() + "\n";
					}
				}
			break;	
			
			// Insegnante di mate più pagato
			case 7:
				double stipMat = 0;
				riepilogo = "Gli insegnanti di matematica più pagati sono:\n";
				for(int i = 0; i < insegnanti.length; i++) {
					if((insegnanti[i].materia.equalsIgnoreCase("matematica")) && (insegnanti[i].stipendio == stipMat)) {
						stipMat = insegnanti[i].stipendio;
						riepilogo += "- " + insegnanti[i].scheda() + "\n";
					}
					if((insegnanti[i].materia.equalsIgnoreCase("matematica")) && (insegnanti[i].stipendio > stipMat)) {
						stipMat = insegnanti[i].stipendio;
						riepilogo = "- " + insegnanti[i].scheda() + "\n";
					}
				}
			break;	

			// media stipendi
			case 8:
				double mediaStip = 0;
				riepilogo = "La media degli stipendi è: ";
				for(int i = 0; i < insegnanti.length; i++) {
					mediaStip += insegnanti[i].stipendio;
				}
				riepilogo += mediaStip/nIns + "€";
			break;	
				
			
			
			default:
				riepilogo = "Azione non riconosciuta";
		}
		
		System.out.println(riepilogo);
		tastiera.close();
	}
}
