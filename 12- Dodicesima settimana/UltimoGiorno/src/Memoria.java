public class Memoria 
{	
	public static void main(String[] args)
	{
		Persona p1 = new Persona("Pino", "Pane");
		
		Persona p2 = p1;
		
		p2.cognome = "Struzzo";
		
		System.out.println(p1);
		
		p1 = null;
		p2 = null;
		
		// Nel momento in cui entrambe p1 e p2 diventano null io perdo la possibilit� di utilizzare 
		// ancora il mio oggetto Persona. quando un oggetto della memoria non pu� pi� 
		// essere richiamato si dice che � "out of scope". nel momento in cui un oggetto cnon �
		// pi� richiamabile in nessun modo, diventa automaticamente eleggibile per il garbage collector.
		
		// Il garbage collector � lo spazzino di java che va a cancellare dalla memoria tutti quegli 
		// oggetti che non sono pi� raggiungibili.
		
		// Il garbage collector opera quando ha voglia, se vogliamo possiamo incentivarlo a fare 
		// un giro di pulizia con:
		
		System.gc();
		
		// Questo metodo manda un campanello di allarme al GC. Tuttavia non � detto che partir�.
	}
}


class Persona
{
	String nome;
	String cognome;
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
}
