package unicars.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.manager.AppuntamentoManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet EliminaAppuntamento
 * Questa servlet elimina un appuntamento all'interno del database dato un codice 
 * sfruttando la classe AppuntamentoManager.
 * 
 * @author Gianluigi Avella
 */

public class EliminaAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codice = Integer.parseInt(request.getParameter("codice"));
		
		AppuntamentoManager ap = new AppuntamentoManager();
		boolean eliminato = ap.eliminaAppuntamento(codice);
		String address;
		String not_found ="Appuntamento non eliminato.";
		String found ="Appuntamento eliminato.";
		
		
		if(!eliminato){
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
