<%@page import="unicars.bean.Veicolo" %>
<%@page import="unicars.utility.StampaVeicolo" %>
<%@page import="java.util.ArrayList" %>

<h1>Segnala Interesse</h1>
Seleziona una macchina per visualizzarne i<br>dettagli relativi ed eventualmente segnalarne un interesse.<br><br>
<%
	ArrayList<Veicolo> lista = (ArrayList<Veicolo>) request.getAttribute("lista");
	for(Veicolo x: lista){
		out.print(StampaVeicolo.stampa("visualizza",x.getTarga(),x.getTipo(),x.getMarca(),x.getModello(),x.getPrezzoV()));
	}

%>