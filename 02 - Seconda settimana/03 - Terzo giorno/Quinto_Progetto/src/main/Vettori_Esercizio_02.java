package main;

import java.util.Scanner;

public class Vettori_Esercizio_02 
{
	public static void main(String[] args) 
	{
		// Utilizzando un ciclo do while inserite 3 studenti nel vostro registro
		// Per ogni studente inserite nome, cognome e mediaVoti
		// Chiedete all'utente di quale studente vuole vedere la scheda
		// Mostrando solo l'elenco dei cognomi
		// Stampate la scheda solo di quello studente:
		// La scheda è formata da nome, cognome, mediaVoti
		
		Scanner tastiera = new Scanner(System.in);
		String nomiCognomiStudenti[] = new String[6];
		double mediaVotiStudenti[] = new double[3];
		
		String nomeStudente, cognomeStudente;
		String riepilogoCognomi = "";
		String riepilogo = "";
		double mediaVoti;
		int i = 0;
		int e = 0;
		int cognome = 0;
		
		do {
			System.out.println("Inserisci i dati dello studente numero " + (i+1) + ". Per prima cosa il nome");
			nomiCognomiStudenti[i] = tastiera.nextLine();
			
			System.out.println("Ora inserisci il cognome.");
			nomiCognomiStudenti[i+1] = tastiera.nextLine();
			
			
			System.out.println("Adesso la media dei voti");
			mediaVotiStudenti[e] = Double.parseDouble(tastiera.nextLine());
			
			riepilogo += "\n- " + nomiCognomiStudenti[i] + " " + nomiCognomiStudenti[i+1] + "   ---- media voti: " + mediaVotiStudenti[e] ;
			i++;
			i++;
			e++;
		}
		while( i < (nomiCognomiStudenti.length));
		
		i = 0;
		
		while(i < nomiCognomiStudenti.length) {
			/*if(i==1)
				riepilogoCognomi += "\n" + i +"- " + nomiCognomiStudenti[i] ;
			if(i==3)
				riepilogoCognomi += "\n" + (i-1) +"- " + nomiCognomiStudenti[i] ;
			if(i==5)
				riepilogoCognomi += "\n" + (i-2) +"- " + nomiCognomiStudenti[i] ;*/
			if((i%2) == 0)
				riepilogoCognomi += i + " ";
			i++;
		}
		
		i = 0;
		
		while(i < nomiCognomiStudenti.length) {
			if((i%2) != 0)
				riepilogoCognomi += nomiCognomiStudenti[i] + "\n";
			i++;
		}
		System.out.println(riepilogoCognomi);
		
		System.out.println("Di quale dei seguenti vuoi vedere la scheda? Scrivi il numero del cognome" + riepilogoCognomi);
		cognome = Integer.parseInt(tastiera.nextLine());
		
		if(cognome == 1)
			System.out.println("\n-" + nomiCognomiStudenti[0] + " " + nomiCognomiStudenti[1] + " " + mediaVotiStudenti[0]);
		if(cognome == 2)
			System.out.println("\n-" + nomiCognomiStudenti[2] + " " + nomiCognomiStudenti[3] + " " + mediaVotiStudenti[1]);
		if(cognome == 3)
			System.out.println("\n-" + nomiCognomiStudenti[4] + " " + nomiCognomiStudenti[5] + " " + mediaVotiStudenti[2]);
		
	}
}
