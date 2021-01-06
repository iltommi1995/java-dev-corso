package com.myproject.imdb.web;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.utility.entities.Entity;
import com.myproject.imdb.dao.Config;
import com.myproject.imdb.dao.DAOFilm;
import com.myproject.imdb.dao.DAORegista;
import com.myproject.imdb.entities.Film;
import com.myproject.imdb.entities.Regista;

public class DirectorResolver 
{
	// Pagina del form per aggiungere nuovo regista
	
	public static void addDirector (HttpServletRequest request, HttpServletResponse response, String nav) throws ServletException, IOException
	{
		request.setAttribute("nav", nav);
		if(request.getQueryString() != null)
		{
			String[] film = request.getQueryString().split("&");
			request.setAttribute("film", film);
		}
		
		request.getRequestDispatcher("jsp/formregista.jsp").forward(request, response);
	}
	
	// Route che crea il regista e nel caso anche il film
	
	public static void newDirector (HttpServletRequest request, HttpServletResponse response, String nav, DAORegista dr, DAOFilm df) throws ServletException, IOException
	{
		if(request.getParameter("regista") != null)
		{
			// Aggiunge regista
			
			Regista r = new Regista(
					0, 
					request.getParameter("nome"), 
					request.getParameter("cognome"), 
					Date.valueOf(request.getParameter("dobregista")), 
					request.getParameter("nazionalita"), 
					request.getParameter("imgregista"), 
					Boolean.parseBoolean(request.getParameter("oscarregia")), 
					Boolean.parseBoolean(request.getParameter("baftarregia")), 
					null
				);
			String risp = dr.create(r) ? "Regista aggiunto" : "Errore nella creazione del regista";
		
			// Aggiunge film
			
			Film f = new Film(
					0, 
					request.getParameter("titolo").replace("+", " "), 
					Boolean.parseBoolean(request.getParameter("vedere")), 
					Boolean.parseBoolean(request.getParameter("visto")), 
					request.getParameter("imgpath"), 
					dr.read("select * from persone inner join registi on registi.id = persone.id where persone.id = (select max(id) from persone)").get(0).getId(), 
					Integer.parseInt(request.getParameter("durata")), 
					Date.valueOf(request.getParameter("data")),
					Boolean.parseBoolean(request.getParameter("oscar"))
				);
			risp += df.create(f) ? "  Film aggiunto" : "   Errore nella creazione del  film";
			
			List<Entity> data = df.read("select * from film inner join prodotti on film.id = prodotti.id where film.id = (select max(id) from film)");
			
			if(request.getParameterValues("genere") != null)
			{
				for(int i = 0; i < request.getParameterValues("genere").length; i++)
				{
					if(Config.DB.update("insert into generiprodotti(idprodotto,idgenere) values (?,?)", data.get(0).getId()+"", request.getParameterValues("genere")[i]))
						risp += "     Generi aggiunti";
					else
						risp += "     Problema ad aggiungere i generi";
				}
			}
			
			// Risposta finale
			
			request.setAttribute("risp", risp);
			request.getRequestDispatcher("jsp/newdirector.jsp").forward(request, response);
		}
		else
		{
			Regista r = new Regista(
					0, 
					request.getParameter("nome"), 
					request.getParameter("cognome"), 
					Date.valueOf(request.getParameter("dobregista")), 
					request.getParameter("nazionalita"), 
					request.getParameter("imgregista"), 
					Boolean.parseBoolean(request.getParameter("oscarregia")), 
					Boolean.parseBoolean(request.getParameter("baftarregia")), 
					null
				);
			String risp = dr.create(r) ? "Regista aggiunto" : "Errore nella creazione del regista";
			request.setAttribute("risp", risp);
			request.getRequestDispatcher("jsp/newdirector.jsp").forward(request, response);
		}
	}
}
