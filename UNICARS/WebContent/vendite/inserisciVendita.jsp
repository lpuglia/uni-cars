<%//Richiamando questa pagina � possibile inserire una vendita %>
<div style="padding-bottom:20px; margin:10px">
<h1>Inserisci Vendita</h1>
In questa Schermata � possibile inserire una nuova vendita nel database.<br><br>
<form name="vendita" method="POST">
	<table align="center">
		<tr><td align="right">Codice Fiscale:</td><td><input name="codFis" type="text"></td>
		<td align="right">Telaio:</td><td><input name="telaio" type="text"></td></tr>
		<tr><td align="right">Data: </td><td><input name="data" type="text"></td>
		<td></td><td></td></tr>
		<tr><td colspan="4">Note:*<br><textarea name='note' cols='40' rows='4' ></textarea></td></tr>
		<tr><td align="center" colspan="4"><input value="Inserisci" type="button" onClick="validaVendita()">
		<input value="Cancella" type="reset"></td></tr>
	</table>
</form>
<div style="text-align:right">(*)campo opzionale</div>
</div>