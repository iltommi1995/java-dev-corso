package com.generation.circo.test;

import java.sql.Date;
import java.util.Scanner;

import com.generation.circo.dao.Config;
import com.generation.circo.dao.DAOAnimali;
import com.generation.circo.dao.DAOAttrazioni;
import com.generation.circo.dao.DAOClienti;
import com.generation.circo.dao.DAOStaff;
import com.generation.circo.entities.Animale;
import com.generation.utility.entities.Entity;

public class Test 
{
	public static void main(String[] args) 
	{
		DAOAnimali da = Config.DA;
		
		DAOAttrazioni dat = Config.DAT;
		
		DAOStaff ds = Config.DS;
		
		DAOClienti dc = Config.DC;
		
		
		
		Scanner tastiera = new Scanner(System.in);
		
		
		//for(Entity e : dat.elenco("Giovedì"))
		//	System.out.println(e);
		
		String opzioni = 	"\nScegli cosa vuoi fare:\n"	+
							"1- Stampa l'elenco delle attrazioni\n" +
							"2- Stampa l'elenco delle attrazioni comprese tra due date\n" +
							"3- Stampa l'elenco delle attrazioni gestite da persona con giorno di ferie x\n" +
							"4- Stampo l'elenco degli animali\n" +
							"5- Stampo l'elenco degli animali addestrati da un membro x dello staff\n" +
							"6- Stampo l'elenco degli animali addestrati da un membro dello staff per nome\n" +
							"7- Stampa l'elenco dei clienti\n" +
							"8- Stampa l'elenco dei clienti che hanno visitato una città x\n" +
							"9- Stampa l'elenco dei clienti la cui età è minore o uguale a x\n" +
							"10- Stampa l'elenco dello staff\n" +
							"11- Stampa l'elenco dello staff passando il sesso\n" +
							"12- Stampa l'elenco dello staff con etra tra min e max\n" +
							"\n13- Elimina un animale\n" +
							"14- Crea un animale\n" +
							"\n15- Aggiorna un animale\n" ;
		
		String ris = "";
		
		int scelta = -2000;
		boolean continua = false;
		
		do 
		{
			System.out.println(opzioni);
			scelta = Integer.parseInt(tastiera.nextLine());
			
			switch(scelta)
			{
				// ATTRAZIONI
			
				case 1:
					for(Entity e : dat.elenco())
						System.out.println(e);
					continua = continua(tastiera);
					break;
				case 2:
					System.out.println("\nInserisci la prima data");
					Date d1 = Date.valueOf(tastiera.nextLine());
					System.out.println("\nInserisci la seconda data");
					Date d2 = Date.valueOf(tastiera.nextLine());
					for(Entity e : dat.elenco(d1, d2))
						System.out.println(e);
					continua = continua(tastiera);
					break;
				case 3:
					System.out.println("\nInserisci il nome di un giorno");
					for(Entity e : dat.elenco(tastiera.nextLine()))
						System.out.println(e);
					continua = continua(tastiera);
					break;
					
				// ANIMALI
					
				case 4:
					for(Entity e : da.elenco())
						System.out.println(e);
					continua = continua(tastiera);
					break;
				case 5:
					System.out.println("\nInserisci l'id di un addestratore");
					for(Entity e : da.elenco(Integer.parseInt(tastiera.nextLine())))
						System.out.println(e);
					continua = continua(tastiera);
					break;
				case 6:
					System.out.println("\nInserisci il nome di un addestratore");
					for(Entity e : da.elenco(tastiera.nextLine()))
						System.out.println(e);
					continua = continua(tastiera);
					break;
					
				// CLIENTI
					
				case 7:
					for(Entity e : dc.elenco())
						System.out.println(e);
					continua = continua(tastiera);
					break;
				case 8:
					System.out.println("\nInserisci il nome di un giorno");
					for(Entity e : dc.elenco(tastiera.nextLine()))
						System.out.println(e);
					continua = continua(tastiera);
					break;
				case 9:
					System.out.println("\nInserisci l'età");
					for(Entity e : dc.elenco(Integer.parseInt(tastiera.nextLine())))
						System.out.println(e);
					continua = continua(tastiera);
					break;
					
				// STAFF
					
				case 10:
					for(Entity e : ds.elenco())
						System.out.println(e);
					continua = continua(tastiera);
					break;
				case 11:
					System.out.println("\nInserisci il sesso");
					for(Entity e : ds.elenco(tastiera.nextLine()))
						System.out.println(e);
					continua = continua(tastiera);
					break; 
				case 12:
					System.out.println("\nInserisci l'età min");
					int e1 = Integer.parseInt(tastiera.nextLine());
					System.out.println("\nInserisci l'età max");
					int e2 = Integer.parseInt(tastiera.nextLine());
					for(Entity e : ds.elenco(e1, e2))
						System.out.println(e);
					continua = continua(tastiera);
					break;
					
				// TEST CRUD ANIMALE
					
				case 13:
					System.out.println("\nInserisci l'id dell'animale da eliminare");
					if(da.delete(Integer.parseInt(tastiera.nextLine())))
						System.out.println("\nL'animale è stato eliminato");
					else
						System.out.println("\nErrore nella cancellazione");
					continua = continua(tastiera);
					break;
				case 14:
					System.out.println("\nInserisci il nome dell'animale");
					String nomeani = tastiera.nextLine();
					System.out.println("\nInserisci la specie dell'animale");
					String specieani = tastiera.nextLine();
					System.out.println("\nInserisci il tipo dell'animale");
					String tipoani = tastiera.nextLine();
					System.out.println("\nInserisci il costo giornaliero dell'animale");
					int costoani = Integer.parseInt(tastiera.nextLine());
					System.out.println("\nE' pericoloso? rispondi si o no");
					boolean pericoloso = tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
					System.out.println("\nE' vaccinato? rispondi si o no");
					boolean vaccinato = tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
					System.out.println("\nInserisci l'id dell'addestratore");
					int idadd = Integer.parseInt(tastiera.nextLine());
					
					Animale anim = new Animale(0, nomeani, specieani, tipoani, costoani, pericoloso, vaccinato, idadd);
					
					if(da.create(anim))
						System.out.println("\nL'animale è stato creato");
					else
						System.out.println("\nErrore nella creazione");
					continua = continua(tastiera);
					break;
					
				case 15:
					System.out.println("\nInserisci il nome dell'animale");
					String nomeaniup = tastiera.nextLine();
					System.out.println("\nInserisci la specie dell'animale");
					String specieaniup = tastiera.nextLine();
					System.out.println("\nInserisci il tipo dell'animale");
					String tipoaniup = tastiera.nextLine();
					System.out.println("\nInserisci il costo giornaliero dell'animale");
					int costoaniup = Integer.parseInt(tastiera.nextLine());
					System.out.println("\nE' pericoloso? rispondi si o no");
					boolean pericolosoup = tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
					System.out.println("\nE' vaccinato? rispondi si o no");
					boolean vaccinatoup = tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
					System.out.println("\nInserisci l'id addestratore");
					int idaddup = Integer.parseInt(tastiera.nextLine());
					
					System.out.println("\nInserisci l'id animale");
					int idanimup = Integer.parseInt(tastiera.nextLine());
					
					Animale an = new Animale(da.read("select * from animali where id = " + idanimup).get(0).getId(), nomeaniup, specieaniup, tipoaniup, costoaniup, pericolosoup, vaccinatoup, idaddup);
					
					if(da.update(an))
						System.out.println("\nL'animale è stato aggiornato");
					else
						System.out.println("\nErrore nell'aggiornamento");
					continua = continua(tastiera);
					break;
				default:
					System.out.println("\nLa scelta non è presente.");
					continua = continua(tastiera);
			}
		}
		while(continua == true);
		System.out.println("\nGrazie e arrivederci");
	}
	
	public static boolean continua(Scanner tastiera) 
	{
		System.out.println("\nVuoi fare un'altra operazione?\n");
		return tastiera.nextLine().equalsIgnoreCase("no") ? false : true;
	}
}
