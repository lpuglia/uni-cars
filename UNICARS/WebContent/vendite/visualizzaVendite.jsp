<%@page import="unicars.utility.StampaVendita" %>
<%@page import="java.util.ArrayList" %>

<h1>Vendite</h1>
Seleziona una vendita per visualizzarne i dettagli relativi.<br><br>
<% 
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	//for(Appuntamento x: appuntamenti){
	
	out.print(StampaVendita.stampa("visualizzaVendite2","codice","PGLLUC89L01H703I","WAU ZZZ 8L Z W A 000001","gg/mm/aaaa"));

	//}
	
%>