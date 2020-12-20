package com.generation.aziendasql3.tests;

import java.sql.Date;
import java.util.Scanner;

import com.generation.aziendasql3.dao.DAODipendenti;
import com.generation.aziendasql3.entities.Dipendente;

public class TestCompleto {

	public static void main(String[] args) {
		/*
	     * - Chiedere all'utente di creare un dipendente inserendo i dati da tastiera
	     * una volta inseriti salvare il dipendente all'interno del database.
	     * - Successivamente estrarre da database tutti i dipendenti e stampare il 
	     * toString() di quello che ha l'id maggiore.
	     * - Chiedere all'utente di modificare il cognome di questo dipendente
	     * - Dopo averlo modificato a livello java, utilizzare il metodo update
	     * per modificarlo anche a livello di database
	     * - Come prima estrarre da database tutti i dipendenti e stampare id e cognome di
	     * ciascuno di loro
	     * - Infine cancellare il dipendente che è stato inserito dall'utente
	     * - Controllare su database se la cancellazione è avvenuta con successo
	     */
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Per aggiungere un nuovo dipendente devi inserire i dati.");
		System.out.println("\nInserisci il cognome del dipendente");
		String cognome = tastiera.nextLine();
		
		System.out.println("\nInserisci la data di nascita nel formato 'aaaa-mm-dd'");
		Date data = Date.valueOf(tastiera.nextLine());
		
		System.out.println("\nInserisci il sesso con 'M' o 'F'");
		String sesso =tastiera.nextLine();
		
		System.out.println("\nInserisci la residenza");
		String residenza =tastiera.nextLine();
		
		System.out.println("\nInserisci lo stipendio");
		int stipendio = Integer.parseInt(tastiera.nextLine());
		
		System.out.println("\nInserisci l'id della sede (1 o 2)");
		int sede = Integer.parseInt(tastiera.nextLine());
		System.out.println("Sede è: " +  sede);
		
		Dipendente d = new Dipendente(0, cognome, data, sesso, residenza,
										stipendio, sede);
		
		DAODipendenti dd = new DAODipendenti();
		dd.create(d);
		
		// Dipendente con id maggiore
		d = dd.dipendenteIdMaggiore().get(0);
		System.out.println("\nEcco il dipendente con id maggiore (ultimo aggiunto):\n\n" + d.toString());
		
		
		// Modifica dipendente con id maggiore
		
		System.out.println("\nOk, ora modifica il cognome di questo dipendente");
		
		System.out.println("\nInserisci il nuovo cognome:");
		
		d.setCognome(tastiera.nextLine());
		
		dd.update(d);
		
		// Lista di tutti i dipendenti con solo id e cognome
		System.out.println("\nElenco prima della cancellazione:\n");
		System.out.println(dd.elencoIdCognome());
		
		// cancellare utente inserito 
		
		dd.delete(d.getId());
		System.out.println("\nElenco dopo la cancellazione:\n");
		System.out.println(dd.elencoIdCognome());
		

	}

}
