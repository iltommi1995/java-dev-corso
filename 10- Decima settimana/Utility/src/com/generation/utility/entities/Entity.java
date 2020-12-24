package com.generation.utility.entities;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Entity 
{
	// La classe Entity è una classe ASTRATTA che contiene sempre una sola proprietà: ID.
	
	
	private int id;
	
	// Costruttore vuoto
	
	public Entity() {}

	// Costruttore con l'id
	
	public Entity(int id) {
		this.id = id;
	}
	
	// Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// toString
	
	public String toString() 
	{
		String ris = "******************\n";
		
		// Questo metodo ritorna il nome della classe sottoforma di String, si può usare
		// al posto di fare "instanceof"
		// Il metodo getClass() ci permette di sfruttare la Java Reflection, attraverso la quale
		// siamo in grado di fare dei ragionamenti sull'oggetto sul quale è stato chiamato, in 
		// questo caso, il metodo toString
		//
		// Importante ricordare che i metodi delle classi vengono applicati sul tupo concreto, non
		// su quello astratto. Quindi se ho: Entity f = new Smartphone(), questo metodo ritornerà la
		// String "Smartphone", non "Entity", perchè ritorna il tipo concreto.
		
		ris += getClass().getSimpleName() + "\n";
		
		Map<String,String> mappa = toMap();
		
		for(String chiave : mappa.keySet()) 
			ris += chiave + " : " + mappa.get(chiave) + "\n";
		
		ris += "******************\n";
		
		return ris;
	}
	
	
	/**
	 * Metodo che trasforma l'oggetto in una Map<String,String>
	 */
	
	public Map<String, String> toMap() 
	{
		Map<String,String> ris = new HashMap<String,String>();
		
		// Ciclo tutti i metodi
		
		for(Method m : getClass().getMethods()) 
		{
			// Tengo in considerazione solo quelli il cui nome inizia con "get", tranne il getClass
			
			if((m.getName().startsWith("get") || m.getName().startsWith("is")  ) && !m.getName().equals("getClass")) 
			{
				try 
				{
				// Substring ritorna una stringa con sottratte x lettere
				
					String chiave ="";
					if(m.getName().startsWith("get"))
						chiave = m.getName().substring(3).toLowerCase();
					else
						chiave = m.getName().substring(2).toLowerCase();
				
				// m.invoke() serve a invocare il metodo m, quindi a eseguirlo. Tuttavia dobbiamo passare
				// come parametro l'oggetto sul quale richiamare questo metodo. Passiamo l'oggetto "this".
				// Visto che è codice caldo dobbiamo metterlo in n try catch
				
				String valore = m.invoke(this) + "";
				
				ris.put(chiave, valore);
				} 
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return ris;
	}
	
	
	
	/**
	 * Questo metodo valorizza tutte le proprietà del nostro oggetto
	 * prendendo i valori dalla mappa passata come parametro
	 * @param mappa
	 */
	
	public void fromMap(Map<String,String> mappa) 
	{
		for(Method m : this.getClass().getMethods()) 
		{
			if(m.getName().startsWith("set") && m.getParameterCount() == 1)
			{
				String chiave = m.getName().substring(3).toLowerCase();
				
				if(!mappa.containsKey(chiave))
					// continue interrompe il giro di ciclo, passa al giro successivo
					continue;
				// Prendo il valore della mappa che dovrà essere inserito all'interno della
				// proprietà dell'oggetto
				String valore = mappa.get(chiave);
				// Prendo il tipo in cui dovrà essere convertito il valore
				String tipo = m.getParameters()[0].getType().getSimpleName().toLowerCase();
				
				try
				{
					switch(tipo) 
					{
						case "string":
							m.invoke(this, valore);
						break;
						case "int":
							m.invoke(this, Integer.parseInt(valore));
						break;
						case "double":
							m.invoke(this, Double.parseDouble(valore));
						break;
						case "date":
							m.invoke(this, Date.valueOf(valore));
						break;
						case "boolean":
							m.invoke(this, valore.equalsIgnoreCase("1") || valore.equalsIgnoreCase("true"));
						break;
						case "float":
							m.invoke(Float.parseFloat(valore));
							break;
					}
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
