package unicars.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.bean.Riparazione;
import unicars.manager.RiparazioneManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet VisualizzaRiparazioni
 * Questa servlet restituisce la lista di riparazioni da visualizzare
 * sfruttando la classe RiparazioniManager.
 * 
 * @author Gianluigi Avella
 */

public class VisualizzaRiparazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RiparazioneManager ap = new RiparazioneManager();
		ArrayList<Riparazione> lista = ap.listaRiparazioni();
				
		String address;
		String not_found ="Riparazioni non trovate.";
		String found ="Lista Riparazioni";
		
		
		if(lista == null ) {
			Messaggio messaggio = new Messaggio("Problemi col DB!");
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		}else
		if(lista.isEmpty()){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		} else {
			Messaggio messaggio = new Messaggio(found);
			request.setAttribute("msg", messaggio);
			request.setAttribute("lista", lista);
			address = "index.jsp?id=visualizzaRiparazioni";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
