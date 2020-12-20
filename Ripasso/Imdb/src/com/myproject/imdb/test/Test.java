package com.myproject.imdb.test;

import java.sql.Date;

import com.generation.utility.entities.Entity;
import com.myproject.imdb.dao.DAOFilm;
import com.myproject.imdb.dao.DAOProdotto;
import com.myproject.imdb.dao.DAOSerieTv;
import com.myproject.imdb.entities.Film;
import com.myproject.imdb.entities.Prodotto;
import com.myproject.imdb.entities.SerieTv;

public class Test {

	public static void main(String[] args) 
	{
		DAOProdotto dp = DAOProdotto.getInstance();
		
		DAOSerieTv df = DAOSerieTv.getInstance();
		
		//for(Entity r : df.read("select * from serietv inner join prodotti on prodotti.id = serietv.id"))
		//	System.out.println(r);
		
		
		//SerieTv f = new SerieTv(25, "Tdfsdfdfsdf", true, false, Date.valueOf("2000-02-02"), Date.valueOf("2020-02-02"), 400, false);

		if(df.delete(25))
			System.out.println("modificato");
		else
			System.out.println("Errore"); 
	}
}
