package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import interfaces.IBlockBuster;
import utility.Vik;

public class Blockbuster implements IBlockBuster {

      
	private ArrayList<Person> people;
	private ArrayList<Film> films;


	public Blockbuster(String path) throws FileNotFoundException {

		Scanner file = new Scanner(new File(path));


		people = new ArrayList<Person>();
		films = new ArrayList<Film>();
		
		String[] riga;

		Film f;
		Person p;

		while(file.hasNextLine()) {
			ArrayList<Person> peoplefilm= new ArrayList<Person>();
			riga = file.nextLine().split(",");
			String [] personariga = riga[5].split("-");
			
			for (int i=0; i<personariga.length; i++)
			{		
				String[] persona = personariga[i].split(":");
				if(Vik.controlloPerson( persona[0],
										persona[1]	)) 
				{
					int count =0;
					for(Person per: people ) {
						
						if(per.name.equalsIgnoreCase(persona[0]))
							count++;
					}//enf for
					p = new Person ( persona[0],
									persona[1]);
					if(count==0) {
						people.add(p);
					}//end if 
					peoplefilm.add(p);

				}//end if
			}///end for

			/*
			 * id, year, length, title, subject, name:actor-name:actress-name:director, popularity,award*/

			// riga file che inizia con id 

			if(Vik.controlloFilm( 	Integer.parseInt(riga[0]),
									Integer.parseInt(riga[1]), // year
									Integer.parseInt(riga[2]), //lenght
									riga[3], // title
									riga[4], // subject 
									Integer.parseInt(riga[6]), // popularity
									riga[7])) 
			{
				f = new Film  (   Integer.parseInt(riga[0]), //id
						Integer.parseInt(riga[1]), // year
						Integer.parseInt(riga[2]), //lenght
						riga[3], // title
						riga[4], // subject 
						Integer.parseInt(riga[6]), // popularity
						riga[7].equalsIgnoreCase("no") ? false : true, //award
								peoplefilm //controllare come riceve l' AL ??? 
						);
				films.add(f);
			}//end if
		}//end while
		file.close();

	}//end constructor aggregatore

	//- double avglength() → Ritorna la durata media di tutti i film
	public double avglength() {
		double lengthTot=0;
		for(Film f : films) {
				lengthTot += f.getLength();
		}//end for 
		return   (lengthTot / films.size()); //numero delle ore dei fims / tutti i films
	}//end avglenght()

	//- AL<Film> maxlength() → Ritorna la Lista dei film con la durata massima,

