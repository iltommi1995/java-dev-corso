package com.generation.circo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.circo.dao.DAOAnimali;
import com.generation.circo.dao.DAOStaff;
import com.generation.circo.entities.Factory;
import com.generation.utility.entities.Entity;
import com.generation.utility.view.GestoreTemplate;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\11- Undicesima settimana\\Circo\\WebContent\\template";
	GestoreTemplate gs = new GestoreTemplate(path);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		// La struttura che andiamo a fare all'interno del doGet, con lo switch-case
		// si chiama FRONT CONTROLLER
		
		String comando = request.getParameter("comando");
		
		if(comando == null)
			comando = "home";
		
		String risposta = gs.leggi("menu.html");
		
		switch(comando.toLowerCase())
		{
			case "home":
				risposta = gs.leggi("home.html");
				break;
			case "elencostaff":
				String staffGraficati = gs.grafica("templateStaff.html", DAOStaff.getInstance().elenco());
				risposta = gs.leggi("elencostaff.html").replace("[elenco]", staffGraficati);
				break;
			case "formnuovostaff":
				risposta = gs.leggi("formNuovoStaff.html");
				break;
			case "nuovostaff":
				Entity nuovoStaff = Factory.makeRequest("staff", request.getParameterMap());
				System.out.println(nuovoStaff.toString());
				if(DAOStaff.getInstance().create(nuovoStaff))
					risposta = "Salvataggio ok";
				else
					risposta = "Errore nel salvataggio";
				break;
			case "cancellastaff":
				if(DAOStaff.getInstance().delete(Integer.parseInt(request.getParameter("id"))))
					risposta = "Cancellazione ok";
				else
					risposta = "Errore nella cancellazione";
				break;
			
			// Animali
				
			case "elencoanimali":
				String staffGraficatiAnimali = gs.grafica("templateAnimali.html", DAOAnimali.getInstance().elenco());
				risposta = gs.leggi("elencoAnimali.html").replace("[elenco]", staffGraficatiAnimali);
				break;
			case "formnuovoanimale":
				risposta = gs.leggi("formNuovoAnimale.html");
				break;
				
			case "nuovoanimale":
				Entity nuovoAnimale = Factory.makeRequest("animale", request.getParameterMap());
				System.out.println(nuovoAnimale.toString());
				if(DAOAnimali.getInstance().create(nuovoAnimale))
					risposta = "Salvataggio ok";
				else
					risposta = "Errore nel salvataggio";
				break;
				
			case "cancellaanimale":
				if(DAOAnimali.getInstance().delete(Integer.parseInt(request.getParameter("id"))))
					risposta = "Cancellazione ok";
				else
					risposta = "Errore nella cancellazione";
				break;
			default:
				risposta = gs.leggi("paginaNonTrovata.html");	
		}
		response.getWriter().append(gs.leggi("menu.html"));
		response.getWriter().append(risposta);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
