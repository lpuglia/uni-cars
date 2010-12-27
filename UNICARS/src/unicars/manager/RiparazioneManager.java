package unicars.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import unicars.bean.Riparazione;

/** 
 * Classe che gestisce le interazioni con il database riguardanti le Riparazioni.
 * Implementa l'interfaccia IRiparazioneManager.
 * 
 * @author Michele Fratello
 */

public class RiparazioneManager implements IRiparazioneManager{

	private Connection conn;
	private boolean isConnected;
	
	/**Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari
	 * per stabilire una connessione con il database.
	 */
	public RiparazioneManager()
	{
		try {
			conn = DBConnection.connetti();
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
				lista.add(new Riparazione(	rs.getString("codice"), 
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
	public Riparazione cercaRiparazione(String codice) {
		Riparazione r = null;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM riparazione WHERE codice='" + codice + "'";
		Pattern p = Pattern.compile("[a-zA-Z0-9]{1,10}");
		Matcher m;
		
		m = p.matcher(codice);
		if(!m.matches()) return null;
		if(!isConnected) return null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				r = new Riparazione(rs.getString("codice"), 
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
