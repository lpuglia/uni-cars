<%//Richiamando questa pagina è possibile inserire un appuntamento %>
<div style="padding-bottom:20px; margin:10px">
<h1>Inserisci Appuntamento</h1>
In questa Schermata è possibile inserire un nuovo appuntamento nel database.<br><br>
<form name="appuntamento" method="POST">
	<table align="center">
		<tr><td align="right">Nome(*):</td><td><input name="nome" type="text"></td>
		<td align="right">Cognome(*):</td><td><input name="cognome" type="text"></td></tr>
		<tr><td align="right">Data:</td><td><input name="data" type="text"></td>
		<td align="right">Ora:</td><td><input name="ora" type="text"></td></tr>
		<tr><td align="right">Contatto:(*)</td><td><input name="contatto" type="text"></td>
		<td></td><td></td></tr>
		<tr><td colspan="4">Descrizione:<br><textarea name='descrizione' cols='40' rows='4' ></textarea></td></tr>
		<tr><td align="center" colspan="4"><input value="Inserisci" type="button" onClick="validaAppuntamento()">
		<input value="Cancella" type="reset"></td></tr>
	</table>
</form>
<div style="text-align:right">(*)campi obbligatori</div>
</div>