package unicars.manager;

import java.util.ArrayList;
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
	private boolean isConnected;
	public static final Vendita VENDITA_VUOTO = new Vendita(-1, null, null, null, null); 
	
	/**Costruttore della classe.
	 * 
	 * @param c Oggetto DBConnection in cui sono memorizzati tutti i dati necessari.
	 * per stabilire una connessione con il database.
	 */
	public VenditaManager()
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
	 * Ricerca all'interno del database tutte le Vendite memorizzate.
	 * 
	 * @return Un'ArrayList contenente tutte le Vendite memorizzate nel database.
	 */
	public ArrayList<Vendita> listaVendite() {
		ArrayList<Vendita> lista = new ArrayList<Vendita>();
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM vendita";
		
		if(!isConnected) return null;
		
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

		if((codice < 0) || (codice > 10e10)) return null;
		if(!isConnected) return null;
		
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
		String query = "INSERT INTO vendita VALUES ('" + v.getCodice() + 
													"', '" + v.getCodFis() +
													"', '" + v.getTelaio() +
													"', '" + v.getData() + 
													"', '" + v.getNote() + "')";
		
		if(v == null || v == VENDITA_VUOTO || !verificaVendita(v)) return false;
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
		
		if(v == null || v == VENDITA_VUOTO || !verificaVendita(v)) return false;
		if(!isConnected) return false;
		
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
	
	private boolean verificaVendita(Vendita v) {
		/* p;
		Matcher m;
		
		p = Pattern.compile("[a-zA-Z0-9]{1,10}");
		m = p.matcher(v.getCodice());
		if(!m.matches()) return false;
		
		p = Pattern.compile("[A-Z0-9]{16}");
		m = p.matcher(v.getCodFis());
		if(!m.matches()) return false;
		
		p = Pattern.compile("[A-Z0-9]{25}");
		m = p.matcher(v.getTelaio());
		if(!m.matches()) return false;
		
		p = Pattern.compile("(((0[1-9]|[12][0-9]|3[01])([/])(0[13578]|10|12)([/])([0-9]{4}))|(([0][1-9]|[12][0-9]|30)([/])(0[469]|11)([/])([0-9]{4}))|((0[1-9]|1[0-9]|2[0-8])([/])(02)([/])([0-9]{4}))|((29)(/)(02)([/])([02468][048]00))|((29)([/])(02)([/])([13579][26]00))|((29)([/])(02)([/])([0-9][0-9][0][48]))|((29)([/])(02)([/])([0-9][0-9][2468][048]))|((29)([/])(02)([/])([0-9][0-9][13579][26])))");
		m = p.matcher(v.getData());
		if(!m.matches()) return false;
		
		p = Pattern.compile("[a-zA-Z0-9]*");
		m = p.matcher(v.getNote());
		if(!m.matches()) return false;
		*/
		return true;
	}
}
