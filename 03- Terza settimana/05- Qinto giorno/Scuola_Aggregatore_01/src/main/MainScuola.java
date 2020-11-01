package main;
import java.io.FileNotFoundException;
import entities.Scuola;

public class MainScuola {
	public static void main(String[] args) throws FileNotFoundException {

		String percorso = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\03- Terza settimana\\05- Qinto giorno\\Scuola_Aggregatore_01\\src\\res\\ElencoScuolaAggregatore.txt";
		Scuola soluzione = new Scuola(percorso);
		System.out.println(soluzione.elencoPersone());
	}
}
