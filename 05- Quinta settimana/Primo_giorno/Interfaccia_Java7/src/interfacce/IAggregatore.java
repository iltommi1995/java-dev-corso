package interfacce;

public interface IAggregatore {
	// Creiamo un nuovo package Interface nel nostro progetto
	// All'interno di Interfacce, creiamo un'interfaccia chiamata IAggregatore
	// Siamo in JAVA 1.7 e le interfacce di questa versione possono contenere 
	// solo firme dei metodi.
	// Un'interfaccia, indipendentemente dalla versione, � un CONTRATTO!
	// Un'interfaccia � un contratto che si stipula tra l'interfaccia e la classe che decide di 
	// implementarla.
	// La classe che decide di implementare l'interfaccia dovr� necessariamente implementare
	// tutte le firme in essa contenute
	// Il vantaggio � che  l'interfaccia comunicher� con il main e nasconder� tutto ci� che c'� 
	// dietro all'interfaccia, ossia il programma per intero!
	
	// IAggregatore contiene la firma del metodo scheda()
	// Tutti i metodi all'interno dell'interfaccia sono public
	// OGNI CLASSE CHE DECIDA DI IMPLEMENTARE IAggregatore sar� obblicata a implementare il metodo scheda()
	
	String scheda();
	
	
	// NOTA BENE: un'interfaccia non pu� essere istanziata.
	// non � possibile fare new quando si tratta delle interfacce!
}
