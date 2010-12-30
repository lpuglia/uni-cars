<%@page import="unicars.bean.Appuntamento" %>
<%@page import="unicars.utility.StampaAppuntamento" %>

<%	Appuntamento appuntamento = (Appuntamento) request.getAttribute("appuntamento"); %>

<div style="padding-bottom:20px; margin:10px">
<h1>Elimina Appuntamento</h1>
Premendo il tasto Elimina è possibile cancellare l'appuntamento.<br><br>
<div style="text-align:left; background-color:white; color: black; width:90%; margin-left:auto; margin-bottom:15px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:10px">
<div style="padding-left:100px"><b>Nome:</b> <%=appuntamento.getNome()%> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <b>Cognome:</b> <%=appuntamento.getCognome()%><br></div>
<div style="padding-left:140px"><b>Data:</b> <%=appuntamento.getData()%> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <b>Ora:</b> <%=appuntamento.getOra()%><br></div>
<div style="padding-left:160px"><b>Contatto:</b> <%=appuntamento.getContatto()%></div>
<br><div align="center"><b>Descrizione:</b></div><%=appuntamento.getDescrizione()%>
<br><br>
<form action="EliminaAppuntamento" method="post">
<input name="codice" type="hidden" value="<%=appuntamento.getCodice()%>">
<div align="right"><input value="Elimina" type="submit"></div>
</form>

</div>
</div>