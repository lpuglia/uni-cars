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
	private boolean isConnected;
	public static final Riparazione RIPARAZIONE_VUOTO = new Riparazione(-1, null, null, -1, null, null);
	
	/**Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari
	 * per stabilire una connessione con il database.
	 */
	public RiparazioneManager()
	{
		try {
			db = new DBConnection();
			conn = db.connetti();
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
		
		if(!isConnected) return null;
		
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
		
		if((codice < 0) || (codice > 1e10)) return null;
		if(!isConnected) return null;
		
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
