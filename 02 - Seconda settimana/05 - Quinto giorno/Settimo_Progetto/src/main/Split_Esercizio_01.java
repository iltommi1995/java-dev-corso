package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Split_Esercizio_01 {

	public static void main(String[] args) throws FileNotFoundException {
		//Leggete da file un elenco di studenti formattato in questo modo:
		//nome-cognome-mediaIta-mediaMate
		//Il numero degli studenti lo decidete voi e verra indicato nel file
		//Chiedete all'utente cosa vuole fare:
		//Elenco studenti
		//Media totale della classe in italiano
		//Media totale della classe in matematica
		//Elenco degli studenti con una media in italiano > 7
		//Elenco degli studenti da bocciare (che hanno almeno una media < 6)
		//PER GLI STUDENTI SUPER SAYAN
		//Stampare il nome dello studente che ha la media piu alta in matematica!
		
		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\02 - Seconda settimana\\05 - Quinto giorno\\Settimo_Progetto\\src\\res\\ElencoStudenti.txt";
		Scanner file = new Scanner(new File(percorso));
		
		Scanner tastiera = new Scanner(System.in);
		
		String classe = file.nextLine();
		int numStudenti = Integer.parseInt(file.nextLine());
		boolean continua = false;
		
		String riepilogoStudenti = "";
		
		String studenti[] = new String[numStudenti*2];
		double voti[] = new double [numStudenti*2];
		String[] rigaFile;
		
		for (int i = 0; i < (studenti.length); i++) {
			rigaFile = file.nextLine().split("-");
			studenti[i] = rigaFile[0];
			studenti[i+1] = rigaFile[1];
			voti[i] = Double.parseDouble(rigaFile[2]);
			voti[i+1] = Double.parseDouble(rigaFile[3]);
			i++;
		}
		
		file.close();
		
		do {
			
			System.out.println("Selezione un'opzione col numero: " +
					"\n1- Elenco studenti" +
					"\n2- Media totale della classe in italiano" +
					"\n3- Media totale della classe in matematica" +
					"\n4- Elenco degli studenti con una media in italiano > 7" +
					"\n5- Elenco degli studenti da bocciare (che hanno almeno una media < 6)" +
					"\n6- Lo studente con la media più alta in matematica\n"
					);
			int scelta = Integer.parseInt(tastiera.nextLine());
			switch(scelta) {
			
				// Elenco studenti
				case 1:
					int count = 1;
					for(int i = 0; i < studenti.length; i++ ) {
						riepilogoStudenti += count + "- " + studenti[i] + " " + studenti[i+1] + "\n  ----Media italiano: " + voti[i] + "\n  ----Media matematica: " + voti[i+1] + "\n";
						i++;
						count ++;
					}
				System.out.println("\nELENCO STUDENTI DELLA CLASSE " + classe + ":\n" + riepilogoStudenti);
				
				System.out.println("\nVuoi eseguire un'altra operazione? Rispondi si o no\n");
				continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Media totale della classe in italiano
				case 2:
					double totIta = 0;
					for(int i = 0; i < studenti.length; i++) {
						if(i % 2 == 0) 
							totIta += voti[i];
					}
					System.out.println("La media della classe " + classe + " in italiano è: " + totIta / numStudenti);
					
					System.out.println("\nVuoi eseguire un'altra operazione? Rispondi si o no\n");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Media totale della classe in italiano
				case 3:
					double totMate = 0;
					for(int i = 0; i < studenti.length; i++) {
						if(i % 2 != 0) 
							totMate += voti[i];
					}
					System.out.println("La media della classe " + classe + " in matematica è: " + totMate / numStudenti);
					
					System.out.println("\nVuoi eseguire un'altra operazione? Rispondi si o no\n");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Elenco studenti con media in ita > 7
				case 4:
					String itaMaggiore7 = "";
					int count2 = 1;
					for(int i = 0; i < studenti.length; i++) {
						if(i % 2 == 0 && voti[i] > 7) {
							itaMaggiore7 += count2 + "- " + studenti[i] + " " + studenti[i+1] + " ha " + voti[i] + " in italiano.\n";
							count2 ++;
						}
					}
					System.out.println("\nQuesto è l'elenco degli studenti della classe " + classe + " con più di 7 in italiano:\n" + itaMaggiore7);
					
					System.out.println("\nVuoi eseguire un'altra operazione? Rispondi si o no\n");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Elenco studenti da bocciare
				case 5:
					String bocciati = "";
					int count3 = 1;
					for(int i = 0; i < studenti.length; i++) {
						double media = (voti[i] + voti[i+1]) /2;
						if(media < 6) {
							bocciati += count3 + "- " + studenti[i] + " " + studenti[i+1] + " ha media: " + media;
							count3++;
						}
						i++;
						
					}
					System.out.println("\nQuesto è l'elenco degli studenti della classe " + classe + " da bocciare:\n" + bocciati);
					
					System.out.println("\nVuoi eseguire un'altra operazione? Rispondi si o no\n");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Media più alta in matematica
				case 6:
					double voto = 0;
					double nuovoVoto= 0;
					String studenteBravo = "";
					for(int i = 0; i < voti.length; i++) {
						if(i % 2 != 0) {
							nuovoVoto = voti[i];
							studenteBravo = studenti[i-1] + " " + studenti[i] + " ha voto " ;
							if(i >= 3) {
								if(nuovoVoto < voti[i-2]) {
									nuovoVoto = voti[i-2];
									studenteBravo = studenti[i-3] + " " + studenti[i-2] + " ha voto ";
								}
							}
							voto = voto > nuovoVoto? voto : nuovoVoto;
							studenteBravo +=  voto + " in matematica.";
							System.out.println(studenteBravo + "  " + i);
						}
					}
					System.out.println("\nLo studente della classe " + classe + " col voto migliore in matimatica è:\n" + studenteBravo);
					
					System.out.println("\nVuoi eseguire un'altra operazione? Rispondi si o no\n");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
				break;
				
				// Default
				default:
					System.out.println("\nNon hai inserito un'opzione valida!");
					
					System.out.println("\nVuoi eseguire un'altra operazione? Rispondi si o no\n");
					continua = tastiera.nextLine().equalsIgnoreCase("si") ? true : false;
			}
		}
		while(continua== true);
		
		System.out.println("\nGrazie e arrivederci");
		
		tastiera.close();
		

	}

}
