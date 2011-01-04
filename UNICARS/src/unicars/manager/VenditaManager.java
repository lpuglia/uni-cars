package unicars.manager;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import unicars.bean.Vendita;
import java.sql.*;

/** 
 * Classe che gestisce le interazioni con il database riguardanti le Vendite.
 * Implementa l'interfaccia IVenditaManager.
 * 
 * @author Michele Fratello
 */

public class VenditaManager implements IVenditaManager{
	
	private DBConnection db;
	private Connection conn;
	private boolean isConnected = false;
	public static final Vendita VENDITA_VUOTO = new Vendita(-1, null, null, null, null); 
	
	/**Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari.
	 * per stabilire una connessione con il database.
	 */
	public VenditaManager() {
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
	 * Ricerca all'interno del database tutte le Vendite memorizzate.
	 * 
	 * @return Un'ArrayList contenente tutte le Vendite memorizzate nel database.
	 */
	public ArrayList<Vendita> listaVendite() {
		ArrayList<Vendita> lista = new ArrayList<Vendita>();
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM vendita";
		
		if(!isConnected) {
			System.err.println("VenditaManager.listaVendite() - nessuna connessione al db attiva!");
			return null;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				lista.add(new Vendita(	rs.getInt("codice"), 
										rs.getString("codFis"), 
										rs.getString("telaio"), 
										rs.getString("data"), 
										rs.getString("note")));
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
	 * Effettua una ricerca all'interno del database per una specifica Vendita.
	 * 
	 * @param codice Stringa contenete il codice della Vendita.
	 * @return L'oggetto Vendita in caso di esito positivo, null altrimenti.
	 */
	public Vendita cercaVendita(int codice) {
		Vendita v = VENDITA_VUOTO;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM vendita WHERE codice='" + codice + "'";

		if(!isConnected) {
			System.err.println("VenditaManager.cercaVendita() - nessuna connessione al db attiva!");
			return null;
		}

		if((codice < 0) || (codice > 999999)) {
			System.err.println("VenditaManager.cercaVendita() - codice non valido: \"" + codice + "\"");
			return VENDITA_VUOTO;
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				v = new Vendita(rs.getInt("codice"), 
								rs.getString("codFis"), 
								rs.getString("telaio"), 
								rs.getString("data"), 
								rs.getString("note"));
			}
		}
		catch(SQLException ex) {
			v = null;
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return v;
	}

	/**
	 * Inserisce una nuova Vendita all'interno del database.
	 * 
	 * @param v La Vendita da memorizzare nel database.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean inserisciVendita(Vendita v) {
		boolean ret = false;
		Statement stmt;
		String query = "INSERT INTO vendita(codFis, " +
											"telaio, " +
											"data, " +
											"note) " +
											"VALUES (	'" + v.getCodFis() +
														"', '" + v.getTelaio() +
														"', '" + v.getData() + 
														"', '" + v.getNote() + "')";
		
		if(!isConnected) {
			System.err.println("VenditaManager.inserisciVendita() - nessuna connessione al db attiva!");
			return false;
		}
		
		if(v == null || v == VENDITA_VUOTO || !verificaVendita(v)) {
			System.err.println("VenditaManager.inserisciVendita() - la Vendita passata non è valida");
			return false;
		}
		
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
	 * Modifica i dati di una Vendita memorizzata nel database.
	 * 
	 * @param v La Vendita contenente i dati modificati.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean modificaVendita(Vendita v) {
		boolean ret = false;
		Statement stmt;
		String query = 	"UPDATE vendita SET codFis='" + v.getCodFis() + 
						"', telaio='" + v.getTelaio() + 
						"', data='" + v.getData() + 
						"', note='" + v.getNote()+ 
						"' WHERE codice='" + v.getCodice() + "'";
		
		if(!isConnected) {
			System.err.println("VenditaManager.modificaVendita() - nessuna connessione al db attiva!");
			return false;
		}

		if(v == null || v == VENDITA_VUOTO || !verificaVendita(v)) {
			System.err.println("VenditaManager.modificaVendita() - la Vendita passata non è valida");
			return false;
		}
		
		if((v.getCodice() < 0) || v.getCodice() > 999999) {
			System.err.println("VenditaManager.modificaVendita() - codice non valido: \"" + v.getCodice() + "\"");
			return false;
		}
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			ret = true;
		}
		catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
			return false;
		}
		return ret;
	}
	
	/**
	 * Rimuove una Vendita dal database
	 * 
	 * @param codice Il codice della Vendita che deve essere eliminata.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean eliminaVendita(int codice) {
		boolean ret = false;
		Statement stmt;
		String query = "DELETE FROM vendita WHERE codice='" + codice + "'";

		if(!isConnected) {
			System.err.println("VenditaManager.eliminaVendita() - nessuna connessione al db attiva!");
			return false;
		}
		
		if((codice < 0) || (codice > 999999)){
			System.err.println("VenditaManager.eliminaVendita() - codice non valido: \"" + codice + "\"");
			return false;
		}
		
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
	 * Metodo che verifica la validità della Vendita passato in input
	 * 
	 * @param v Vendita da verificare
	 * @return true se la Vendita è valida, false altrimenti
	 */
	private boolean verificaVendita(Vendita v) {
		Pattern p;
		Matcher m;
		
		if(	v.getCodFis() 	== null ||
			v.getTelaio() 	== null ||
			v.getData() 	== null ||
			v.getNote() 	== null) {
			System.err.println("VenditaManager.verificaVendita - campi nulli non ammessi");
			return false;
		}
		
		p = Pattern.compile("^[A-Z]{6}[0-9]{2}[ABCDEHLMPRST]{1}[0-9]{2}([A-Z]{1}[0-9]{3})[A-Z]{1}$");
		m = p.matcher(v.getCodFis());
		if(!m.matches()) {
			System.err.println("VenditaManager.verificaVendita - fallita validazione Codice Fiscale: " + v.getCodFis());
			return false;
		}
		
		p = Pattern.compile("[A-Z0-9]{1,17}");
		m = p.matcher(v.getTelaio());
		if(!m.matches()) {
			System.err.println("VenditaManager.verificaVendita - fallita validazione Telaio: " + v.getTelaio());
			return false;
		}
		
		p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)[0-9]{2}$");
		m = p.matcher(v.getData());
		if(!m.matches()) {
			System.err.println("VenditaManager.verificaVendita - fallita validazione Data: " + v.getData());
			return false;
		}
		
		p = Pattern.compile("[a-zA-Z0-9 ]*");
		m = p.matcher(v.getNote());
		if(!m.matches()) {
			System.err.println("VenditaManager.verificaVendita - fallita validazione Note: " + v.getNote());
			return false;
		}
		
		return true;
	}
}
