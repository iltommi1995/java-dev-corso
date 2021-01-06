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
import com.myproject.imdb.dao.DAOGenere;
import com.myproject.imdb.dao.DAORegista;
import com.myproject.imdb.entities.Film;

public class FilmResolver 
{
	// Pagina con l'elenco di tutti i film
	
	public static void film (HttpServletRequest request, HttpServletResponse response, String nav, DAOFilm df) throws ServletException, IOException
	{
		List<Entity> data;
		if(request.getParameter("titolo") == null)
		{
			data = df.read("select * from film inner join prodotti on film.id = prodotti.id");
			System.out.println("niente param");
		}
		else
		{
			data = df.read("select * from film inner join prodotti on film.id = prodotti.id where prodotti.titolo like ?", "%"+request.getParameter("titolo")+"%");
			System.out.println("dentro all'else");
		}
			
		request.setAttribute("film", data);
		request.setAttribute("nav", nav);
		request.getRequestDispatcher("jsp/film.jsp").forward(request, response);
	}
	
	// Pagina dei singoli film 
	
	public static void singleFilm (HttpServletRequest request, HttpServletResponse response, String nav, DAOFilm df) throws ServletException, IOException
	{
		List<Entity> data = df.read("select * from film inner join prodotti on film.id = prodotti.id where film.id = ?", request.getParameter("fi"));
		request.setAttribute("film", data);
		request.getRequestDispatcher("jsp/singlefilm.jsp").forward(request, response);
	}
	
	// Pagina del form per aggiungere film
	
	public static void addFilm (HttpServletRequest request, HttpServletResponse response, String nav, DAOFilm df, DAORegista dr, DAOGenere dg) throws ServletException, IOException
	{
		List<Entity> data = dr.read("select * from registi inner join persone on registi.id = persone.id");
		request.setAttribute("registi", data);
		request.setAttribute("nav", nav);
		request.setAttribute("generi", dg.read("select * from generi"));
		request.getRequestDispatcher("jsp/formfilm.jsp").forward(request, response);
	}
	
	// Route che crea il film
	
	public static void newFilm (HttpServletRequest request, HttpServletResponse response, String nav, DAOFilm df) throws ServletException, IOException
	{
		if(request.getParameter("regista").equalsIgnoreCase("nuovoRegista"))
		{
			response.sendRedirect("adddirector" +"?"+request.getQueryString());
		}
		else
		{
			Film f = new Film(
								0, 
								request.getParameter("titolo"), 
								Boolean.parseBoolean(request.getParameter("vedere")), 
								Boolean.parseBoolean(request.getParameter("visto")), 
								request.getParameter("imgpath"), 
								Integer.parseInt(request.getParameter("regista")), 
								Integer.parseInt(request.getParameter("durata")), 
								Date.valueOf(request.getParameter("data")),
								Boolean.parseBoolean(request.getParameter("oscar"))
							);
			String risp = df.create(f) ? "Film aggiunto" : "Errore nella creazione del  film";
			request.setAttribute("risp", risp);
			List<Entity> data = df.read("select * from film inner join prodotti on film.id = prodotti.id where film.id = (select max(id) from film)");
			
			if(request.getParameterValues("genere") != null)
			{
				for(int i = 0; i < request.getParameterValues("genere").length; i++)
				{
					if(Config.DB.update("insert into generiprodotti(idprodotto,idgenere) values (?,?)", data.get(0).getId()+"", request.getParameterValues("genere")[i]))
						System.out.println("Generi aggiunti");
					else
						System.out.println("Problema ad aggiungere generi");
				}
			}
			request.getRequestDispatcher("jsp/newfilm.jsp").forward(request, response);
		}
	}
	
	// Pagina dei singoli film 
	
	public static void deleteFilm (HttpServletRequest request, HttpServletResponse response, String nav, DAOFilm df) throws ServletException, IOException
	{
		if(df.delete(Integer.parseInt(request.getParameter("id"))))
		{
			System.out.println("Film eliminato");
			response.sendRedirect("jsp/film");
		}
	}
}
