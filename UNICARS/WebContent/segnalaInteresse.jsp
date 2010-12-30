<%@page import="unicars.bean.Veicolo" %>
<%@page import="unicars.utility.StampaVeicolo" %>
<%@page import="java.util.ArrayList" %>

<h1>Appuntamenti</h1>
Seleziona un appuntamento per visualizzarne i dettagli relativi.<br><br>
<%
	ArrayList<Veicolo> lista = (ArrayList<Veicolo>) request.getAttribute("lista");
	for(Veicolo x: lista){
		out.print(StampaVeicolo.stampa("visualizza",x.getTarga(),x.getTipo(),x.getMarca(),x.getModello(),x.getPrezzoV()));
	}

%>