<%@page import="unicars.bean.Vendita" %>
<%@page import="unicars.utility.StampaVendita" %>

<%	Vendita vendita = (Vendita) request.getAttribute("vendita"); %>

<div style="padding-bottom:20px; margin:10px">
<h1>Elimina Vendita</h1>
Premendo il tasto Elimina è possibile cancellare la vendita.<br><br>
<div style="text-align:left; background-color:white; color: black; width:90%; margin-left:auto; margin-bottom:15px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:10px">
<div style="padding-left:145px"><b>Codice Fiscale</b> <%=vendita.getCodFis()%></div>
<div style="padding-left:90px"><b>Telaio</b> <%=vendita.getTelaio() %> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <b>Data:</b> <%=vendita.getData()%><br></div>
<br><div align="center"><b>Note:</b></div><%=vendita.getNote()%>
<br><br>
<form action="EliminaVendita" method="POST">
<input name="codice" type="hidden" value="<%=vendita.getCodice()%>">
<div align="right"><input value="Elimina" type="submit"></div>
</form>

</div>
</div>