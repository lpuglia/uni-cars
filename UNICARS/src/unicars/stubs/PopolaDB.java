package unicars.stubs;

import java.sql.Connection;
import java.sql.Statement;

import unicars.manager.DBConnection;

public class PopolaDB {

	/** 
	 * Classe stub che crea i record per le tabelle nel database 'unicarsdb' al primo utilizzo del programma
	 * 
	 * @author Gianluigi Avella
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection db;
		Connection conn;
		boolean isConnected = false;

		try {
			db = new DBConnection();
			conn = db.connetti();
			isConnected = true;

			

			Statement stmt;
			String query = "";


			if(!isConnected) {
				System.out.println("Ci sono problemi di connessione al database");
				return;
			}

			stmt = conn.createStatement();
			
			
			query ="SET FOREIGN_KEY_CHECKS=0;";
			stmt.executeQuery(query);
			query = "INSERT INTO appuntamento VALUES ('0000000001', 'mario', 'rossi', '01/01/2000', '09:00', 'prova1', 'via xxx 10', '0');" ;
			stmt.executeUpdate(query);
			query = "INSERT INTO appuntamento VALUES ('0000000002', 'gianni', 'bianchi', '02/02/2002', '11:00', 'prova2', 'via yyy 20', '0');" ;
			stmt.executeUpdate(query);
			query = "INSERT INTO appuntamento VALUES ('0000000003', 'marco', 'verdi', '03/03/2003', '15:00', 'prova3', 'via zzz 30', '2');" ;
			stmt.executeUpdate(query);
			query = "INSERT INTO appuntamento VALUES ('0000000004', 'Danilo', 'Grieco', '', '', 'CD003EF', '12345', '0');";
			stmt.executeUpdate(query);
			
			System.out.println("Record appuntamento inseriti");
			
			query = "INSERT INTO cliente VALUES ('Danilo', 'Grieco', '19/09/1989', 'Battipaglia', 'DANGRI89A19F654H', 'Via Contursi', 'dan@live.it', '54321');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Gianluigi', 'Avella', '15/08/1988', 'Salerno', 'GIAAVE88H15O159P', 'Via San Giorgio', 'gian@live.it', '54789');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Luca', 'Puglia', '01/07/1989', 'Salerno', 'LUCPUG89B01E357T', 'Via Pastena', 'luke@live.it', '98765');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Marco', 'Tranfaglia', '16/04/1990', 'Salerno', 'MARTRA89C14T123F', 'Via Torrione', 'mark@live.it', '14785');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Michele', 'Fratello', '02/04/1989', 'Avellino', 'MICFRA89D02A587G', 'Via Montella', 'mike@live.it', '12345');";
			stmt.executeUpdate(query);
			
			System.out.println("Record cliente inseriti");
			
			query = "INSERT INTO operatore VALUES ('janus', 'unicars', 'Danilo', 'Grieco', 'dani@live.it', '1');";
			stmt.executeUpdate(query);
			query = "INSERT INTO operatore VALUES ('phantom', 'unicars', 'Luca', 'Puglia', 'luke@live.it', '2');";
			stmt.executeUpdate(query);
			query = "INSERT INTO operatore VALUES ('thephilantropist', 'unicars', 'Ganluigi', 'Avella', 'gian@live.it', '1');";
			stmt.executeUpdate(query);
			
			System.out.println("Record operatore inseriti");
			
			query = "INSERT INTO riparazione VALUES ('0000000001', 'riparazione 1', '0', '01/01/2001', '08/01/2001', 'X');";
			stmt.executeUpdate(query);
			query = "INSERT INTO riparazione VALUES ('0000000002', 'riparazione 2', '1', '02/02/2002', '12/02/2002', 'Y');";
			stmt.executeUpdate(query);
			query = "INSERT INTO riparazione VALUES ('0000000003', 'riparazione 3', '2', '03/03/2003', '10/03/2003', 'Z');";
			stmt.executeUpdate(query);
			
			System.out.println("Record riparazione inseriti");
			
			query = "INSERT INTO veicolo VALUES ('W', 'GH004TY', 'Auto', 'Audi', 'A5', '40000', '70000', '3.0 DLX', 'bianco per');";
			stmt.executeUpdate(query);
			query = "INSERT INTO veicolo VALUES ('X', 'AB001BC', 'Auto', 'Fiat', 'Punto', '10530', '12400', '1.4 TDI', 'viola');";
			stmt.executeUpdate(query);
			query = "INSERT INTO veicolo VALUES ('Y', 'BC002CD', 'Camion', 'Scania', 'Optimus Prime', '150000', '200000', '7.0', 'rosso');";
			stmt.executeUpdate(query);
			query = "INSERT INTO veicolo VALUES ('Z', 'CD003EF', 'Camper', 'Viaggia Allegro', 'All night long', '60000', '80000', '2.5', 'giallo');";
			stmt.executeUpdate(query);
			
			System.out.println("Record veicolo inseriti");
			
			query = "INSERT INTO vendita VALUES ('0000000001', 'MICFRA89D02A587G', 'W', '15/01/2011', 'bel camion4');";
			stmt.executeUpdate(query);
			query = "INSERT INTO vendita VALUES ('0000000002', 'DANGRI89A19F654H', 'X', '16/01/2011', 'punto e basta');";
			stmt.executeUpdate(query);
			query = "INSERT INTO vendita VALUES ('0000000003', 'LUCPUG89B01E357T', 'Z', '17/01/2011', 'viaggiamo!');";
			stmt.executeUpdate(query);
			
			System.out.println("Record vendita inseriti");
			
			
		}
		catch(Exception ex) {
			System.err.print("Exception: ");
			System.err.println(ex.getMessage());
		}
	}

}