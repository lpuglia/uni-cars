package unicars.manager;

import java.sql.*;

/**
 * Classe di utilita' per dare modularita' al database.
 * Contiene tutti i parametri di configurazione del nostro DB.
 * I nomi delle variabili sono esplicativi ed indicano quale parametro del DB configurano.
 * 
 * @author Gianluigi Avella
 */

public class DBConnection {
	
	private String nome,path,utente,passwd,driver;

	/**
	 * Costruttore della classe
	 */
	public DBConnection() {
		nome = "unicarsdb";
		path = "jdbc:mysql://localhost/unicarsdb";
		utente = "root";
		passwd = "root";
		driver = "com.mysql.jdbc.Driver";
	}
	
	/**
	 * Metodo principale della classe. Effettua una connessione al database utilizzando i dati
	 * memorizzati nelle variabili di istanza.
	 * 
	 * @return Un oggetto Connection tramite il quale e' possibile eseguire comandi SQL .
	 * @throws ClassNotFoundException quando il driver scelto non e' disponibile.
	 * @throws SQLException quando la connessione non va a buon fine.
	 */
	public Connection connetti() throws ClassNotFoundException, SQLException {
		Connection connect = null;
		Class.forName(driver);
		connect = DriverManager.getConnection(path,utente,passwd);
		return connect;
	}

	/**
	 * Restituisce il path del database.
	 * @return una stringa contenente il path del database.
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Imposta il path del database.
	 * @param path il path del database da impostare.
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Restituisce il nome del database.
	 * @return una stringa in cui e' contenuto il nome del database.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome del database.
	 * @param nome stringa contenente il nome del database da impostare.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il nome dell'utente utilizzato per accedere al database.
	 * @return una stringa con l'username.
	 */
	public String getUtente() {
		return utente;
	}

	/**
	 * Imposta un nuovo utente per l'accesso al database.
	 * @param utente il nome del nuovo utente da utilizzare per collegarsi al database.
	 */
	public void setUtente(String utente) {
		this.utente = utente;
	}

	/**
	 * Restituisce la password utilizzata dall'utente per accedere al database.
	 * @return la password usata dall'utente per collegarsi al database.
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * Imposta una nuova password per l'accesso al database.
	 * @param passwd la nuova passoword per collegarsi al database.
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * Restituisce il driver utilizzato nel collegamento col database.
	 * @return il driver usato.
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * Imposta un nuovo driver di interfacciamento al database.
	 * @param driver il nuovo driver da utilizzare.
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
	

}
