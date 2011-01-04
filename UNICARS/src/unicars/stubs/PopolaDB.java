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
	
			char a;
			boolean goOn = false;
	
			while (!goOn) {
				System.out.println("Vuoi creare i record per le tabelle del database?");
				System.out.println("Premi S per procedere o N per uscire");
				System.out.println("ATTENZIONE:se esistono gia dei record saranno azzerati");
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
	
	
			query ="SET FOREIGN_KEY_CHECKS=0;";
			stmt.executeQuery(query);
			query = "DELETE FROM appuntamento";
			stmt.executeUpdate(query);
			query = "ALTER TABLE appuntamento AUTO_INCREMENT=1";
			stmt.executeUpdate(query);
			query = "INSERT INTO appuntamento VALUES ('0000000001', 'mario', 'rossi', '01/01/2000', '09:00', 'prova1', 'via xxx 10', '0');" ;
			stmt.executeUpdate(query);
			query = "INSERT INTO appuntamento VALUES ('0000000002', 'gianni', 'bianchi', '02/02/2002', '11:00', 'prova2', 'via yyy 20', '0');" ;
			stmt.executeUpdate(query);
			query = "INSERT INTO appuntamento VALUES ('0000000003', 'marco', 'verdi', '03/03/2003', '15:00', 'prova3', 'via zzz 30', '2');" ;
			stmt.executeUpdate(query);
			//query = "INSERT INTO appuntamento VALUES ('0000000004', 'Danilo', 'Grieco', '', '', 'CD003EF', '12345', '0');";
			//stmt.executeUpdate(query);
	
			System.out.println("Record appuntamento inseriti");
	
			query = "DELETE FROM cliente";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Danilo', 'Grieco', '19/09/1989', 'Battipaglia', 'GRCDNL89P19A717D', 'Via Contursi', 'dan@live.it', '54321');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Gianluigi', 'Avella', '15/08/1988', 'Salerno', 'VLLGNL83C20F913Z', 'Via San Giorgio', 'gian@live.it', '54789');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Luca', 'Puglia', '01/07/1989', 'Salerno', 'PGLLCU89L01H703I', 'Via Pastena', 'luke@live.it', '98765');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Marco', 'Tranfaglia', '16/04/1990', 'Salerno', 'TRNMRC90D16H703S', 'Via Torrione', 'mark@live.it', '14785');";
			stmt.executeUpdate(query);
			query = "INSERT INTO cliente VALUES ('Michele', 'Fratello', '02/04/1989', 'Avellino', 'FRTMHL89D02A509C', 'Via Montella', 'mike@live.it', '12345');";
			stmt.executeUpdate(query);
	
			System.out.println("Record cliente inseriti");
	
			query = "DELETE FROM operatore";
			stmt.executeUpdate(query);
			query = "INSERT INTO operatore VALUES ('janus', 'unicars', 'Danilo', 'Grieco', 'dani@live.it', '1');";
			stmt.executeUpdate(query);
			query = "INSERT INTO operatore VALUES ('phantom', 'unicars', 'Luca', 'Puglia', 'luke@live.it', '2');";
			stmt.executeUpdate(query);
			query = "INSERT INTO operatore VALUES ('thephilantropist', 'unicars', 'Ganluigi', 'Avella', 'gian@live.it', '1');";
			stmt.executeUpdate(query);
	
			System.out.println("Record operatore inseriti");
	
			query = "DELETE FROM riparazione";
			stmt.executeUpdate(query);
			query = "INSERT INTO riparazione VALUES ('0000000001', 'riparazione 1', '0', '01/01/2001', '08/01/2001', 'X');";
			stmt.executeUpdate(query);
			query = "INSERT INTO riparazione VALUES ('0000000002', 'riparazione 2', '1', '02/02/2002', '12/02/2002', 'Y');";
			stmt.executeUpdate(query);
			query = "INSERT INTO riparazione VALUES ('0000000003', 'riparazione 3', '2', '03/03/2003', '10/03/2003', 'Z');";
			stmt.executeUpdate(query);
	
			System.out.println("Record riparazione inseriti");
	
			query = "DELETE FROM veicolo";
			stmt.executeUpdate(query);
			query = "INSERT INTO veicolo VALUES ('W', 'GH004TY', 'Auto', 'Audi', 'A5', '40000', '70000', '3.0 DLX', 'bianco per');";
			stmt.executeUpdate(query);
			query = "INSERT INTO veicolo VALUES ('X', 'AB001BC', 'Auto', 'Fiat', 'Punto', '10530', '12400', '1.4 TDI', 'viola');";
			stmt.executeUpdate(query);
			query = "INSERT INTO veicolo VALUES ('Y', 'BC002CD', 'Camion', 'Scania', 'Optimus Prime', '150000', '200000', '7.0', 'rosso');";
			stmt.executeUpdate(query);
			query = "INSERT INTO veicolo VALUES ('Z', 'CD003EF', 'Camper', 'Viaggia Allegro', 'All night long', '60000', '80000', '2.5', 'giallo');";
			stmt.executeUpdate(query);
	
			System.out.println("Record veicolo inseriti");
	
			query = "DELETE FROM vendita";
			stmt.executeUpdate(query);
			query = "INSERT INTO vendita VALUES ('0000000001', 'MARTRA89C14T123F', 'Y', '18/01/2011', 'test modifica');";
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
