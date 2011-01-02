package unicars.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.bean.Veicolo;
import unicars.manager.VeicoloManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet CercaVeicolo
 * Questa servlet cerca un veicolo all'interno del database dato un codice 
 * sfruttando la classe VeicoloManager.
 * 
 * @author Gianluigi Avella
 */

public class CercaVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codice = request.getParameter("codice");
		String azione = request.getParameter("azione");
		
		VeicoloManager ve = new VeicoloManager();
		Veicolo veicolo = ve.cercaVeicolo(codice);

		String address = "index.jsp";
		String not_found ="Veicolo non trovato.";
		String found ="Veicolo trovato.";
		
		
		if(veicolo == null ) {
			Messaggio messaggio = new Messaggio("Problemi col DB!");
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		}else
		if(veicolo.getMarca() == null){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		} else {
			Messaggio messaggio = new Messaggio(found);
			request.setAttribute("msg", messaggio);
			request.setAttribute("veicolo", veicolo);
			if(azione.equals("modifica"))
				address = "index.jsp?id=modificaVeicolo2";
			if(azione.equals("elimina"))
				address = "index.jsp?id=eliminaVeicolo2";
			if(azione.equals("visualizza"))
				address = "index.jsp?id=segnalaInteresse1";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
