<%//Richiamando questa pagina è possibile visualizzare la lista delle riparazioni %>
<%@page import="unicars.bean.Riparazione" %>
<%@page import="unicars.utility.StampaRiparazione" %>
<%@page import="java.util.ArrayList" %>

<h1>Riparazioni</h1>
Seleziona una riparazione per visualizzarne i dettagli relativi.<br><br>
<%
	ArrayList<Riparazione> lista = (ArrayList<Riparazione>) request.getAttribute("lista");
	for(Riparazione x: lista){
		out.print(StampaRiparazione.stampa("visualizza",x.getCodice(),x.getTelaio(),x.getDataInizio(),x.getStato()));
	}
	
%>