	public ArrayList<Film> maxlength() {

		ArrayList <Film> ris = new ArrayList<Film>();
		double maxlength = Double.MIN_VALUE;

		for(Film f : films )
				if(f.getLength() > maxlength) {

					maxlength = f.getLength();
				}//end for
		for(Film f : films) {
			
			if(f.getLength() == maxlength)
				ris.add(f);
		}//end for
	return ris; //la lista dei film con durata max 
}// end method maxlenght

//- AL<Film> minlength() → Ritorna la Lista dei film con la durata minima,
public ArrayList<Film> minlength() {

	ArrayList <Film> ris = new ArrayList<Film>();
	double minlength = Double.MAX_VALUE;

	for(Film f : films )
		if(f.getLength() < minlength) {

			minlength = f.getLength();
		}//end for
for(Film f : films) {
	
	if(f.getLength() == minlength)
		ris.add(f);
}//end for
return ris;
}

// - AL<Film> moustpopular() → Ritorna i film con una popolarità superiore a 85,

public ArrayList<Film> mostpopular() {
	ArrayList<Film> ris= new ArrayList<Film>();

	for(Film f : films ) {
		if(f.getPopularity()> 85)
			ris.add(f);
	}//end for

	return ris;
}//end method mostpopular



@Override
public ArrayList<String> award(){
    ArrayList<String> ris= new ArrayList<String>();
       for(Film f: films) {
        if(f.isAward())
            ris.add(f.getTitle());
    }
    return ris;
}



@Override
public ArrayList<String> type(String type) {
    ArrayList<String> ris = new ArrayList<String>();
    for(Person p : people)
    {
    if(type.equalsIgnoreCase(p.type))
        ris.add(p.name);
    }
    return ris;
}



public ArrayList<Film> search(String name) {
    ArrayList<Film> ris = new ArrayList<Film>();

            for ( Film f : films ) 
            {
                for(Person p: f.getP())
                    if(name.equalsIgnoreCase(p.name))
                        ris.add(f);
             }

    return ris;
}//end method search



@Override
public Map<String, Integer> subjectcount() {
	
	Map<String, Integer> soluzione = new LinkedHashMap<String, Integer>();
	ArrayList<String> generi = new ArrayList<String>();
	String genere = "";
	int counterGenere = 0;
	
	// lista di tutti i generi
	
	for(Film f : films) {
		if(!f.getSubject().equalsIgnoreCase(genere)) {
			genere = f.getSubject();
			int counter = 0;
			for(String g : generi) {
				if(genere.equalsIgnoreCase(g)) 
					counter ++;
			}
			if(counter == 0)
				generi.add(genere);
		}
	}
	
	// Film per genere
	
	for(String g : generi) {
		counterGenere = 0;
		for(Film f : films) {
			if (g.equalsIgnoreCase(f.getSubject()))
				counterGenere++;
		}
		soluzione.put(g, counterGenere);
	}
	return soluzione;
}



@Override
public Map<String, Double> avgprice() {
	Map<String, Double> soluzione = new LinkedHashMap<String, Double>();
	ArrayList<String> generi = new ArrayList<String>();
	String genere = "";
	int counterGenere = 0;
	double prezzoTot = 0;
	
	// lista di tutti i generi
	
	for(Film f : films) {
		if(!f.getSubject().equalsIgnoreCase(genere)) {
			genere = f.getSubject();
			int counter = 0;
			for(String g : generi) {
				if(genere.equalsIgnoreCase(g)) 
					counter ++;
			}
			if(counter == 0)
				generi.add(genere);
		}
	}
	
	// Film per genere
	
	for(String g : generi) {
		counterGenere = 0;
		prezzoTot = 0;
		for(Film f : films) {
			if (g.equalsIgnoreCase(f.getSubject())) {
				prezzoTot += f.priceticket();
				counterGenere++;
			}
		}
		soluzione.put(g, (prezzoTot/counterGenere));
	}
	
	return soluzione;
}

@Override
public ArrayList<String> salary() {
    ArrayList<String> ris = new ArrayList<String>();
    String add = "";
    int stipendio = 1200;

    int count = 0;
    int countPremi = 0;
    double percento = 0;
    for(Person p : people)
    {
        stipendio = 1200;
        count = 0;
        countPremi = 0;
        percento = 0;
        for(Film f : films)
        {
            for(Person per : f.getP())
                if(per.getName().equalsIgnoreCase(p.getName()))
                {
                    count++;
                    if(f.isAward())
                        countPremi++;

                    percento += (f.priceticket()/100) * 15;
                }
        }
    switch(p.getType())
    {
    case "actor"         :
    case "actress"         :
        stipendio += 50 * count + (countPremi * 10) + percento;
        add = stipendio + " " + p.name ;
        ris.add(add);
    break;
    case "director"        :
        stipendio += 100 * count + (countPremi * 5) + percento ;
        add = stipendio + " " + p.name ;
        ris.add(add);
    break;
    }

    }//fine for

    return ris;
}

@Override
public ArrayList<Film> noWoman() {
	// Ritorna i film in cui non sono presenti persone di tipo actress all�interno del cast
	
	ArrayList<Film> risposta = new ArrayList<Film>();
	int donne = 0;
	for(Film f : films) {
		donne = 0;
		for(Person p : f.getP()) {
			if(p.getType().equalsIgnoreCase("actress")) 
				donne++;
		}
		if(donne == 0) {
			risposta.add(f);
		}
	}
	
	return risposta;
}

@Override
public ArrayList<Film> free() {
	// Ritorna i film in cui non � presente nel cast il tipo director ma � presente il tipo actress

	ArrayList<Film> risposta = new ArrayList<Film>();
	int donne = 0;
	int director = 0;
	for(Film f : films) {
		director = 0;
		donne = 0;
		for(Person p : f.getP()) {
			if(p.getType().equalsIgnoreCase("actress")) 
				donne++;
			if(p.getType().equalsIgnoreCase("director")) 
				director++;
		}
		if(donne != 0 && director == 0) {
			risposta.add(f);
		}
	}
	
	return risposta;
}

@Override
public ArrayList<Film> noMan() {
    ArrayList<Film> noman = new ArrayList<Film>();
    int attori;
    int registi;
    for(Film f : films)
    {
        attori = 0;
        registi = 0;
        for(Person p : f.getP()) {
            if(p.getType().equalsIgnoreCase("actor")) 
                attori++;
        }
        for(Person p : f.getP()) {
            if(p.getType().equalsIgnoreCase("director")) 
                registi++;
        }
        if(attori == 0 && registi == 0) {
            noman.add(f);
        }
    }
    return noman;
}


/*
 *e abbia come proprietà:
e implementi da un'interfaccia i seguenti metodi:
- AL<Film> moustpopular() → Ritorna i film con una popolarità superiore a 85,
- AL<String> award() → Ritorna la lista dei titoli dei film che hanno vinto un award,
- AL<String> type(String type) → Ritorna una lista che contiene solo i nominativi del tipo
(actor, actress o director) passato come parametro
- AL<Film>search(String name) → Ritorna una lista che contiene tutti i film in cui è
presente la persona corrispondente al nome cercato
- Map<String, Integer> subjectcount() → Ritorna l’elenco di tutti i generi, senza ripetizioni,
e il numero di film di quel genere presenti nella lista(Es: Horror 2, Drama 3, ecc)
- Map<String,Double> avgprice() → Ritorna l’elenco di tutti i generi, senza ripetizioni, e il
prezzo medio per genere di tutti i film(Es: Horror 6.9, Drama 3.3, ecc)
- AL<String> salary() → Ritorna il nome e lo stipendio delle singole persone, calcolando lo
stipendio nel seguente modo:
stipendio base: 1200;

+50 * n film seguiti se sono actor/actress, +100*n film seguiti se è director;
+5 * n award vinti se sono director, +10 * n award vinti si sono actor/actress;
+15% del prezzo del biglietto dei film in cui sono presenti;

- AL<Film> nowoman() → Ritorna i film in cui non sono presenti persone di tipo actress
all’interno del cast
- AL<Film> free() → Ritorna i film in cui non è presente nel cast il tipo director ma è
presente il tipo actress
- AL<Film> noman() → Ritorna i film in cui sono presenti solo persone di tipo actress 
 * 
 * 
 */

}
