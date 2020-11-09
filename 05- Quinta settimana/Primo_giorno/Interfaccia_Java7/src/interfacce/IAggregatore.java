package interfacce;

public interface IAggregatore {
	// Creiamo un nuovo package Interface nel nostro progetto
	// All'interno di Interfacce, creiamo un'interfaccia chiamata IAggregatore
	// Siamo in JAVA 1.7 e le interfacce di questa versione possono contenere 
	// solo firme dei metodi.
	// Un'interfaccia, indipendentemente dalla versione, è un CONTRATTO!
	// Un'interfaccia è un contratto che si stipula tra l'interfaccia e la classe che decide di 
	// implementarla.
	// La classe che decide di implementare l'interfaccia dovrà necessariamente implementare
	// tutte le firme in essa contenute
	// Il vantaggio è che  l'interfaccia comunicherà con il main e nasconderà tutto ciò che c'è 
	// dietro all'interfaccia, ossia il programma per intero!
	
	// IAggregatore contiene la firma del metodo scheda()
	// Tutti i metodi all'interno dell'interfaccia sono public
	// OGNI CLASSE CHE DECIDA DI IMPLEMENTARE IAggregatore sarà obblicata a implementare il metodo scheda()
	
	String scheda();
	
	
	// NOTA BENE: un'interfaccia non può essere istanziata.
	// non è possibile fare new quando si tratta delle interfacce!
}
