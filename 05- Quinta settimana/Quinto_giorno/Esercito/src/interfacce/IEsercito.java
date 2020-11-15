package interfacce;

import java.util.ArrayList;

import entities.Unita;

public interface IEsercito {
	/**
	 * Ritorna la scheda di tutte le unità (tutto il contenuto del file)
	 * @return String
	 */
	public String listaUnita();
	
	
	/**
	 * 	Ritorna la scheda di tutti i soldati(solo i soldati!!) presenti nell'AL
	 * @return String
	 */
	public String soldati();
	
	/**
	 * Ritorna le schede dei soldati che appartengono alla squadra 
	 * passata come parametro.
	 * @param String squadra
	 * @return	String
	 */
	public String soldati(String squadra);
	
	/**
	 * Ritorna la scheda di tutti i mezzi(solo i mezzi!!) presenti nell'AL
	 * @return String
	 */
	public String listaMezzi();
	
	/**
	 * Ritorna la scheda di tutti i mezzi presenti nell'AL
	 * @param int x
	 * @param int y
	 * @return	String
	 */
	public String listaUnitaCheRaggiungono(int x, int y); 
	
	
	/**
	 * Ritorna il conteggio di tutti i soldati presenti nell'AL	la cui potenza di fuoco
	 *  è maggiore della potenza passata come parametro
	 * @param int potenza
	 * @return int 
	 */
	public int nSoldatiPotenzaFuocoMin(int potenza);
	
	/**
	 * Ritornare la potenza di fuoco media tra tutti i soldati presenti nell'AL
	 * @return double
	 */
	public double potenzaFuocoMedia();
	
	/**Ritornare un AL contenente solo i mezzi il cui tipo corrisponde	
	 * al tipo passato come parametro
	 * 
	 * @param	String tipo
	 * @return	ArrayList<unita>
	 */
	 public ArrayList<Unita> mezzi(String tipo);
	 
	 
	 /**
	  * Ritorno un AL contenente, senza ripetizioni composto da:
	  * la lista della squadre: NB. Ogni posizione nell'AL sarà 
	  * il nome della squadra e quanti soldati	a quella squadra.
	  * 
	  * @return	ArrayList<String>
	  */
	 public ArrayList<String> conteggioSoldatiPerSquadra();
	 
	 /**
	  * Ritornare un AL ordinato in maniera crescente 
	  * 
	  * @param int x
	  * @param int y
	  * @return	ArrayList<Unita> 
	  */
	 public ArrayList<Unita> ordinaPerDistanzaDa(int x, int y);
}
