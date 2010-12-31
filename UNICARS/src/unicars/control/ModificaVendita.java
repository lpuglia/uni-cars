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
 * Servlet implementation class ModificaVendita
 */
public class ModificaVendita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codice = Integer.parseInt(request.getParameter("codice"));
		String codFis = request.getParameter("codFis");
		String telaio = request.getParameter("telaio");
		String data = request.getParameter("data");
		String note = request.getParameter("note");
		
		Vendita vendita = new Vendita(codice, codFis, telaio, data, note);
		VenditaManager ve = new VenditaManager();
		boolean modificata = ve.modificaVendita(vendita);
		String address;
		String not_found ="Vendita non modificata.";
		String found ="Vendita modificata.";
		
		
		if(!modificata){
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
