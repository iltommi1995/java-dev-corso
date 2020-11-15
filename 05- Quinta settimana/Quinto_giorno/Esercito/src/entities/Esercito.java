package entities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import interfacce.IEsercito;
import util.Vik;

public class Esercito implements IEsercito {
	
	private ArrayList<Unita> elencoUnita;
	
	
	public Esercito(String path) throws FileNotFoundException {
		
		Scanner file = new Scanner(new File(path));
		
		elencoUnita = new ArrayList<Unita>();
		
		String[] riga;
		
		Soldato s;
		Mezzo m;
		Unita u;
		
		/*
		 * MEZZO,Liuka,791,804,499,749,10,SOTTOMARINO
		 * UNITA,Jillana,337,645,157
		 * SOLDATO,Elfrida,675,860,228,TANGO,116
		 */
		while(file.hasNextLine()) {
			riga = file.nextLine().split(",");
			
			switch(riga[0].toLowerCase()) {
			
				// Riga file che inizia con "mezzo"
				case "mezzo":
					if(Vik.controllaMezzo( riga[1], Integer.parseInt(riga[2]), Integer.parseInt(riga[3]),
									Integer.parseInt(riga[4]),  Integer.parseInt(riga[5]),
									Integer.parseInt(riga[6]), riga[7]	)								) 
					{
						
						m = new Mezzo(	riga[1], Integer.parseInt(riga[2]), Integer.parseInt(riga[3]),
								Integer.parseInt(riga[4]),  Integer.parseInt(riga[5]),
								Integer.parseInt(riga[6]), riga[7]									);
						elencoUnita.add(m);
					}
				break;
				
				// Riga file che inizia con "unita"
				case "unita":
					if(Vik.controllaUnita( riga[1], Integer.parseInt(riga[2]), Integer.parseInt(riga[3]),
							Integer.parseInt(riga[4])	)												) 
					{
						
						u = new Unita(	riga[1], Integer.parseInt(riga[2]), Integer.parseInt(riga[3]),
								Integer.parseInt(riga[4])											);
						elencoUnita.add(u);
					}
				break;
				
				// Riga file che inizia con "soldato"
				case "soldato":
					if(Vik.controllaSoldato( riga[1], Integer.parseInt(riga[2]), Integer.parseInt(riga[3]),
							Integer.parseInt(riga[4]),  riga[5], Integer.parseInt(riga[6])	)				) 
					{
						
						s = new Soldato(	riga[1], Integer.parseInt(riga[2]), Integer.parseInt(riga[3]),
								Integer.parseInt(riga[4]),   riga[5], Integer.parseInt(riga[6])				);									
						elencoUnita.add(s);	
					}
	
				break;
				
				// Altri casi
				default:
			}
			
		}
		file.close();
	}
	
	// METODI AGGREGATORE
	
	
	//Ritorna la scheda di tutte le unità (tutto il contenuto del file)
	
	public String listaUnita() 
    {
        String ris = "";
        for(Unita u : elencoUnita)
            ris += "\n" + u.toString() + "\n-------------------\n";
        return ris;
    }//end method listaUnita
	
	
	
	//Ritorna la scheda di tutti i soldati(solo i soldati!!) presenti nell'AL
	
	public String soldati() 
    {
        String ris = "";
        for(Unita s : elencoUnita)
        {
            if(s instanceof Soldato)
            {
                ris += s.toString() + " -------------------\n";
            }
        }
        return ris;
    }//end method soldati
	
	
	
	//Ritorna le schede dei soldati che appartengono alla squadra    passata come parametro.
	
	public String soldati(String squadra) 
    {
            String ris = "";
            for(Unita u : elencoUnita) //non so se questo va come plurale o singolare
            {
            	if(u instanceof Soldato) {
            		Soldato s = (Soldato) u;
            		if(s.getSquadra().equalsIgnoreCase(squadra))
                        ris += s.toString() + "\n-------------\n";
            	}
                
            }
           return ris;

    }//end method soldati(String squadra)
	
	
	
	//-> Ritorna la scheda di tutti i mezzi(solo i mezzi!!) presenti nell'AL
	
	public String listaMezzi() 
    {
        String ris = "";
        for(Unita u : elencoUnita)
        {
            if(u instanceof Mezzo)
            {
                ris += u.toString() + " -------------------\n";
            }
        }
        return ris;

    }// end method listaMezzi
	
	
	//Ritorna la scheda di tutti i mezzi presenti nell'AL
    //che possono raggiugere le coordinate passate come parametro
	
	public String listaUnitaCheRaggiungono(int x, int y) 
	{ 
		String ris="";
		for(Unita u : elencoUnita)
			{
				if(u instanceof Mezzo)
					{  
						Mezzo m = (Mezzo) u;
						if(m.raggiunge(x,y))
							ris += m.toString() + " -------------------\n";
					}//end if
			}//end for/each
		return ris;
	}//end ListaUnitaCheRaggiungono
	
	
	
	
	
	//Ritorna il conteggio di tutti i soldati presenti nell'AL
	//la cui potenza di fuoco è maggiore della potenza passata come parametro
	
