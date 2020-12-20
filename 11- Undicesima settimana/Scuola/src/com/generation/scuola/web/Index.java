package com.generation.scuola.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.scuola.dao.DAOInsegnanti;
import com.generation.scuola.dao.DAOPersone;
import com.generation.scuola.dao.DAOStudenti;
import com.generation.scuola.entities.Persona;
import com.generation.scuola.entities.Studente;


@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*      
	 * D'ora in poi andremo a sviluppare i nostri progetti seguendo il patern      
	 * MVC. Un pattern è una soluzione ad un problema ricorrente. Con MVC      
	 * noi indichiamo la suddivisione del progamma in: Model View Controller      
	 * Model: tutta la parte di calcolo scritta in java (entities, dao ec..)      
	 * View: tutta la parte di front-end (html, css, javascript..)      
	 * Controller: 1 o più classi che si occupano di gestire le request che    
	 * arrivano all'applicazione e a preparare delle response aiutandosi       
	 * con il Model (la nostra Servlet è un Controller)      
	*/
	
	DAOPersone dp = DAOPersone.getInstance();
	DAOStudenti ds = DAOStudenti.getInstance();
	
	GestoreTemplate gt = new GestoreTemplate("C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\11- Undicesima settimana\\Scuola\\WebContent\\Template");
	
	
    public Index() {

    }
    
    // Ogni volta che viene eseguita una request, ovvero qualcuno richiama 
    // la pagina localhost:8080/Scuola/Index il metodo doGet viene eseguito
    // dall'inizio alla fine.
    // Questo metodo prende come parametri in ingresso una request e una response 
    // La request è già valorizzata, la response la dobbiamo valorizzare noi
    // in base a cosa l'utente ci sta chiedendo.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Con questa riga diciamo che la risposta avverrà in formato HTML
		response.setContentType("text/html");
		
		
		String comando = request.getParameter("comando");
		
		if(comando == null)
			comando = "home";
		
		String ris = gt.leggi("menu.html");
		
		switch(comando.toLowerCase())
		{
			case "home":
				ris += gt.leggi("home.html");
			break;
			case "elenco":
				ris += "Elenco delle persone: <br>";
				ris += gt.grafica("templatePersona.html", dp.elenco());
			break;
			
			// Vediamo i form
			
			case "formnuovapersona":
				ris += gt.leggi("formnuovapersona.html");
				break;
				
			case "nuovapersona":
				Persona pe = new Persona(
										0,
										request.getParameter("nome"),
										request.getParameter("cognome"),
										Date.valueOf(request.getParameter("dob")),
										request.getParameter("residenza")
										);
				if(dp.create(pe))
					ris += "Persona salvata!";
				else
					ris += "Errore nel salvataggio, controlla la console!";
				break;
				
			case "cerca":
				String r = request.getParameter("r") == null? "" : request.getParameter("r") ;
				
				ris += "Risultato della ricerca per '" + r + "': <br>";
				for(Persona p : DAOPersone.getInstance().cerca(r))
					ris += "<li>" + p.getCognome() + " " + p.getNome() + "</li>";
				ris += "</ul>";
			break;
			
			// Elenco studenti nel nuovo modo
			
			case "elencostudenti":
				ris += "Elenco degli studenti: <br>";
				ris += gt.grafica("templateStudente.html", ds.elenco());
			break;
			
			// Inserisci nuovo studente
			
			case "formnuovostudente":
				ris += gt.leggi("formnuovostudente.html");
				break;
				
			case "nuovostudente":
				Persona per = new Persona(
											0,
											request.getParameter("nome"),
											request.getParameter("cognome"),
											Date.valueOf(request.getParameter("dob")),
											request.getParameter("residenza")
											);
				if(dp.create(per))
					ris += "Persona salvata!";
				else
					ris += "Errore nel salvataggio, controlla la console!";
				
				Studente st = new Studente(
											dp.read("select * from persone where id = (select max(id) from persone)").get(0).getId(),
											request.getParameter("nome"),
											request.getParameter("cognome"),
											Date.valueOf(request.getParameter("dob")),
											request.getParameter("residenza"),
											Integer.parseInt(request.getParameter("classe")),
											request.getParameter("sezione"),
											Integer.parseInt(request.getParameter("votoita")),
											Integer.parseInt(request.getParameter("votomat")),
											Integer.parseInt(request.getParameter("votoing")),
											Integer.parseInt(request.getParameter("votosto"))
										);
				if(ds.create(st))
					ris += " Studente salvato!";
				else
					ris += " Errore nel salvataggio, controlla la console!";
				break;

			case "elencoins":
				ris += "Elenco degli insegnanti: <ul>";
				for(Persona p : DAOInsegnanti.getInstance().elenco())
					ris += "<li>" + p.toString() + "</li>";
				ris += "</ul>";
			break;
			default:
				ris = "Comando non riconosciuto";
		}
		
		/*
		ris += "<p>Elenco delle persone</p> <ul>";
		
		for(Persona p: dp.elenco())
			ris += "<li> " + p.getCognome() + " " + p.getNome() + "</li>";
		
		ris += "</ul>";
		*/
		
		
		response.getWriter().append(ris);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
