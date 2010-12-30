<%@page import="unicars.bean.Vendita" %>
<%@page import="unicars.utility.StampaVendita" %>
<%@page import="java.util.ArrayList" %>

<h1>Vendite</h1>
Seleziona una vendita per visualizzarne i dettagli relativi.<br><br>
<%
	ArrayList<Vendita> lista = (ArrayList<Vendita>) request.getAttribute("lista");
	for(Vendita x: lista){
		out.print(StampaVendita.stampa("visualizza",x.getCodice(),x.getCodFis(),x.getTelaio(),x.getData()));
	}
	
%>