	public int nSoldatiPotenzaFuocoMin(int potenza) 
    {
            int ris= 0;
            for(Unita u : elencoUnita)
                {
                    if(u instanceof Soldato)
                        {
                            Soldato s = (Soldato) u;
                            if(s.getPotenzaFuoco() >= potenza)
                            ris++;
                        }
                }
            return ris;
    }//end nSoldatiPotenzaFuocoMin
	
	
	
	//Ritornare la potenza di fuoco media tra tutti i soldati presenti nell'AL
	
	public double potenzaFuocoMedia() 
    {
        double ris= 0;
        int i = 0;
        for(Unita u : elencoUnita)
            {
                if(u instanceof Soldato)
                    {
                        Soldato s = (Soldato) u;
                        ris += s.getPotenzaFuoco();
                        i++;
                    }
            }
        return ris/i;
    }
	
	
	
	
	//Ritornare un AL contenente solo i mezzi il cui tipo corrisponde al tipo passato come parametro
	
	 public ArrayList<Unita> mezzi(String tipo) 
	 {
		ArrayList<Unita> mezziPerTipo = new ArrayList<Unita>();
		
		for(Unita u : elencoUnita) {
			if(u instanceof Mezzo) {
				Mezzo m = (Mezzo) u;
				if(m.getTipo().equalsIgnoreCase(tipo))
					mezziPerTipo.add(m);
			}
		}
		return mezziPerTipo;
	 }
	 
	 
	// Ritorno un AL contenente, senza ripetizioni, la lista della squadre.
	// NB. Ogni posizione nell'AL sarà composta da: il nome della squadra e quanti soldati appartengonoa quella squadra.
	// Consiglio: Usate due cicli diversi per trovare le squadre e per contare
	 
	 public ArrayList<String> conteggioSoldatiPerSquadra() 
	 {
		 // Soldati hanno squadra
		 // singola p AL: nome squadra, n soldati apparteneti
		 
		 ArrayList<String> squadre = new ArrayList<String>();
		 ArrayList<String> output = new ArrayList<String>();
		 int[] numeroSold;
		 Map<String,Integer> nomiSquadre = new LinkedHashMap<String,Integer>();
		 
		 /*
		 // squadre ha solo "prova"
		 for(Unita u : elencoUnita) {
			 int counter = 0;
			 // SOLDATO,Elfrida,675,860,228,TANGO,116
			 if(u instanceof Soldato) {
				 //SOLDATO,Elfrida,675,860,228,TANGO,116
				 Soldato so = (Soldato) u;
				 // 
				 for(String squadra : squadre) {
					 //		"prova" = "tango"
					 // 	"prova2" = "tango"
					 if(squadra.equalsIgnoreCase(so.getSquadra())) {
						 counter++;
					 }
				 }
				 if(counter == 0)
					 squadre.add(so.getSquadra());
			 }
		 }
		 numeroSold = new int[squadre.size()];
		 
		 for(Unita u : elencoUnita) {
			 if(u instanceof Soldato) {
				 Soldato so = (Soldato) u;
				 for(int i = 0; i < squadre.size(); i++) {
					 if(squadre.get(i).equalsIgnoreCase(so.getSquadra())) {
						 numeroSold[i] += 1;
					 }
				 }
			 }
		 }
		 
		 for(int i = 0; i < squadre.size(); i++) {
			 output.add("Il numero di soldati della squadra " + squadre.get(i) + " è: " + numeroSold[i]);
		 } */
		 
		 // Cicla tutte le unità 
		 for(Unita u : elencoUnita) {
		 	int counter = 0;
			 //SOLDATO,Elfrida,675,860,228,TANGO,116
			 // if u è Soldato
			 if(u instanceof Soldato) {
				 // casto soldati
				 Soldato so = (Soldato) u;
				 // cicla la mappa
				 for (String st : nomiSquadre.keySet()) {
					 if(st.equalsIgnoreCase(so.getSquadra())) {
						 counter++;
					 }					 
				 }
				 if(counter == 0)
				 	nomiSquadre.put(so.getSquadra(), 1);
				 else if(counter > 0)
					 counter += nomiSquadre.get(so.getSquadra());
				 	nomiSquadre.put(so.getSquadra(),counter);
			}
		}
		 
		 for(String s : nomiSquadre.keySet()) {
			 output.add("La squadra " + s + " ha " + nomiSquadre.get(s) + " soldati");
		 }
		 
		return output;
	 }

	
	 
	//Ritornare un AL ordinato in maniera crescente  rispetto al metodo distanzaDa(x,y), usanto le coordinate passate come parametri
	 
	 //public ArrayList<Unita> ordinaPerDistanzaDa(int x, int y) 
	 
	 @Override
		public ArrayList<Unita> ordinaPerDistanzaDa(int x, int y) {
		 	ArrayList<Unita> copia = new ArrayList<Unita>(elencoUnita);
			ArrayList<Unita> output = new ArrayList<Unita>();
			double distanza = Double.MAX_VALUE;

			Unita uni = null;
			for(int i = 0; i < copia.size(); i++) {
				distanza = Double.MAX_VALUE;
				uni = null;
				for(Unita u : copia) {
					if(u.distanzaDa(x,y) < distanza) {
						uni = u;
						distanza = u.distanzaDa(x,y);
					}
				}
				copia.remove(uni);
				output.add(uni);
			}
			return output;
		}
}