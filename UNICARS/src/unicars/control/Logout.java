package unicars.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unicars.utility.*;

/**
 * Implementazione della servlet Logout
 * Questa servlet rimuove tutto dalla sessione permettendo la disconnessione 
 * dell'utente che la invoca.
 * 
 * @author Gianluigi Avella
 */

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String goodbye = "Arrivederci alla prossima.";
		HttpSession session = request.getSession();
		session.invalidate();
		Messaggio messaggio = new Messaggio(goodbye);
		request.setAttribute("msg", messaggio);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("redirect.jsp");
		dispatcher.forward(request, response);
	}

}
