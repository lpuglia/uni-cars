package unicars.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import unicars.bean.Riparazione;

/** 
 * Classe che gestisce le interazioni con il database riguardanti le Riparazioni.
 * Implementa l'interfaccia IRiparazioneManager.
 * 
 * @author Michele Fratello
 */

public class RiparazioneManager implements IRiparazioneManager{

	private DBConnection db;
	private Connection conn;
	private boolean isConnected = false;
	public static final Riparazione RIPARAZIONE_VUOTO = new Riparazione(-1, null, null, -1, null, null);
	
	/**
	 * Costruttore della classe.
	 */
	public RiparazioneManager()
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
	 * Ricerca all'interno del database tutte le Riparazioni memorizzate.
	 * 
	 * @return Un'ArrayList contenente tutte le Riparazioni memorizzate nel database.
	 */
	public ArrayList<Riparazione> listaRiparazioni() {
		ArrayList<Riparazione> lista = null;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM riparazione";
		
		if(!isConnected) {
			System.err.println("RiparazioneManager.listaRiparazioni() - nessuna connessione al db attiva!");
			return null;
		}
		
		try {
			lista = new ArrayList<Riparazione>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				lista.add(new Riparazione(	rs.getInt("codice"), 
											rs.getString("telaio"), 
											rs.getString("descrizione"), 
											rs.getInt("stato"), 
											rs.getString("dataInizio"),
											rs.getString("dataFine")));
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
	 * Effettua una ricerca all'interno del database per una specifica Riparazione.
	 * 
	 * @param codice Stringa contenete il codice della Riparazione.
	 * @return L'oggetto Riparazione in caso di esito positivo, null altrimenti.
	 */
	public Riparazione cercaRiparazione(int codice) {
		Riparazione r = null;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM riparazione WHERE codice='" + codice + "'";
		
		if(!isConnected) {
			System.err.println("RiparazioneManager.cercaRiparazione() - nessuna connessione al db attiva!");
			return null;
		}
		
		if((codice < 0) || (codice > 999999)) {
			System.err.println("RiparazioneManager.cercaRiparazione() - codice non valido: \"" + codice + "\"");
			return RIPARAZIONE_VUOTO;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				r = new Riparazione(rs.getInt("codice"), 
									rs.getString("telaio"), 
									rs.getString("descrizione"), 
									rs.getInt("stato"), 
									rs.getString("dataInizio"),
									rs.getString("dataFine"));
			}
		}
		catch(SQLException ex) {
			r = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return r;
	}

}
