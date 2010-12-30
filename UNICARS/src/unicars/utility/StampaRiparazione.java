package unicars.utility;

public class StampaRiparazione {

	public static String stampa(String dest, int code, String telaio, String data, int stato){
		return "<a href=CercaRiparazione?azione=" + dest + "&codice=" + code + ">" +
		"<div style=\"text-align:left; background-color:white; color: black; width:90%; margin-left:auto; margin-bottom:5px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:5px\">" +
		"<table width=\"100%\"><tr>" +
		"<td width=\"38%\">Telaio: " + telaio + "</td><td width=\"37%\">Data Inizio: " + data + "</td><td width=\"25%\">Stato: " + stato + "</td>" +
		"</tr></table>" +
		"</div>" +
		"</a>";
	}
}
