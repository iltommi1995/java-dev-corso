package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DAOConcessionaria;
import entities.Automobile;

public class TestConcessionaria {

	public static void main(String[] args) 
	{
		// Test db
		
		DAOConcessionaria d = new DAOConcessionaria();
		
		
		boolean continua = false;
		int scelta = -2000;
		Scanner tastiera = new Scanner(System.in);
		do {
			String opzioni = 	"\nScegli una delle seguenti opzioni:\n" +
								"1- Stampa tutte le vetture\n" 	+
								"2- Stampa un veicolo per id\n"	+
								"3- Nome e cilindrata delle vetture con più di 1999 di cilindrata\n" +
								"4- Auto con cilindrata pari\n"										+
								"5- Auto vendute negli ultimi 3 anni\n"								+
								"6- Media eta clienti con auto bianche\n"								+
								"7- Media prezzi auto con 4 cilindri\n"								+
								"8- Clienti citta spendaccione"										;
			System.out.println(opzioni);
			
			scelta = Integer.parseInt(tastiera.nextLine());
			List<Automobile> lista;
			String [] param;
			String ris = "";
			double media = 0;
			switch(scelta) {
				case 1:
					System.out.println(DAOConcessionaria.stampa(d.listaVetture()));
					continua = DAOConcessionaria.continua(tastiera);
				break;
				
				case 2:
					System.out.println("\nInserisci l'id della vettura:");
					System.out.println(DAOConcessionaria.stampa(d.singolaVettura(Integer.parseInt(tastiera.nextLine()))));
					continua = DAOConcessionaria.continua(tastiera);
				break;
				
				case 3:
					ris = "";
					param  = new String[]{"nome", "cilindrata"};
					System.out.println(DAOConcessionaria.stampaQuelloCheVuoi(d.listaVettureCilindrata1999(), param));
					continua = DAOConcessionaria.continua(tastiera);
				break;
				
				case 4:
					ris = "";
					lista = d.listaVettureCilindrata1999();
					for(Automobile a : lista)
						ris += "\nNome auto: " +a.getNome() + "\n" + "Cilindrata: " +  a.getCilindrata() + "\nNumero cilindri: " + a.getNumerocilindri() + "\n\n" + "------";
					System.out.println(ris);
					continua = DAOConcessionaria.continua(tastiera);
				break;
				
				case 5:
					param  = new String[]{"nome", "datavendita", "cittacliente"};
					System.out.println(DAOConcessionaria.stampaQuelloCheVuoi(d.listaAutoVenduteNegliUltimi3Anni(), param));
					continua = DAOConcessionaria.continua(tastiera);
				break;
				
				case 6:
					 media = d.etaClientiAutoBianche();
					if(media == 0) 
						System.out.println("\nErrore");
					else
						System.out.println("\nLa media delle età dei clienti con auto bianche è: " + media);
					continua = DAOConcessionaria.continua(tastiera);
				break;
				
				case 7:
					 media = d.mediaPrezziVetture4Cilindri();
					if(media == 0) 
						System.out.println("\nErrore");
					else
						System.out.println("\nLa media dei prezzi delle auto con 4 cilindri è: " + media);
					continua = DAOConcessionaria.continua(tastiera);
				break;
				
				case 8:
					param  = new String[]{"nome", "datavendita", "cittacliente"};
					System.out.println(DAOConcessionaria.stampaQuelloCheVuoi(d.cittaSpendaccione(), param));
					continua = DAOConcessionaria.continua(tastiera);
				break;
			}
			
			
			
		} while(continua);
		
		
		System.out.println("\nGrazie e ciao");	
	}
}
