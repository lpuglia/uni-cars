<%@page import="unicars.utility.StampaAppuntamento" %>
<%@page import="java.util.ArrayList" %>

<h1>Elimina Appuntamento</h1>
Seleziona un appuntamento per eliminarlo. N.B. verr� richiesta una successiva conferma.<br><br>
<% 
	//Appuntamento app = new Appuntamento("danilo","grieco","as1313fsd","15gennaio","15:15","descrizione","danilo@danilo.it",0);
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	//for(Appuntamento x: appuntamenti){
	
	out.print(StampaAppuntamento.stampa("eliminaAppuntamento2","codice","nome","cognome","gg/mm/aaaa","hh:mm"));

	//}
	
%>
