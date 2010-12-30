<%@page import="unicars.bean.Appuntamento" %>
<%@page import="unicars.utility.StampaAppuntamento" %>
<%@page import="java.util.ArrayList" %>

<h1>Elimina Appuntamento</h1>
Seleziona un appuntamento per eliminarlo. N.B. verrà richiesta una successiva conferma.<br><br>
<%
	ArrayList<Appuntamento> lista = (ArrayList<Appuntamento>) request.getAttribute("lista");
	for(Appuntamento x: lista){
		out.print(StampaAppuntamento.stampa("elimina",x.getCodice(),x.getNome(),x.getCognome(),x.getData(),x.getOra()));
	}
	
%>
