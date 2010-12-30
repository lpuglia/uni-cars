package unicars.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import unicars.bean.Appuntamento;

/** 
 * Classe che gestisce le interazioni con il database riguardanti gli Appuntamenti.
 * Implementa l'interfaccia IAppuntamentoManager.
 * 
 * @author Michele Fratello
 */

public class AppuntamentoManager implements IAppuntamentoManager{

	private DBConnection db;
	private Connection conn;
	private boolean isConnected;
	public static final Appuntamento APPUNTAMENTO_VUOTO = new Appuntamento(null, null, -1, null, null, null, null, -1); 

	
	/**
	 * Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari
	 * per stabilire una connessione con il database.
	 */
	public AppuntamentoManager()
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
	 * Ricerca all'interno del database tutte gli Appuntamenti memorizzati.
	 * 
	 * @return Un'ArrayList contenente tutte gli Appuntamenti memorizzati nel database.
	 */
	public ArrayList<Appuntamento> listaAppuntamenti() {
		ArrayList<Appuntamento> lista = new ArrayList<Appuntamento>();
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM appuntamento";
		
		if(!isConnected) return null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				lista.add(new Appuntamento(	rs.getString("nome"), 
											rs.getString("cognome"), 
											rs.getInt("codice"), 
											rs.getString("data"), 
											rs.getString("ora"),
											rs.getString("descrizione"),
											rs.getString("contatto"),
											rs.getInt("stato")));
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
	 * Effettua una ricerca all'interno del database per uno specifico Appuntamento.
	 * 
	 * @param codice Stringa contenete il codice dell'Appuntamento.
	 * @return L'oggetto Appuntamento in caso di esito positivo, null altrimenti.
	 */
	public Appuntamento cercaAppuntamento(int codice) {
		Appuntamento a = APPUNTAMENTO_VUOTO;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM appuntamento WHERE codice='" + codice + "'";
		
		if((codice < 0) || (codice > 10e10)) return null;
		
		if(!isConnected) return null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				a = new Appuntamento(	rs.getString("nome"), 
										rs.getString("cognome"), 
										rs.getInt("codice"), 
										rs.getString("data"), 
										rs.getString("ora"),
										rs.getString("descrizione"),
										rs.getString("contatto"),
										rs.getInt("stato"));
			}
		}
		catch(SQLException ex) {
			a = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return a;
	}

	/**
	 * Inserisce un nuovo Appuntamento all'interno del database.
	 * 
	 * @param a L'Appuntamento da memorizzare nel database.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean inserisciAppuntamento(Appuntamento a) {
		boolean ret = false;
		Statement stmt;
		String query = "INSERT INTO appuntamento(	nome, " +
													"cognome, " +
													"data, " +
													"ora, " +
													"descrizione, " +
													"contatto, " +
													"stato) " +
													"VALUES (	'" + a.getNome() +
															"', '" + a.getCognome() +
															"', '" + a.getData() +
															"', '" + a.getOra() +
															"', '" + a.getDescrizione() +
															"', '" + a.getContatto() +
															"', '" + a.getStato() + "')";
		
		if(a == null || a == APPUNTAMENTO_VUOTO || !verificaAppuntamento(a)) return false;
		if(!isConnected) return false;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			ret = true;
		}
		catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return ret;
	}

	/**
	 * Modifica i dati di un Appuntamento memorizzato nel database.
	 * 
	 * @param v L'Appuntamento contenente i dati modificati.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean modificaAppuntamento(Appuntamento a) {
		boolean ret = false;
		Statement stmt;
		String query = 	"UPDATE appuntamento SET nome='" + a.getNome() + 
						"', cognome='" + a.getCognome() + 
						"', data='" + a.getData() +
						"', ora='" + a.getOra() + 
						"', descrizione='" + a.getDescrizione() + 
						"', contatto='" + a.getContatto() + 
						"', stato='" + a.getStato() + 
						"' WHERE codice='" + a.getCodice() + "'";
		
		if(a == null || a == APPUNTAMENTO_VUOTO || !verificaAppuntamento(a)) return false;
		if(!isConnected) return false;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			ret = true;
		}
		catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return ret;
	}

	/**
	 * Rimuove un Appuntamento dal database
	 * 
	 * @param codice Il codice dell'Appuntamento che deve essere eliminato.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean eliminaAppuntamento(int codice) {
		boolean ret = false;
		Statement stmt;
		String query = "DELETE FROM appuntamento WHERE codice='" + codice + "'";
		
		if((codice < 0) || (codice > 10e10)) return false;
		if(!isConnected) return false;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			ret = true;
		}
		catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return ret;
	}

	private boolean verificaAppuntamento(Appuntamento a) {
		Pattern p;
		Matcher m;
		
		p = Pattern.compile("[a-zA-Z]{3,30}");
		m = p.matcher(a.getNome());
		if(!m.matches()) {System.out.println("AppuntamentoManager.verificaAppuntamento - fallita validazione nome: " + a.getNome());return false;} 
		
		p = Pattern.compile("[a-zA-Z]{3,30}");
		m = p.matcher(a.getCognome());
		if(!m.matches()) {System.out.println("AppuntamentoManager.verificaAppuntamento - fallita validazione cognome: " + a.getCognome());return false;}
		
		p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)[0-9]{2}$");
		m = p.matcher(a.getData());
		if(!m.matches()) {System.out.println("AppuntamentoManager.verificaAppuntamento - fallita validazione data: " + a.getData());return false;}
		
		p = Pattern.compile("^([0-1][0-9]|2[0-3]):([0-5][0-9])$");
		m = p.matcher(a.getOra());
		if(!m.matches()) {System.out.println("AppuntamentoManager.verificaAppuntamento - fallita validazione ora: " + a.getOra());return false;}
		
		p = Pattern.compile("[a-zA-Z0-9 ]*");
		m = p.matcher(a.getDescrizione());
		if(!m.matches()) {System.out.println("AppuntamentoManager.verificaAppuntamento - fallita validazione descrizione: " + a.getDescrizione());return false;}
		
		p = Pattern.compile("[a-zA-Z0-9 ]*");
		m = p.matcher(a.getContatto());
		if(!m.matches()) {System.out.println("AppuntamentoManager.verificaAppuntamento - fallita validazione contatto: " + a.getContatto());return false;}
		
		if((a.getStato() < 0) || (a.getStato() > 2)) {System.out.println("AppuntamentoManager.verificaAppuntamento - fallita validazione stato: " + a.getStato());return false;}
		
		return true;
	}
}
