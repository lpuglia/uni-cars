package unicars.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/** 
 * Classe che gestisce le interazioni con il database riguardanti le segnalazioni di Interesse.
 * Implementa l'interfaccia IAppuntamentoManager.
 * 
 * @author Michele Fratello
 */

public class SegnalaInteresseManager implements ISegnalaInteresseManager{

	private Connection conn;
	private boolean isConnected;
	
	/**Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari
	 * per stabilire una connessione con il database.
	 */
	public SegnalaInteresseManager(DBConnection c)
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
	 * Inserisce una segnalazione di Interesse sottoforma di Appuntamento all'interno del database.
	 * 
	 * @param nome Il nome dell'utente che segnala interesse.
	 * @param cognome Il cognome dell'utente che segnala interesse.
	 * @param contatto Il contatto dell'utente che segnala interesse.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean segnalaInteresse(String nome, String cognome, String contatto) {
		boolean ret = false;
		Statement stmt;
		String query = "INSERT INTO appuntamento (nome, " +
													"cognome, " +
													"contatto, " +
													"data, " +
													"ora, " +
													"stato) " +
													"VALUES (" +
													"'" + nome + "', " +
													"'" + cognome + "', " +
													"'" + contatto + "', " +
													"'0', " +
													"'0', " +
													"'0'" + ")";
		
		if(!isConnected) return false;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			ret = true;
		}
		catch(SQLException ex) {
			ret = false;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return ret;
	}

}
