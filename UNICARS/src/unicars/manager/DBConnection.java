package unicars.manager;

import java.sql.*;

/**
 * @author Gianluigi Avella
 * Classe di utilità per dare modularità al database
 * Contiene tutti i parametri di configurazione del nostro DB
 * I nomi delle variabili sono esplicativi ed indicano quale parametro del DB configurano
 */

public class DBConnection {
	
	private String nome,path,utente,passwd,driver;

	public DBConnection() {
		nome = "unicarsdb";
		path = "jdbc:mysql://localhost/unicarsdb";
		utente = "root";
		passwd = "root";
		driver = "com.mysql.jdbc.Driver";
	}
	
	public Connection connetti() throws ClassNotFoundException, SQLException {
		Connection connect = null;
		Class.forName(driver);
		connect = DriverManager.getConnection(path,utente,passwd);
		return connect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	

}
