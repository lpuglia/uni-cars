package unicars.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * Classe che gestisce le interazioni con il database riguardanti le segnalazioni di Interesse.
 * Implementa l'interfaccia IAppuntamentoManager.
 * 
 * @author Michele Fratello
 */

public class SegnalaInteresseManager implements ISegnalaInteresseManager{

	private DBConnection db;
	private Connection conn;
	private boolean isConnected = false;
	
	/**
	 * Costruttore della classe.
	 */
	public SegnalaInteresseManager()
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
	 * Inserisce una segnalazione di Interesse sottoforma di Appuntamento all'interno del database.
	 * 
	 * @param nome Il nome dell'utente che segnala interesse.
	 * @param cognome Il cognome dell'utente che segnala interesse.
	 * @param contatto Il contatto dell'utente che segnala interesse.
	 * @return Restituisce true in caso di esito positivo, false altrimenti.
	 */
	public boolean segnalaInteresse(String nome, String cognome, String contatto, String descrizione) {
		boolean ret = false;
		Statement stmt;
		String query = "INSERT INTO appuntamento (	nome, " +
													"cognome, " +
													"contatto, " +
													"data, " +
													"ora, " +
													"descrizione, " +
													"stato) " +
													"VALUES (" +
													"'" + nome + "', " +
													"'" + cognome + "', " +
													"'" + contatto + "', " +
													"'', " +
													"'', " +
													"'" + descrizione + "', " +
													"'0'" + ")";
		Pattern nomeP = Pattern.compile("[a-zA-Z]{1,30}");
		Pattern cognomeP = Pattern.compile("[a-zA-Z]{1,30}");
		Pattern contattoP = Pattern.compile("[a-zA-Z0-9@., ]*");
		Pattern descrizioneP = Pattern.compile("[A-Z0-9]{1,8}");
		Matcher nomeM, cognomeM, contattoM, descrizioneM;
		
		if(!isConnected) {
			System.err.println("SegnalaInteresseManager.segnalaInteresse() - nessuna connessione al db attiva!");
			return false;
		}
		
		if(	(nome 			== null) ||
			(cognome 		== null) ||
			(contatto 		== null) ||
			(descrizione 	== null)) {
			System.err.println("SegnalaInteresseManager.segnalaInteresse() - valori nulli non ammessi");
			return false;
		}
		
		nomeM = nomeP.matcher(nome);
		cognomeM = cognomeP.matcher(cognome);
		contattoM = contattoP.matcher(contatto);
		descrizioneM = descrizioneP.matcher(descrizione);
		if((!nomeM.matches()) || (!cognomeM.matches()) || (!contattoM.matches()) || (!descrizioneM.matches())) {
			System.err.println("SegnalaInteresseManager.segnalaInteresse() - fallita validazione dati");
			return false;
		}
		
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
