<%//Richiamando questa pagina è possibile visualizzare la lista degli appuntamenti %>
<%@page import="unicars.bean.Appuntamento" %>
<%@page import="unicars.utility.StampaAppuntamento" %>
<%@page import="java.util.ArrayList" %>

<h1>Appuntamenti</h1>
Seleziona un appuntamento per visualizzarne i dettagli relativi.<br><br>
<%
	ArrayList<Appuntamento> lista = (ArrayList<Appuntamento>) request.getAttribute("lista");
	for(Appuntamento x: lista){
		out.print(StampaAppuntamento.stampa("visualizza",x.getCodice(),x.getNome(),x.getCognome(),x.getData(),x.getOra()));
	}

%>