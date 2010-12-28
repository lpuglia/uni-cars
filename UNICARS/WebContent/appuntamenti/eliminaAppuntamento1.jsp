<%@page import="unicars.bean.Appuntamento" %>
<%@page import="unicars.utility.appuntamento" %>
<%@page import="java.util.ArrayList" %>

<h1>Elimina Appuntamento</h1>
Seleziona un appuntamento per eliminarlo. N.B. verrà richiesta una successiva conferma.<br><br>
<% 
	Appuntamento app = new Appuntamento("danilo","grieco","as1313fsd","15gennaio","15:15","descrizione","danilo@danilo.it",0);
	//ArrayList<Appuntamento> appuntamenti = null; /*chiamata a funzione di ginalugi*/
	//for(Appuntamento x: appuntamenti){
	
	out.print(appuntamento.stampa(app,"eliminaAppuntamento2&code="));
	
	//}
	
%>