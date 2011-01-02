package unicars.stubs;

import java.sql.*;

/** 
 * Classe Stub che crea il database 'unicarsdb' per prima istanza dell'applicazione.
 * 
 * @author Gianluigi Avella
 */

import unicars.manager.DBConnection;

/** 
 * Classe stub che crea il database 'unicarsdb' al primo utilizzo del programma
 * 
 * @author Gianluigi Avella
 */

public class CreaDatabase {

	private static Connection connection;
	private static Statement statement;
	private static String nomeDB = "";
	private static String usr="";
	private static String pwd="";

	public static void main(String[] args) {

		DBConnection DB = new DBConnection();
		nomeDB = DB.getNome();
		usr = DB.getUtente();
		pwd = DB.getPasswd();


		try {

			Class.forName("org.gjt.mm.mysql.Driver").newInstance();

			String url = "jdbc:mysql://localhost/";
			connection = DriverManager.getConnection(url, usr, pwd);
			statement = connection.createStatement();

			String query = "CREATE DATABASE "+nomeDB;
			statement.executeUpdate(query);
			System.out.println(query);

			query="GRANT SELECT,INSERT,UPDATE,DELETE," +
			"CREATE,DROP " +
			"ON "+nomeDB+".* TO '"+usr+"'@'localhost' " +
			"IDENTIFIED BY '"+pwd+"';";
			statement.executeUpdate(query);
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}