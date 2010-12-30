<%@page import="unicars.utility.StampaAppuntamento" %>
<%@page import="java.util.ArrayList" %>

<h1>Appuntamenti</h1>
Seleziona un appuntamento per visualizzarne i dettagli relativi.<br><br>
<%
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	//for(Appuntamento x: appuntamenti){
	out.print(StampaAppuntamento.stampa("visualizzaAppuntamento2",123456,"nome","cognome","gg/mm/aaaa","hh:mm"));
	//}
	
%>