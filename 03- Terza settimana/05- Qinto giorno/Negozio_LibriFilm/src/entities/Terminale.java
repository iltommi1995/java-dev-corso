package entities;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terminale {
	public String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\03- Terza settimana\\05- Qinto giorno\\Negozio_LibriFilm\\src\\res\\CatalogoNegozio.txt";
	
	public String output() throws FileNotFoundException {
		Scanner tastiera = new Scanner(System.in);
		Negozio store = new Negozio(path);
		String output ="";
		

			System.out.println(
								"\nScegli l'operazione da svolgere:\n"						+
								"1- Stampa l'elenco di tutti i prodotti\n"					+
								"2- Stampa l'elenco di tutti i film\n"						+
								"3- Stampa l'elenco di tutti i libri\n"						+
								"4- Stampa la media delle pagine dei libri\n"				+
								"5- Stampa la media della pagine dei libri sci-fi\n"		+
								"6- Stampa la durata media dei film in ore\n"				+
								"7- Stampa la durata totale dei film sci-fi\n"				+
								"8- Stampa l'elenco dei libri che fanno parte di una serie"	);
			int scelta = Integer.parseInt(tastiera.nextLine());
			switch(scelta) {
				case 1:
					output = store.elencoProdotti();
				break;
				case 2:
					output = store.elencoFilm();
				break;
				case 3:
					output = store.elencoLibri();
				break;
				case 4:
					output = store.mediaPagTot();
				break;	
				case 5:
					output = store.mediaPagSciFi();
				break;
				case 6:
					output = store.mediaDurataFilm();
				break;
				case 7:
					output = store.durataTotFilmSciFi();
				break;
				case 8:
					output = store.libriSerie();
				break;
				default:
					output = "\nL'opzione da te scelta non è presente.";
			}
		return output;
	}
}
