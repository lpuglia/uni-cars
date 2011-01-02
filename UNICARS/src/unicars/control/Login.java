package unicars.control;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unicars.bean.Operatore;
import unicars.manager.OperatoreManager;
import unicars.utility.Messaggio;

/**
 * Implementazione della servlet Login
 * Questa consente il login dell'operatore confrontando i dati registrati
 * nel database sfruttando la classe OperatoreManager.
 * Se l'operatore esiste lo salva in sessione.
 * 
 * @author Gianluigi Avella
 */

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		OperatoreManager op = new OperatoreManager();
		Operatore operatore = op.loginOperatore(login, password);
		operatore.setPassword("nascosta");
		String address;
		String not_found ="Utente non riconosciuto.";
		String found ="Benvenuto " + login;
		
		if(operatore == null ) {
			Messaggio messaggio = new Messaggio("Problemi col DB!");
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		}else
		if(operatore.getUsername() == null){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "redirect.jsp";
		} else {
			Messaggio messaggio = new Messaggio(found);
			request.setAttribute("msg", messaggio);
			HttpSession session = request.getSession();
			session.setAttribute("operatore", operatore);
			address = "redirect.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
