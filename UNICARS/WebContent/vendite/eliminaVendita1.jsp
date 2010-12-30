<%@page import="unicars.bean.Vendita" %>
<%@page import="unicars.utility.StampaVendita" %>
<%@page import="java.util.ArrayList" %>

<h1>Elimina Vendita</h1>
Seleziona una vendita per eliminarla. N.B. verrà richiesta una successiva conferma.<br><br>
<%
	ArrayList<Vendita> lista = (ArrayList<Vendita>) request.getAttribute("lista");
	for(Vendita x: lista){
		out.print(StampaVendita.stampa("elimina",x.getCodice(),x.getCodFis(),x.getTelaio(),x.getData()));
	}
	
%>
