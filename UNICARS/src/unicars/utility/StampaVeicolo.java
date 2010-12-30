package unicars.utility;

public class StampaVeicolo {
	public static String stampa(String dest, String code, String tipo, String marca, String modello, Double prezzo){
		return "<a href=CercaVeicolo?azione=" + dest + "&codice=" + code + ">" +
		"<div style=\"text-align:left; background-color:white; color: black; width:90%; margin-left:auto; margin-bottom:5px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:5px\">" +
		"<table width=\"100%\"><tr>" +
		"<td width=\"45%\">" + tipo + ": " + modello + "</td><td width=\"33%\">Marca: " + marca + "</td><td width=\"32%\">Prezzo: " + prezzo + " &euro;</td>" +
		"</tr></table>" +
		"</div>" +
		"</a>";
	}
}
