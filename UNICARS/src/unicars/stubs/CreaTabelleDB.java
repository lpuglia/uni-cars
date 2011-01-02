package unicars.stubs;

import java.sql.Connection;
import java.sql.Statement;

import unicars.manager.DBConnection;

public class CreaTabelleDB {

	/** 
	 * Classe stub che crea le tabelle per il database 'unicarsdb' al primo utilizzo del programma
	 * 
	 * @author Gianluigi Avella
	 */
	
	public static void main(String[] args) {

		DBConnection db;
		Connection conn;
		boolean isConnected = false;

		try {
			db = new DBConnection();
			conn = db.connetti();
			isConnected = true;


			Statement stmt;
			String query = "";

			System.out.println("Creazione tabelle in corso ...");

			if(!isConnected) 
				System.out.println("Ci sono problemi di connessione al database");
			char a;
			boolean goOn = false;

			while (!goOn) {
				System.out.println("Vuoi creare le tabelle per il database?");
				System.out.println("Premi S per procedere o N per uscire");
				System.out.println("ATTENZIONE:se esiste gia un Database i record saranno azzerati");
				a = (char) System.in.read();
				switch(a) {
				case 's' :
				case 'S' :
					goOn= true;
					break;

				case 'n' :
				case 'N' :
					return;

				default :
					goOn = false;
					break;
				}

			}


			stmt = conn.createStatement();

			query = "SET FOREIGN_KEY_CHECKS=0;";
			stmt.executeUpdate(query);

			query = "DROP TABLE IF EXISTS appuntamento;";
			stmt.executeUpdate(query);

			query = "CREATE TABLE appuntamento (" +
			"  codice int(10) unsigned zerofill NOT NULL AUTO_INCREMENT," +
			"  nome varchar(30) NOT NULL," +
			"  cognome varchar(30) NOT NULL," +
			"  data char(10) DEFAULT NULL," +
			"  ora char(5) DEFAULT NULL," +
			"  descrizione varchar(40) DEFAULT NULL," +
			"  contatto varchar(40) NOT NULL," +
			"  stato int(11) NOT NULL," +
			"  PRIMARY KEY (codice)" +
			") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;";
			stmt.executeUpdate(query);

			query = "DROP TABLE IF EXISTS cliente;";
			stmt.executeUpdate(query);

			query = "CREATE TABLE cliente (" +
			"  nome varchar(30) NOT NULL," +
			"  cognome varchar(30) NOT NULL," +
			"  dataNascita char(10) NOT NULL," +
			"  luogoNascita varchar(30) NOT NULL," +
			"  codFis char(16) NOT NULL," +
			"  indirizzo varchar(40) DEFAULT NULL," +
			"  email varchar(40) DEFAULT NULL," +
			"  telefono varchar(15) NOT NULL," +
			"  PRIMARY KEY (codFis)" +
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
			stmt.executeUpdate(query);

			query = "DROP TABLE IF EXISTS operatore;";
			stmt.executeUpdate(query);

			query = "CREATE TABLE operatore (" +
			"  username varchar(20) NOT NULL," +
			"  password varchar(10) NOT NULL," +
			"  nome varchar(30) NOT NULL," +
			"  cognome varchar(30) NOT NULL," +
			"  email varchar(40) NOT NULL," +
			"  gruppo int(11) NOT NULL," +
			"  PRIMARY KEY (username)" +
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
			stmt.executeUpdate(query);

			query = "DROP TABLE IF EXISTS riparazione;";
			stmt.executeUpdate(query);

			query = "CREATE TABLE riparazione (" +
			"  codice int(10) unsigned zerofill NOT NULL AUTO_INCREMENT," +
			"  descrizione varchar(40) DEFAULT NULL," +
			"  stato int(11) NOT NULL," +
			"  dataInizio char(10) NOT NULL," +
			"  dataFine char(10) NOT NULL," +
			"  telaio varchar(25) NOT NULL," +
			"  PRIMARY KEY (codice)," +
			"  KEY telaior_constr (telaio)," +
			"  CONSTRAINT telaior_constr FOREIGN KEY (telaio) REFERENCES veicolo (telaio) ON UPDATE CASCADE" +
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
			stmt.executeUpdate(query);

			query = "DROP TABLE IF EXISTS veicolo;";
			stmt.executeUpdate(query);

			query = "CREATE TABLE veicolo (" +
			"  telaio varchar(25) NOT NULL," +
			"  targa varchar(8) NOT NULL," +
			"  tipo varchar(15) NOT NULL," +
			"  marca varchar(20) NOT NULL," +
			"  modello varchar(255) NOT NULL," +
			"  prezzoA double NOT NULL," +
			"  prezzoV double NOT NULL," +
			"  allestimento varchar(30) DEFAULT NULL," +
			"  colore varchar(10) DEFAULT NULL," +
			"  PRIMARY KEY (telaio)" +
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
			stmt.executeUpdate(query);

			query = "DROP TABLE IF EXISTS vendita;";
			stmt.executeUpdate(query);

			query = "CREATE TABLE vendita (" +
			"  codice int(10) unsigned zerofill NOT NULL AUTO_INCREMENT," +
			"  codFis char(16) NOT NULL," +
			"  telaio varchar(25) NOT NULL," +
			"  data char(10) NOT NULL," +
			"  note varchar(40) DEFAULT NULL," +
			"  PRIMARY KEY (codice)," +
			"  KEY codFis_constr (codFis)," +
			"  KEY telaio_constr (telaio)," +
			"  CONSTRAINT codFis_constr FOREIGN KEY (codFis) REFERENCES cliente (codFis) ON UPDATE CASCADE," +
			"  CONSTRAINT telaio_constr FOREIGN KEY (telaio) REFERENCES veicolo (telaio) ON UPDATE CASCADE" +
			") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;";
			stmt.executeUpdate(query);

			System.out.println("Le tabelle sono state create correttamente");
		}
		catch(Exception ex) {
			System.err.print("Exception: ");
			System.err.println(ex.getMessage());
		}
	}

}
