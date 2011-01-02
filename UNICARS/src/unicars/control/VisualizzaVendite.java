package unicars.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.bean.Vendita;
import unicars.manager.VenditaManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet VisualizzaVendite
 * Questa servlet restituisce la lista di vendite da visualizzare
 * sfruttando la classe VenditaManager.
 * 
 * @author Gianluigi Avella
 */

public class VisualizzaVendite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VenditaManager ap = new VenditaManager();
		ArrayList<Vendita> lista = ap.listaVendite();
				
		String azione = request.getParameter("azione");
		String address = "index.jsp";
		String not_found ="Vendite non trovate.";
		String found ="Lista Vendite";
		
		
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
			if(azione.equals("modifica"))
				address = "index.jsp?id=modificaVendita1";
			if(azione.equals("elimina"))
				address = "index.jsp?id=eliminaVendita1";
			if(azione.equals("visualizza"))
				address = "index.jsp?id=visualizzaVendite";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
