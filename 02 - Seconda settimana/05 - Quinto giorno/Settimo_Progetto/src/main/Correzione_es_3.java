package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Correzione_es_3 {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Leggere un file formattato in questo modo:
		//nome,cognome,matematica-8/matematica-10/italiano-6/italiano-7
		//Stampare la scheda dello studente in questo modo:
		//Nome: valore
		//Cognome: valore
		//Media italiano: valore 
		//Media matematica: valore
		//CONSIGLIO: iniziate con un uno studente e poi eventualmente aggiungeteli.
		
		String percorso = "C:\\\\Users\\\\duckf\\\\Desktop\\\\Corso Java\\\\Workspace\\\\02 - Seconda settimana\\\\05 - Quinto giorno\\\\Settimo_Progetto\\\\src\\\\res\\\\SplitEsercizio3.txt";
		Scanner file = new Scanner(new File(percorso));
		
		String[] riga;
		String[] rigaVoti;
		double[] votiIta;
		double[] votiMate;
		String nome;
		String cognome;
		int contatoreVotiIta = 0;
		double mediaIta;
		int contatoreVotiMate = 0;
		double mediaMate;
		String elenco = "";
		
		while(file.hasNextLine())
		{
			//Per evitare che si sommino le medie, per sicurezza, ad ogni ciclo
			//le riporto a zero!
			mediaIta = 0;
			mediaMate = 0;
			
			//Splitto la prima volta e trovo:
			//riga[0] = "James"
			//riga[1] = "Bond"
			//riga[2] = "matematica-8/matematica-10/italiano-6/italiano-7"
			riga = file.nextLine().split(",");
			nome = riga[0];
			cognome = riga[1];
			
			//Splitto riga[2] per il simbolo "/" così ottengo i voti
			//rigaVoti[0] = "matematica-8";
			//rigaVoti[1] = "matematica-10";
			//rigaVoti[2] = "italiano-6";
			//rigaVoti[3] = "italiano-7"
			rigaVoti = riga[2].split("/");
			
			//Splitto rigaVoti per il simbolo "-" così da ottenere:
			//voto[0] = "matematica";
			//voto[1] = "8";
			String[] voto ;
			votiIta = new double[rigaVoti.length];
			contatoreVotiIta = 0;
			votiMate = new double[rigaVoti.length];
			contatoreVotiMate = 0;
			for(int i = 0; i < rigaVoti.length; i++)
			{
				voto = rigaVoti[i].split("-");
				if(voto[0].equalsIgnoreCase("italiano"))
				{
					votiIta[contatoreVotiIta] = Double.parseDouble(voto[1]);
					contatoreVotiIta++;
				}
				if(voto[0].equalsIgnoreCase("matematica"))
				{
					votiMate[contatoreVotiMate] = Double.parseDouble(voto[1]);
					contatoreVotiMate++;
				}
			}//Fine di for
			
			//Quello che viene calcolato qui si riferisce al singolo studente
			for(int i = 0; i < votiIta.length; i++)
				mediaIta += votiIta[i];
			
			for(int i = 0; i < votiMate.length; i++)
				mediaMate += votiMate[i];
			
			mediaIta /= contatoreVotiIta;
			mediaMate /= contatoreVotiMate;
			
			elenco	+=	"Nome: "			+	nome		+	"\n"	+
						"Cognome: "			+	cognome		+	"\n"	+
						"Media italiano: "	+	mediaIta	+	"/10\n"	+
						"Media matematica: "+	mediaMate	+	"/10"	+	
						"\n------------------------------\n";
		}//Fine di while
		
		System.out.println(elenco);
		file.close();

	}

}
