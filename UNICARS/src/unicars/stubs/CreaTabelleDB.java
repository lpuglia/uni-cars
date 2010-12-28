package unicars.stubs;

import java.sql.*;

import unicars.manager.DBConnection;

public class CreaTabelleDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		DBConnection db = new DBConnection();
		try {
			conn = db.connetti();
			System.out.println("Connesso");
			
		}
		catch(java.lang.ClassNotFoundException err) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(err.getMessage());
			
		} 
		catch(SQLException e) {
			System.err.print("SQLException: ");
			System.err.println(e.getMessage());
			
		}

		Statement stmt;
		ResultSet rs = null;
		String query = "SET FOREIGN_KEY_CHECKS=0;" +
				"-- ----------------------------" +
				"-- Table structure for `appuntamento`" +
				"-- ----------------------------" +
				"DROP TABLE IF EXISTS `appuntamento`;" +
				"CREATE TABLE `appuntamento` (" +
				"  `codice` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT," +
				"  `nome` varchar(30) NOT NULL," +
				"  `cognome` varchar(30) NOT NULL," +
				"  `data` char(10) DEFAULT NULL," +
				"  `ora` char(5) DEFAULT NULL," +
				"  `descrizione` varchar(40) DEFAULT NULL," +
				"  `contatto` varchar(40) NOT NULL," +
				"  `stato` int(11) NOT NULL," +
				"  PRIMARY KEY (`codice`)" +
				") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;" +
				"-- ----------------------------" +
				"-- Records of appuntamento" +
				"-- ----------------------------" +
				"INSERT INTO `appuntamento` VALUES ('0000000000', 'reginaldo', 'bianchi', '03/10/2000', '12:10', 'prova4', 'via titi', '0');" +
				"INSERT INTO `appuntamento` VALUES ('0000000001', 'mario', 'rossi', '01/01/2000', '09:00', 'prova1', 'via xxx 10', '2');" +
				"INSERT INTO `appuntamento` VALUES ('0000000002', 'gianni', 'bianchi', '02/02/2002', '11:00', 'prova2', 'via yyy 20', '0');" +
				"INSERT INTO `appuntamento` VALUES ('0000000003', 'marco', 'verdi', '03/03/2003', '15:00', 'prova3', 'via zzz 30', '2');" +
				"-- ----------------------------" +
				"-- Table structure for `cliente`" +
				"-- ----------------------------" +
				"DROP TABLE IF EXISTS `cliente`;" +
				"CREATE TABLE `cliente` (" +
				"  `nome` varchar(30) NOT NULL," +
				"  `cognome` varchar(30) NOT NULL," +
				"  `dataNascita` char(10) NOT NULL," +
				"  `luogoNascita` varchar(30) NOT NULL," +
				"  `codFis` char(16) NOT NULL," +
				"  `indirizzo` varchar(40) DEFAULT NULL," +
				"  `email` varchar(40) DEFAULT NULL," +
				"  `telefono` varchar(15) NOT NULL," +
				"  PRIMARY KEY (`codFis`)" +
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;" +
				"-- ----------------------------" +
				"-- Records of cliente" +
				"-- ----------------------------" +
				"INSERT INTO `cliente` VALUES ('Danilo', 'Grieco', '19/09/1989', 'Battipaglia', 'DANGRI89I19F654H', 'Via Contursi', 'dan@live.it', '54321');" +
				"INSERT INTO `cliente` VALUES ('Gianluigi', 'Avella', '15/08/1988', 'Salerno', 'GIAAVE88H15O159P', 'Via San Giorgio', 'gian@live.it', '54789');" +
				"INSERT INTO `cliente` VALUES ('Luca', 'Puglia', '01/07/1989', 'Salerno', 'LUCPUG89G01E357T', 'Via Pastena', 'luke@live.it', '98765');" +
				"INSERT INTO `cliente` VALUES ('Marco', 'Tranfaglia', '16/04/1990', 'Salerno', 'MARTRAD16T145J', 'Via Torrione', 'mark@live.it', '14785');" +
				"INSERT INTO `cliente` VALUES ('Michele', 'Fratello', '02/04/1989', 'Avellino', 'MICFRA89D02A587G', 'Via Montella', 'mike@live.it', '12345');" +
				"-- ----------------------------" +
				"-- Table structure for `operatore`" +
				"-- ----------------------------" +
				"DROP TABLE IF EXISTS `operatore`;" +
				"CREATE TABLE `operatore` (" +
				"  `username` varchar(20) NOT NULL," +
				"  `password` varchar(10) NOT NULL," +
				"  `nome` varchar(30) NOT NULL," +
				"  `cognome` varchar(30) NOT NULL," +
				"  `email` varchar(40) NOT NULL," +
				"  `gruppo` int(11) NOT NULL," +
				"  PRIMARY KEY (`username`)" +
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;" +
				"-- ----------------------------" +
				"-- Records of operatore" +
				"-- ----------------------------" +
				"-- ----------------------------" +
				"-- Table structure for `riparazione`" +
				"-- ----------------------------" +
				"DROP TABLE IF EXISTS `riparazione`;" +
				"CREATE TABLE `riparazione` (" +
				"  `codice` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT," +
				"  `descrizione` varchar(40) DEFAULT NULL," +
				"  `stato` int(11) NOT NULL," +
				"  `dataInizio` char(10) NOT NULL," +
				"  `dataFine` char(10) NOT NULL," +
				"  `telaio` varchar(25) NOT NULL," +
				"  PRIMARY KEY (`codice`)," +
				"  KEY `telaior_constr` (`telaio`)," +
				"  CONSTRAINT `telaior_constr` FOREIGN KEY (`telaio`) REFERENCES `veicolo` (`telaio`)" +
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;" +
				"-- ----------------------------" +
				"-- Records of riparazione" +
				"-- ----------------------------" +
				"-- ----------------------------" +
				"-- Table structure for `veicolo`" +
				"-- ----------------------------" +
				"DROP TABLE IF EXISTS `veicolo`;" +
				"" +
				"CREATE TABLE `veicolo` (" +
				"  `telaio` varchar(25) NOT NULL," +
				"  `targa` varchar(8) NOT NULL," +
				"  `tipo` varchar(15) NOT NULL," +
				"  `marca` varchar(20) NOT NULL," +
				"  `modello` varchar(255) NOT NULL," +
				"  `prezzoA` double NOT NULL," +
				"  `prezzoV` double NOT NULL," +
				"  `allestimento` varchar(30) DEFAULT NULL," +
				"  `colore` varchar(10) DEFAULT NULL," +
				"  PRIMARY KEY (`telaio`)" +
				") ENGINE=InnoDB DEFAULT CHARSET=latin1;" +
				"-- ----------------------------" +
				"-- Records of veicolo" +
				"-- ----------------------------" +
				"INSERT INTO `veicolo` VALUES ('', '', '', '', '', '0', '0', null, null);" +
				"INSERT INTO `veicolo` VALUES ('W', 'GH004TY', 'Auto', 'Audi', 'A5', '40000', '70000', '3.0 DLX', 'bianco per');" +
				"INSERT INTO `veicolo` VALUES ('X', 'AB001BC', 'Auto', 'Fiat', 'Punto', '10530', '12400', '1.4 TDI', 'viola');" +
				"INSERT INTO `veicolo` VALUES ('Y', 'BC002CD', 'Camion', 'Scania', 'Optimus Prime', '150000', '200000', '7.0', 'rosso');" +
				"INSERT INTO `veicolo` VALUES ('Z', 'CD003EF', 'Camper', 'Viaggia Allegro', 'All night long', '60000', '80000', '2.5', 'giallo');" +
				"-- ----------------------------" +
				"-- Table structure for `vendita`" +
				"-- ----------------------------" +
				"DROP TABLE IF EXISTS `vendita`;" +
				"CREATE TABLE `vendita` (" +
				"  `codice` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT," +
				"  `codFis` char(16) NOT NULL," +
				"  `telaio` varchar(25) NOT NULL," +
				"  `data` char(10) NOT NULL," +
				"  `note` varchar(40) DEFAULT NULL," +
				"  PRIMARY KEY (`codice`)," +
				"  KEY `codFis_constr` (`codFis`)," +
				"  KEY `telaio_constr` (`telaio`)," +
				"  CONSTRAINT `codFis_constr` FOREIGN KEY (`codFis`) REFERENCES `cliente` (`codFis`)," +
				"  CONSTRAINT `telaio_constr` FOREIGN KEY (`telaio`) REFERENCES `veicolo` (`telaio`)" +
				") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;" +
				"-- ----------------------------" +
				"-- Records of vendita" +
				"-- ----------------------------" +
				"INSERT INTO `vendita` VALUES ('0000000001', 'MICFRA89D02A587G', 'Y', '15/01/2011', 'bel camion');" +
				"INSERT INTO `vendita` VALUES ('0000000002', 'DANGRI89I19F654H', 'X', '16/01/2011', 'punto e basta');" +
				"INSERT INTO `vendita` VALUES ('0000000003', 'LUCPUG89G01E357T', 'Z', '17/01/2011', 'viaggiamo!');";
		
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			stmt.close();
			
		}
		catch(SQLException ex) {
			System.err.print("SQLException: ");
			System.err.println(ex.getMessage());
		}
	}

}
