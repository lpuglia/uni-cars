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
 * Servlet implementation class CercaVendita
 */
public class CercaVendita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codice = Integer.parseInt(request.getParameter("codice"));
		String azione = request.getParameter("azione");
		
		VenditaManager ve = new VenditaManager();
		Vendita vendita = ve.cercaVendita(codice);
		
		String address = "index.jsp";
		String not_found ="Vendita non trovata.";
		String found ="Vendita trovata.";
		
		
		if(vendita == null ) {
			Messaggio messaggio = new Messaggio("Problemi col DB!");
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		}else
		if(vendita.getCodFis() == null){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		} else {
			Messaggio messaggio = new Messaggio(found);
			request.setAttribute("msg", messaggio);
			request.setAttribute("vendita", vendita);
			if(azione.equals("modifica"))
				address = "index.jsp?id=modificaVendita2";
			if(azione.equals("elimina"))
				address = "index.jsp?id=eliminaVendita2";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
