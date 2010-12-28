package unicars.utility;

import unicars.bean.Appuntamento;

/**
 * @author Gianluigi Avella
 * Classe Bean che gestisce i dati relativi all'entità Appuntamento
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 */

public class appuntamento {
	public static String stampa(Appuntamento app, String action){
		return "<a href=\"index.jsp?id=" + action + app.getCodice() + "\">" +
		"<div style=\"text-align:left; background-color:white; color: black; width:90%; margin-left:auto; margin-bottom:15px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:5px\">" +
		"<table width=\"100%\"><tr>" +
		"<td width=\"40%\">" + app.getNome()+ " " + app.getCognome() + "</td><td width=\"35%\">Data: " + app.getData() + "</td><td width=\"25%\">Orario: " + app.getOra() + "</td>" +
		"</tr></table>" +
		"</div>" +
		"</a>";
	}
}
