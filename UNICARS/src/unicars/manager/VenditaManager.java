package unicars.manager;

import java.util.ArrayList;
import unicars.bean.Vendita;
import java.sql.*;

public class VenditaManager implements IVenditaManager{
	
	private Connection conn;
	private boolean isConnected;
	
	public VenditaManager(DBConnection c)
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
	
	public ArrayList<Vendita> listaVendite() {
		ArrayList<Vendita> lista = null;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM vendita";
		
		if(!isConnected) return null;
		
		try {
			lista = new ArrayList<Vendita>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				lista.add(new Vendita(rs.getString("codice"), 
										rs.getString("codFis"), 
										rs.getString("telaio"), 
										rs.getString("data"), 
										rs.getString("note")));
			}
		}
		catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return lista;
	}

	public Vendita cercaVendita(String codice) {
		Vendita v = null;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM vendita where codice='" + codice + "'";
		
		if(!isConnected) return null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				v = new Vendita(rs.getString("codice"), 
								rs.getString("codFis"), 
								rs.getString("telaio"), 
								rs.getString("data"), 
								rs.getString("note"));
			}
		}
		catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
		return v;
	}

	public boolean inserisciVendita(Vendita v) {
		boolean ret = false;
		Statement stmt;
		String query = "INSERT INTO vendita VALUES ('" + v.getCodice() + 
													"', '" + v.getCodFis() +
													"', '" + v.getTelaio() +
													"', '" + v.getData() + 
													"', '" + v.getNote() + "')";
		
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

	public boolean modificaVendita(Vendita v) {
		boolean ret = false;
		Statement stmt;
		String query = "UPDATE vendita SET codFis='" + v.getCodFis() 
						+ "', telaio='" + v.getTelaio()
						+ "', data='" + v.getData() + 
						"', note='" + v.getNote()+ "' WHERE codice='"
						+ v.getCodice() + "'";
		
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

	public boolean eliminaVendita(String codice) {
		boolean ret = false;
		Statement stmt;
		String query = "DELETE FROM vendita WHERE codice='" + codice + "'";
		
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
}
