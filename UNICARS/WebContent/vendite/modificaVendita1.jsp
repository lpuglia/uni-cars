<%@page import="unicars.bean.Vendita" %>
<%@page import="unicars.utility.StampaVendita" %>
<%@page import="java.util.ArrayList" %>

<h1>Modifica Vendita</h1>
Seleziona una vendita per modificarla.<br><br>
<%
	ArrayList<Vendita> lista = (ArrayList<Vendita>) request.getAttribute("lista");
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	for(Vendita x: lista){
	
		out.print(StampaVendita.stampa("modifica",x.getCodice(),x.getCodFis(),x.getTelaio(),x.getData()));

	}
	
%>

