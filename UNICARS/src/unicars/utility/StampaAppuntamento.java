package unicars.utility;

public class StampaAppuntamento {
	public static String stampa(String dest, int code, String nome, String cognome, String data, String ora){
		return "<a href=CercaAppuntamento?azione=" + dest + "&codice=" + code + ">" +
		"<div style=\"text-align:left; background-color: " + (data.equals("")?"#fff2b5":"white") + "; color: black; width:90%; margin-left:auto; margin-bottom:5px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:5px\">" +
		"<table width=\"100%\"><tr>" +
		"<td width=\"48%\">" + nome + " " + cognome + "</td><td width=\"33%\">Data: " + data + "</td><td width=\"25%\">Orario: " + ora + "</td>" +
		"</tr></table>" +
		"</div>" +
		"</a>";
	}
}
