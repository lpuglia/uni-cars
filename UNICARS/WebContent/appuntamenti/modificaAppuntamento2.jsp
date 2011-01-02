<%@page import="unicars.bean.Appuntamento" %>

<%	Appuntamento appuntamento = (Appuntamento) request.getAttribute("appuntamento"); %>

<div style="padding-bottom:20px; margin:10px">
<h1>Modifica Appuntamento</h1>
Da questa schermata &egrave possibile modificare i campi che costituiscono l'appuntamento<br><br>

<form name="appuntamento" method="POST">
	<table align="center">
		<tr><td align="right">Nome:</td><td><input name="nome" type="text" value="<%=appuntamento.getNome()%>"></td>
		<td align="right">Cognome:</td><td><input name="cognome" type="text" value="<%=appuntamento.getCognome()%>"></td></tr>
		<tr><td align="right">Data:</td><td><input name="data" type="text" value="<%=appuntamento.getData()%>"></td>
		<td align="right">Ora:</td><td><input name="ora" type="text" value="<%=appuntamento.getOra()%>"></td></tr>
		<tr><td align="right">Contatto:</td><td><input name="contatto" type="text" value="<%=appuntamento.getContatto()%>"></td>
		<td></td><td></td></tr>
		<tr><td colspan="4">Descrizione:<br><textarea name='descrizione' cols='40' rows='4'><%=appuntamento.getDescrizione()%></textarea>
		<input name="codice" type="hidden" value="<%=appuntamento.getCodice()%>"><input name="azione" type="hidden" value="<%=appuntamento.getCodice()%>"></td></tr>
		<tr><td align="center" colspan="4"><input value="Modifica" type="button" onClick="validaAppuntamento()">
		<input value="Reset" type="reset"></td></tr>
	</table>
</form>

</div>