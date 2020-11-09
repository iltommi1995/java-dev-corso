package interfacce;

import java.util.ArrayList;

public interface IScuola 
{
	// Siamo nella versione di Java 1.8
	// Fino alla versione 1.7, Java permetteva alle interfacce di contenere solo firme dei metodi
	// dalla versione 1.8 in avanti invece, oltre alle firme dei metodi, permette anche i cosiddetti
	// metodi di default
	// Un metodo di default è un metodo che viene implementato direttamente 
	// dall'interfaccia e che può essere richiamato dal main normalmente
	
	// Firma del metodo
	// IScuola otterà l'ArrayList dalla classe che deciderà di implementarla
	ArrayList<String> elenco();
	
	// Siccome do per scontato che se una classe implementa questa interfaccia, deve per forza
	// restituire un ArrayList<String> che si chiama elenco(), posso creare un metodo di default
	// che utilizza quel ArrayList:
	
	default String stampa() {
		String ris = "";
		for(String s : elenco()) 
			ris += s + "\n";
		return ris;
	}
	
	// Siccome elenco() corrisponderà a un ArrayList<String> posso sapere quanto è grande
	
	default int grandezza() {
		return elenco().size();
	}
}
