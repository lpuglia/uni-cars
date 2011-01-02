package unicars.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.bean.Appuntamento;
import unicars.manager.AppuntamentoManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet VisualizzaAppuntamenti
 * Questa servlet restituisce la lista di appuntamenti da visualizzare
 * sfruttando la classe AppuntamentoManager.
 * 
 * @author Gianluigi Avella
 */

public class VisualizzaAppuntamenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppuntamentoManager ap = new AppuntamentoManager();
		ArrayList<Appuntamento> lista = ap.listaAppuntamenti();
		
		String azione = request.getParameter("azione");
				
		String address = "index.jsp";
		String not_found ="Appuntamenti non trovati.";
		String found ="Lista Appuntamenti";
		
		
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
				address = "index.jsp?id=modificaAppuntamento1";
			if(azione.equals("elimina"))
				address = "index.jsp?id=eliminaAppuntamento1";
			if(azione.equals("visualizza"))
				address = "index.jsp?id=visualizzaAppuntamenti";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
