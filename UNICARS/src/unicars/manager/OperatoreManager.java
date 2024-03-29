package unicars.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import unicars.bean.Operatore;

/** 
 * Classe che gestisce le interazioni con il database riguardanti gli Operatori.
 * Implementa l'interfaccia IOperatoreManager.
 * 
 * @author Michele Fratello
 */

public class OperatoreManager implements IOperatoreManager{

	private DBConnection db;
	private Connection conn;
	private boolean isConnected = false;
	public static final Operatore OPERATORE_VUOTO = new Operatore(null, null, null, null, null, null); 
	
	/**
	 * Costruttore della classe.
	 */
	public OperatoreManager()
	{
		try {
			db = new DBConnection();
			conn = db.connetti();
			if(conn != null)
				isConnected = true;
		}
		catch(java.lang.ClassNotFoundException err) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(err.getMessage());
			isConnected = false;
		} 
		catch(SQLException e) {
			System.err.print("SQLException: ");
			System.err.println(e.getMessage());
			isConnected = false;
		}
	}
	
	/**
	 * Ricerca all'interno del database tutte gli Operatori memorizzati.
	 * 
	 * @return Un'ArrayList contenente tutte gli Operatori memorizzati nel database.
	 */
	public ArrayList<Operatore> listaOperatori() {
		ArrayList<Operatore> lista = new ArrayList<Operatore>();
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM operatore";
		
		if(!isConnected) {
			System.err.println("OperatoreManager.listaOperatori() - nessuna connessione al db attiva!");
			return null;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				lista.add(new Operatore(rs.getString("nome"), 
										rs.getString("cognome"), 
										rs.getString("username"), 
										rs.getString("password"), 
										rs.getString("email"),
										rs.getString("gruppo")));
			}
		}
		catch(SQLException ex) {
			lista = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return lista;
	}

	/**
	 * Effettua una ricerca all'interno del database per uno specifico Operatore.
	 * 
	 * @param username Stringa contenete l'username dell'Operatore.
	 * @return L'oggetto Operatore in caso di esito positivo, null altrimenti.
	 */
	public Operatore cercaOperatore(String username) {
		
		Operatore o = OPERATORE_VUOTO;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM operatore WHERE username='" + username + "'";
		Pattern p = Pattern.compile("[a-zA-Z0-9!_-]{3,20}");
		Matcher m;
		
		if(!isConnected) {
			System.err.println("OperatoreManager.cercaOperatore() - nessuna connessione al db attiva!");
			return null;
		}
		
		if(username == null) {
			System.err.println("OperatoreManager.cercaOperatore() - username nullo non valido");
			return OPERATORE_VUOTO;
		}
		
		m = p.matcher(username);
		if(!m.matches()) {
			System.err.println("OperatoreManager.cercaOperatore() - username non valido: \"" + username + "\"");
			return OPERATORE_VUOTO;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				o = new Operatore(	rs.getString("nome"), 
									rs.getString("cognome"), 
									rs.getString("username"), 
									rs.getString("password"), 
									rs.getString("email"),
									rs.getString("gruppo"));
			}
		}
		catch(SQLException ex) {
			o = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return o;
	}

	/**
	 * Effettua l'operazione di login per un Operatore.
	 * 
	 * @param username Username dell'Operatore che tenta il login
	 * @param password Password dell'Operatore che tenta il login
	 */
	public Operatore loginOperatore(String username, String password) {
		Operatore o = OPERATORE_VUOTO;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM operatore WHERE username='" + username + "' AND password='" + password + "'";
		Pattern userP = Pattern.compile("[a-zA-Z0-9!_-]{3,20}");
		Pattern passP = Pattern.compile("[a-zA-Z0-9!_-]{6,10}");
		Matcher userM, passM;
				
		if(!isConnected) {
			System.err.println("OperatoreManager.loginOperatore() - nessuna connessione al db attiva!");
			return null;
		}
		
		if((username == null) || (password == null)) {
			System.err.println("OperatoreManager.loginOperatore() - valori nulli non ammessi per username o password");
			return OPERATORE_VUOTO;
		}
		
		userM = userP.matcher(username);
		passM = passP.matcher(password);
		
		if((!userM.matches()) || (!passM.matches())) {
			System.err.println("OperatoreManager.loginOperatore() - username o password non corretti!");
			return OPERATORE_VUOTO;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				o = new Operatore(	rs.getString("nome"), 
									rs.getString("cognome"), 
									rs.getString("username"), 
									rs.getString("password"), 
									rs.getString("email"),
									rs.getString("gruppo"));
			}
		}
		catch(SQLException ex) {
			o = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return o;
	}

}
