<%@page import="unicars.utility.StampaAppuntamento" %>
<%@page import="java.util.ArrayList" %>

<h1>Modifica Appuntamento</h1>
Seleziona un appuntamento per modificarlo.<br><br>
<%
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	//for(Appuntamento x: appuntamenti){
	out.print(StampaAppuntamento.stampa("modificaAppuntamento2","codice","nome","cognome","gg/mm/aaaa","hh:mm"));
	//}
	
%>