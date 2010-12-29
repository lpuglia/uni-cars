package unicars.utility;

public class StampaVendita {
	public static String stampa(String dest, String code, String codfis, String telaio, String data){
		return "<a href=index.jsp?id=" + dest + "&code=" + code + ">" +
		"<div style=\"text-align:left; background-color:white; color: black; width:90%; margin-left:auto; margin-bottom:15px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:5px\">" +
		"<table width=\"100%\"><tr>" +
		"<td width=\"33%\">Codice Fiscale: " + codfis + "</td><td width=\"34%\">#Telaio:<br>" + telaio + "</td><td width=\"22%\">Data: " + data + "</td>" +
		"</tr></table>" +
		"</div>" +
		"</a>";
	}
}
