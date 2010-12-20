package unicars.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import unicars.bean.Cliente;

/** 
 * Classe che gestisce le interazioni con il database riguardanti i Clienti.
 * Implementa l'interfaccia IClienteManager.
 * 
 * @author Michele Fratello
 */

public class ClienteManager implements IClienteManager{

	private Connection conn;
	private boolean isConnected;
	private static final Cliente CLIENTE_VUOTO = new Cliente(null, null, null, null, null, null, null, null); 

	
	/**Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari
	 * per stabilire una connessione con il database.
	 */
	public ClienteManager(DBConnection c)
	{
		try {
			conn = c.connetti();
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
		
		if(!isConnected) return null;
		
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
		
		if(!isConnected) return null;
		
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
