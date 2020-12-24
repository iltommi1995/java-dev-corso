package com.myproject.imdb.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.utility.entities.Entity;
import com.generation.utility.view.GestoreTemplate;
import com.myproject.imdb.dao.DAOFilm;
import com.myproject.imdb.entities.Film;
import com.myproject.imdb.entities.Genere;


public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestoreTemplate gt = new GestoreTemplate("C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\Ripasso\\Imdb\\WebContent\\WEB-INF\\components");
	
    public Index() {
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	DAOFilm df = DAOFilm.getInstance();
    	List<Entity> film;
    	
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
    				film = df.read("select * from film inner join prodotti on film.id = prodotti.id");
    				System.out.println("niente param");
    			}
    			else
    			{
    				film = df.read("select * from film inner join prodotti on film.id = prodotti.id where prodotti.titolo like ?", "%"+request.getParameter("titolo")+"%");
    				System.out.println("dentro all'else");
    			}
    				
    			request.setAttribute("film", film);
    			request.setAttribute("nav", nav);
    			request.getRequestDispatcher("film.jsp").forward(request, response);
    			break;
    		case "serietv":
    			request.setAttribute("nav", nav);
    			request.getRequestDispatcher("serietv.jsp").forward(request, response);
    			break;
    		case "films":
    			film = df.read("select * from film inner join prodotti on film.id = prodotti.id where film.id = ?", request.getParameter("fi"));
    			request.setAttribute("film", film);
    			request.getRequestDispatcher("films.jsp").forward(request, response);
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
