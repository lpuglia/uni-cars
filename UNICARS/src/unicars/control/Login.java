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
import unicars.utility.Messaggio;


/**
 * Servlet implementation class Login
 */
@SuppressWarnings("serial")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Operatore operatore = null; //inserire al posto di null la chiamata al db appena pronta
		String address;
		String not_found ="Utente non riconosciuto.";
		String found ="Benvenuto ";
		
		if(operatore == null ) {
			Messaggio messaggio = new Messaggio("Problemi col DB!");
			request.setAttribute("msg", messaggio);
			address = "index.jsp";
		}else
		if(operatore.getUsername() == null){
			Messaggio messaggio = new Messaggio(not_found);
			request.setAttribute("msg", messaggio);
			address = "index.jsp";
		} else {
			Messaggio messaggio = new Messaggio(found);
			request.setAttribute("msg", messaggio);
			HttpSession session = request.getSession();
			session.setAttribute("operatore", operatore);
			address = "index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
