package unicars.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.bean.Veicolo;
import unicars.manager.VeicoloManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet VisualizzaVeicoli
 * Questa servlet restituisce la lista di veicoli da visualizzare
 * sfruttando la classe VeicoloManager.
 * 
 * @author Gianluigi Avella
 */

public class VisualizzaVeicoli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VeicoloManager ap = new VeicoloManager();
		ArrayList<Veicolo> lista = ap.listaVeicoli();
				
		String address;
		String not_found ="Veicoli non trovati.";
		String found ="Lista Veicoli";
		
		
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
			address = "index.jsp?id=visualizzaVeicoli";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
