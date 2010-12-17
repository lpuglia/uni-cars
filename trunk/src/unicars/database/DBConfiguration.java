package unicars.database;

/**
 * @author Gianluigi Avella
 * Classe di utilità per dare modularità al database
 * Contiene tutti i parametri di configurazione del nostro DB
 * I nomi delle variabili sono esplicativi ed indicano quale parametro del DB configurano
 */

public class DBConfiguration {
	
	private String nome,path,utente,passwd,driver;

	public DBConfiguration() {
		nome = "dbflysoft";
		path = "jdbc:mysql://localhost/dbflysoft";
		utente = "root";
		passwd = "root";
		driver = "com.mysql.jdbc.Driver";
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
