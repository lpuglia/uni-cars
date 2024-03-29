package unicars.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.manager.SegnalaInteresseManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet SegnalaInteresse
 * Questa servlet segnala un interesse e lo memorizza all'interno del database 
 * sfruttando la classe AppuntamentoManager.
 * 
 * @author Gianluigi Avella
 */

public class SegnalaInteresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		//int codice = 0;
		//String data = "";
		//String ora = "";
		String descrizione = request.getParameter("descrizione");
		String contatto = request.getParameter("contatto");
		//int stato = 0;
		
		//Appuntamento appuntamento = new Appuntamento(nome, cognome, codice, data, ora, descrizione, contatto, stato);
		//AppuntamentoManager ap = new AppuntamentoManager();
		//boolean inserito = ap.inserisciAppuntamento(appuntamento);
		SegnalaInteresseManager sim = new SegnalaInteresseManager();
		boolean inserito = sim.segnalaInteresse(nome, cognome, contatto, descrizione);
		String address;
		String not_found ="Impossibile segnalare interesse";
		String found ="Interesse segnalato";
		
		
		if(!inserito){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		} else {
			Messaggio messaggio = new Messaggio(found);
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
