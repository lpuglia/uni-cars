package unicars.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unicars.bean.Appuntamento;
import unicars.manager.AppuntamentoManager;
import unicars.utility.Messaggio;

/**
 * Servlet implementation class CercaAppuntamento
 */
public class CercaAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codice = Integer.parseInt(request.getParameter("codice"));
		
		AppuntamentoManager ap = new AppuntamentoManager();
		Appuntamento appuntamento = ap.cercaAppuntamento(codice);
		
		String address;
		String not_found ="Appuntamento non trovato.";
		String found ="Appuntamento trovato.";
		
		
		if(appuntamento == null ) {
			Messaggio messaggio = new Messaggio("Problemi col DB!");
			request.setAttribute("msg", messaggio);
			address = "index.jsp";
		}else
		if(appuntamento.getCognome() == null){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "index.jsp";
		} else {
			Messaggio messaggio = new Messaggio(found);
			request.setAttribute("msg", messaggio);
			request.setAttribute("appuntamento", appuntamento);
			address = "index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
