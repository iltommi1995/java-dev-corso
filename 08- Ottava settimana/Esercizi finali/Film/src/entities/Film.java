package entities;

import java.util.ArrayList;

public class Film extends Entity
{
	private int year;
	private int length;
	private String title;
	private String subject;
	private int popularity;
	private boolean award;
	private ArrayList<Person> cast;
	
	public Film(int id, int year, int length, String title, String subject, int popularity, boolean award, ArrayList<Person> p)
	{
		super(id);
		setYear(year);
		setLength(length);
		setTitle(title);
		setSubject(subject);
		setPopularity(popularity);
		setAward(award);
		setP(p);		
	}//fine costruttore

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int lenght) {
		this.length = lenght;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public boolean isAward() {
		return award;
	}

	public void setAward(boolean award) {
		this.award = award;
	}

	public ArrayList<Person> getP() {
		return cast;
	}

	public void setP(ArrayList<Person> p) {
		this.cast = p;
	}
	
	
	public double priceticket() 
	{
		double ris= 5;
		//se award e' vero aggiungo uno altrimenti tolgo -0.2
		ris += award ? 1 : -0.2; 
		
		//se la popolarita' e' maggiore di 70 aggiungo 5
		if(popularity > 70)
			ris += 0.5;
		//se la popolarita' e' minore di 20 tolto 0.2
		if(popularity < 20)
			ris -= 0.2;
		
		//switch che controlla l'anno e modifica il prezzo del biglietto
		switch(year)
		{
		case 1980 :
		case 1977 :
		case 1995 : 
			ris += 0.5;
		break;
		case 1985 :
		case 1967 :
		case 1978 :
			ris += 0.3;
		break;
		case 1996 :
			ris -= 0.2;
		break;
		}
		return ris;
	}
	
	public String toString()
	{
		String	ris = "";
			ris = super.toString() + 
								"Titolo film: " 			+ title			+ "\n" 	+
								"Anno di uscita: " 			+ year 			+ "\n" 	+
								"Lunghezza film: " 			+ length 		+ "\n" 	+
								"Genere: " 					+ subject 		+ "\n" 	+
								"Popolarita': " 			+ popularity 	+ "\n" 	+
								"Prezzo del biglietto e': " + priceticket() + "$" 	+ "\n" ;	
			//se e' vero stampo questo 
			if(award)
				ris += "Questo film ha vinto uno o piu' premi\n";
			//se e' faslso stampo questo
			else
				ris += "Questo film non ha vinto nessun premio\n";
			// prendo il to string di Person e lo stampo
			for(Person p : cast)
				ris += p.getType() + ": " + p.getName() + "\n";
		return ris;
	}
	
}
