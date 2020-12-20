package interfaces;

import java.util.ArrayList;
import java.util.Map;

import entities.Film;

public interface IBlockBuster 
{
	/**
	 * Ritorna la durata media di tutti i film
	 * @return double
	 */
	public double avglength();
	
	/**
	 * Ritorna la Lista dei film con la durata massima
	 * @return ArrayList<Film>
	 */
	public ArrayList<Film> maxlength();
	
	/**
	 * Ritorna la Lista dei film con la durata minima
	 * @return ArrayList<Film>
	 */
	public ArrayList<Film> minlength();
	
	/**
	 * Ritorna i film con una popolarità superiore a 85
	 * @return ArrayList<Film>
	 */
	public ArrayList<Film> mostpopular();
	
	/**
	 * Ritorna la lista dei titoli dei film che hanno vinto un award
	 * @return ArrayList<String>
	 */
	public ArrayList<String> award();
	
	/**
	 * Ritorna una lista che contiene solo i nominativi del tipo
(actor, actress o director) passato come parametro
	 * @param String type
	 * @return ArrayList<String>
	 */
	public ArrayList<String> type(String type);
	
	/**
	 * Ritorna una lista che contiene tutti i film in cui è
presente la persona corrispondente al nome cercato
	 * @param String name
	 * @return ArrayList<Film>
	 */
	public ArrayList<Film> search(String name);
	
	/**
	 * Ritorna l’elenco di tutti i generi, senza ripetizioni,
e il numero di film di quel genere presenti nella lista(Es: Horror 2, Drama 3, ecc)
	 * @return Map<String,Integer>
	 */
	public Map<String,Integer> subjectcount();
	
	/**
	 * Ritorna l’elenco di tutti i generi, senza ripetizioni, e il
prezzo medio per genere di tutti i film(Es: Horror 6.9, Drama 3.3, ecc)
	 * @return Map<String,Double>
	 */
	public Map<String,Double> avgprice();
	
	/**
	 * Ritorna il nome e lo stipendio delle singole persone,
	 * @return ArrayList<String>
	 */
	public ArrayList<String> salary();
	
	/**
	 * Ritorna i film in cui non sono presenti persone di tipo actress
all’interno del cast
	 * @return ArrayList<Film>
	 */
	public ArrayList<Film> noWoman();
	
	/**
	 * Ritorna i film in cui non è presente nel cast il tipo director ma è
presente il tipo actress
	 * @return ArrayList<Film>
	 */
	public ArrayList<Film> free();
	
	/**
	 * Ritorna i film in cui sono presenti solo persone di tipo actress
all’interno del cast
	 * @return ArrayList<Film>
	 */
	public ArrayList<Film> noMan();
}
