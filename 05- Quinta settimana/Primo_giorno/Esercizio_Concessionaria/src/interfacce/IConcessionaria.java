package interfacce;

import java.util.ArrayList;
import java.util.Map;

import entities.Prodotto;

public interface IConcessionaria 
{	
	// Firme dei metodi
	
	public ArrayList<Prodotto> listaCompleta();
	
	public ArrayList<Prodotto> listaMoto();
	
	public ArrayList<Prodotto> listaVecchie();
	
	public String maxDistanza();
	
	public ArrayList<Prodotto> autoSuper();
	
	public ArrayList<Prodotto> cercaCategoria(String categoria);
	
	public Map<String,Integer> frequenza();
	
	public String cercaMarca(String marca);
	
	public ArrayList<Prodotto> ordinati();
}
