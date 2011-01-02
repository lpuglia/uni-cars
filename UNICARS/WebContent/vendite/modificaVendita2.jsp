<%@page import="unicars.bean.Vendita" %>
<%@page import="unicars.utility.StampaVendita" %>

<%	Vendita vendita = (Vendita) request.getAttribute("vendita"); %>

<div style="padding-bottom:20px; margin:10px">
<h1>Modifica Vendita</h1>
Da questa schermata &egrave possibile modificare i campi che costituiscono la vendita<br><br>
<form name="vendita" method="POST">
	<table align="center">
		<tr><td align="right">Codice Fiscale: </td><td><input name="codFis" type="text" value="<%=vendita.getCodFis()%>"></td>
		<td align="right">Telaio: </td><td><input name="telaio" type="text" value="<%=vendita.getTelaio()%>"></td></tr>
		<tr><td align="right">Data: </td><td><input name="data" type="text" value="<%=vendita.getData()%>"></td>
		<td></td><td></td></tr>
		<tr><td colspan="4">Note:<br><textarea name='note' cols='40' rows='4' ><%=vendita.getNote()%></textarea><input name="codice" type="hidden" value="<%=vendita.getCodice()%>"></td></tr>
		<tr><td align="center" colspan="4"><input value="Modifica" type="button" onClick="validaVendita()">
		<input value="Cancella" type="reset"></td></tr>
	</table>
</form>
</div>