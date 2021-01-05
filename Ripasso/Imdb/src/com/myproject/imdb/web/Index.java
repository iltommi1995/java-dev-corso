package com.myproject.imdb.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.utility.database.Database;
import com.generation.utility.entities.Entity;
import com.generation.utility.view.GestoreTemplate;
import com.myproject.imdb.dao.Config;
import com.myproject.imdb.dao.DAOFilm;
import com.myproject.imdb.dao.DAOGenere;
import com.myproject.imdb.dao.DAORegista;
import com.myproject.imdb.entities.Film;
import com.myproject.imdb.entities.Genere;
import com.myproject.imdb.entities.Regista;
import com.mysql.jdbc.PreparedStatement;


public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestoreTemplate gt = new GestoreTemplate("C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\Ripasso\\Imdb\\WebContent\\WEB-INF\\components");
	
    public Index() {
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	DAOFilm df = DAOFilm.getInstance();
    	DAORegista dr = DAORegista.getInstance();
    	DAOGenere dg = DAOGenere.getInstance();
    	List<Entity> data;
    	
    	String route = request.getRequestURI().split("/")[2].toLowerCase();
    	String n = null;
    	if(request.getRequestURI().split("/").length == 4)
    		 n = request.getRequestURI().split("/")[3].toLowerCase();
    	String nav = gt.leggi("nav.html");
    	switch(route)
    	{
    		case "home":
    			
    			request.setAttribute("nav", nav);
    			
    			request.getRequestDispatcher("home.jsp").forward(request, response);
    			break;
    		case "film":
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
    			request.getRequestDispatcher("film.jsp").forward(request, response);
    			break;
    		case "serietv":
    			request.setAttribute("nav", nav);
    			request.getRequestDispatcher("serietv.jsp").forward(request, response);
    			break;
    		case "films":
    			data = df.read("select * from film inner join prodotti on film.id = prodotti.id where film.id = ?", request.getParameter("fi"));
    			request.setAttribute("film", data);
    			request.getRequestDispatcher("films.jsp").forward(request, response);
    			break;
    		case "addfilm":
    			data = dr.read("select * from registi inner join persone on registi.id = persone.id");
    			//System.out.println(request.getParameterValues("genere")[0] + " " + request.getParameterValues("genere")[1]);
    			request.setAttribute("registi", data);
    			request.setAttribute("nav", nav);
    			request.setAttribute("generi", dg.read("select * from generi"));
    			request.getRequestDispatcher("formfilm.jsp").forward(request, response);
    			break;
    		case "newfilm":
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
	    			data = df.read("select * from film inner join prodotti on film.id = prodotti.id where film.id = (select max(id) from film)");
	    			
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
	    			request.getRequestDispatcher("newfilm.jsp").forward(request, response);
    			}
    			break;
    		case "adddirector":
    			if(request.getQueryString() != null)
    			{
    				String[] prova = request.getQueryString().split("&");
        			request.setAttribute("prova", prova);
    			}
    			
    			request.getRequestDispatcher("formregista.jsp").forward(request, response);
    			break;
    		case "newdirector":
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
					
					data = df.read("select * from film inner join prodotti on film.id = prodotti.id where film.id = (select max(id) from film)");
					
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
    				request.getRequestDispatcher("newdirector.jsp").forward(request, response);
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
    				request.getRequestDispatcher("newdirector.jsp").forward(request, response);
    			}
    			break;
    	}
    	
    	System.out.println(request.getRequestURI());
    	
    	
    	
    	//response.sendRedirect(qui va messo il redirect);
    	/*
    	if(request.getRequestURI().equalsIgnoreCase("/Imdb/film"))
    	{
    		request.setAttribute("generi", li);
        	request.getRequestDispatcher("prova.jsp").forward(request, response);
    	}
    	
    	if(request.getRequestURI().equalsIgnoreCase("/Imdb/serie"))
    	{
        	request.getRequestDispatcher("serie.jsp").forward(request, response);
    	}
    	*/

    }
}
