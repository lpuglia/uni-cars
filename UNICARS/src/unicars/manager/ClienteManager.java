package unicars.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import unicars.bean.Cliente;

/** 
 * Classe che gestisce le interazioni con il database riguardanti i Clienti.
 * Implementa l'interfaccia IClienteManager.
 * 
 * @author Michele Fratello
 */

public class ClienteManager implements IClienteManager{

	private DBConnection db;
	private Connection conn;
	private boolean isConnected = false;
	public static final Cliente CLIENTE_VUOTO = new Cliente(null, null, null, null, null, null, null, null); 

	
	/**Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari
	 * per stabilire una connessione con il database.
	 */
	public ClienteManager()
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
	 * Ricerca all'interno del database tutte i Clienti memorizzati.
	 * 
	 * @return Un'ArrayList contenente tutte i Clienti memorizzati nel database.
	 */
	public ArrayList<Cliente> listaClienti() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM cliente";
		
		if(!isConnected) {
			System.err.println("ClienteManager.listaClienti() - nessuna connessione al db attiva!");
			return null;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				lista.add(new Cliente(	rs.getString("nome"), 
										rs.getString("cognome"), 
										rs.getString("dataNascita"), 
										rs.getString("luogoNascita"), 
										rs.getString("codFis"),
										rs.getString("indirizzo"),
										rs.getString("email"),
										rs.getString("telefono")));
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
	 * Effettua una ricerca all'interno del database per uno specifico Cliente.
	 * 
	 * @param codFis Stringa contenete il codice fiscale del Cliente.
	 * @return L'oggetto Cliente in caso di esito positivo, null altrimenti.
	 */
	public Cliente cercaCliente(String codFis) {
		Cliente c = CLIENTE_VUOTO;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM cliente WHERE codFis='" + codFis + "'";
		Pattern p = Pattern.compile("^[A-Z]{6}[0-9]{2}[ABCDEHLMPRST]{1}[0-9]{2}([A-Z]{1}[0-9]{3})[A-Z]{1}$");
		Matcher m;
		
		if(!isConnected) {
			System.err.println("ClienteManager.cercaCliente() - nessuna connessione al db attiva!");
			return null;
		}
		
		if(codFis == null) {
			System.err.println("ClienteManager.cercaAppuntamento() - Codice Fiscale null non valido!");
			return CLIENTE_VUOTO;
		}
		
		m = p.matcher(codFis);
		if(!m.matches()) {
			System.err.println("ClienteManager.cercaAppuntamento() - Codice Fiscale non valido: \"" + codFis + "\"");
			return CLIENTE_VUOTO;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				c = new Cliente(rs.getString("nome"), 
								rs.getString("cognome"), 
								rs.getString("dataNascita"), 
								rs.getString("luogoNascita"), 
								rs.getString("codFis"),
								rs.getString("indirizzo"),
								rs.getString("email"),
								rs.getString("telefono"));
			}
		}
		catch(SQLException ex) {
			c = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return c;
	}

}
