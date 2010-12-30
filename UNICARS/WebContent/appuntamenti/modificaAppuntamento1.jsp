<%@page import="unicars.bean.Appuntamento" %>
<%@page import="unicars.utility.StampaAppuntamento" %>
<%@page import="java.util.ArrayList" %>

<h1>Modifica Appuntamento</h1>
Seleziona un appuntamento per modificarlo.<br><br>
<%
	ArrayList<Appuntamento> lista = (ArrayList<Appuntamento>) request.getAttribute("lista");
	for(Appuntamento x: lista){
		out.print(StampaAppuntamento.stampa("modifica",x.getCodice(),x.getNome(),x.getCognome(),x.getData(),x.getOra()));
	}

%>