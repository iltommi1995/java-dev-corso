package com.myproject.imdb.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.utility.view.GestoreTemplate;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestoreTemplate gt = new GestoreTemplate("C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\Ripasso\\Imdb\\WebContent\\WEB-INF\\template");
	private static String stylePath = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\Ripasso\\Imdb\\WebContent\\WEB-INF\\css\\style.css";
	
	
    public Index() {
    }
    
    private String getStyle(String path) throws FileNotFoundException {
    	Scanner file = new Scanner(new File(path));
    	
    	String ris ="";
    	
    	while(file.hasNextLine())
    		ris += file.nextLine();
    	file.close();
    	return ris;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String route = request.getParameter("route");
		
		String style = getStyle(stylePath);
		
		
		if(route == null)
			route = "home";
		
		String ris = "";
		
		switch(route.toLowerCase())
		{
			case "home":
				ris += "<html><head><title>"+route.toLowerCase()+"</title><style>" + style + "</style></head><body>";
				ris += "<h1>Questa è la home</h1>";
				ris += "</body></html>";
				break;
			case "generi":
				ris += "Generi";
				ris += "<br><img src='WebContent/img/interrotto.jpg' />";
				break;
		}
		response.getWriter().append(ris);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
