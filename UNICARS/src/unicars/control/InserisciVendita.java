package unicars.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.bean.Vendita;
import unicars.manager.VenditaManager;
import unicars.utility.Messaggio;

/**
 * Servlet implementation class InserisciVendita
 */
public class InserisciVendita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codice = 0;
		String codFis = request.getParameter("codFis");
		String telaio = request.getParameter("telaio");
		String data = request.getParameter("data");
		String note = request.getParameter("note");
		
		Vendita vendita = new Vendita(codice, codFis, telaio, data, note);
		VenditaManager ve = new VenditaManager();
		boolean inserito = ve.inserisciVendita(vendita);
		String address;
		String not_found ="Vendita non inserita.";
		String found ="Vendita inserita.";
		
		
		if(!inserito){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "index.jsp";
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
