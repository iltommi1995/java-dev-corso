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
    	
    	String route = request.getRequestURI().split("/")[2].toLowerCase();
    	
    	String n = null;
    	if(request.getRequestURI().split("/").length == 4)
    		 n = request.getRequestURI().split("/")[3].toLowerCase();
    	
    	String nav = gt.leggi("nav.html");
    	switch(route)
    	{
    		// Home page
    		case "home":
    			request.setAttribute("nav", nav);
    			request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
    			break;
    			
    		// Film CRUD
    		case "film":
    			FilmResolver.film(request, response, nav, df);
    			break;
    		case "singlefilm":
    			FilmResolver.singleFilm(request, response, nav, df);
    			break;
    		case "addfilm":
    			FilmResolver.addFilm(request, response, nav, df, dr, dg);
    			break;
    		case "newfilm":
    			FilmResolver.newFilm(request, response, nav, df);
    			break;
    		case "deletefilm":
    			FilmResolver.deleteFilm(request, response, nav, df);
    			break;
    			
    		// Director CRUD
    		case "adddirector":
    			DirectorResolver.addDirector(request, response, nav);
    			break;
    		case "newdirector":
    			DirectorResolver.newDirector(request, response, nav, dr, df);
    			break;
    			
    		// Serie Tv CRUD
    		case "serietv":
    			request.setAttribute("nav", nav);
    			request.getRequestDispatcher("jsp/serietv.jsp").forward(request, response);
    			break;
    	}
    	System.out.println(request.getRequestURI());
    }
}
