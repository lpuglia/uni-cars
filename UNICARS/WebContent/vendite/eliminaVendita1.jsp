<%@page import="unicars.utility.StampaVendita" %>
<%@page import="java.util.ArrayList" %>

<h1>Elimina Vendita</h1>
Seleziona una vendita per eliminarla. N.B. verrà richiesta una successiva conferma.<br><br>
<% 
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	//for(Appuntamento x: appuntamenti){
	
	out.print(StampaVendita.stampa("eliminaVendita2",1234567,"PGLLUC89L01H703I","WAU ZZZ 8L Z W A 000001","gg/mm/aaaa"));

	//}
	
%>
