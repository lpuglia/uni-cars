<%@page import="unicars.utility.StampaRiparazione" %>
<%@page import="java.util.ArrayList" %>

<h1>Riparazioni</h1>
Seleziona una riparazione per visualizzarne i dettagli relativi.<br><br>
<%
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	//for(Appuntamento x: appuntamenti){
	out.print(StampaRiparazione.stampa("VisualizzaRiparazione2","codice","telaio","gg/mm/aaaa","in corso"));
	//}
	
%>