package unicars.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import unicars.bean.Veicolo;

/** 
 * Classe che gestisce le interazioni con il database riguardanti i Veicoli.
 * Implementa l'interfaccia IVeicoloManager.
 * 
 * @author Michele Fratello
 */

public class VeicoloManager implements IVeicoloManager{

	private DBConnection db;
	private Connection conn;
	private boolean isConnected = false;
	public static final Veicolo VEICOLO_VUOTO = new Veicolo(null, null, null, null, null, null, null, null, null); 
	
	/**
	 * Costruttore della classe.
	 */
	public VeicoloManager()
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
	 * Ricerca all'interno del database tutte i Veicoli memorizzati.
	 * 
	 * @return Un'ArrayList contenente tutte i Veicoli memorizzati nel database.
	 */
	public ArrayList<Veicolo> listaVeicoli() {
		ArrayList<Veicolo> lista = new ArrayList<Veicolo>();
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM veicolo";
		
		if(!isConnected) {
			System.err.println("VeicoloManager.cercaVeicolo() - nessuna connessione al db attiva!");
			return null;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				lista.add(new Veicolo(	rs.getString("tipo"), 
										rs.getString("targa"), 
										rs.getString("telaio"), 
										rs.getString("marca"), 
										rs.getString("modello"),
										rs.getString("allestimento"),
										rs.getDouble("prezzoA"),
										rs.getDouble("prezzoV"),
										rs.getString("colore")));
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
	 * Effettua una ricerca all'interno del database per uno specifico Veicolo.
	 * 
	 * @param targa Stringa contenete il codice del Veicolo.
	 * @return L'oggetto Veicolo in caso di esito positivo, null altrimenti.
	 */
	public Veicolo cercaVeicolo(String targa) {
		Veicolo v = VEICOLO_VUOTO;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM veicolo WHERE targa='" + targa + "'";
		Pattern p = Pattern.compile("[A-Z0-9]{1,8}");
		Matcher m;
		
		if(!isConnected) {
			System.err.println("VeicoloManager.cercaVeicolo() - nessuna connessione al db attiva!");
			return null;
		}
		
		if(targa == null) {
			System.err.println("VeicoloManager.cercaVeicolo() - targa nulla non valida");
			return VEICOLO_VUOTO;
		}
		
		m = p.matcher(targa);
		if(!m.matches()) {
			System.err.println("VeicoloManager.cercaVeicolo() - targa non ammessa: \"" + targa + "\"");
			return VEICOLO_VUOTO;
		}
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				v = new Veicolo(rs.getString("tipo"), 
								rs.getString("targa"), 
								rs.getString("telaio"), 
								rs.getString("marca"), 
								rs.getString("modello"),
								rs.getString("allestimento"),
								rs.getDouble("prezzoA"),
								rs.getDouble("prezzoV"),
								rs.getString("colore"));
			}
		}
		catch(SQLException ex) {
			v = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return v;
	}

}
