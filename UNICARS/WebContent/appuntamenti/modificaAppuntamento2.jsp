<div style="padding-bottom:20px; margin:10px">
<h1>Modifica Appuntamento</h1>
Da questa schermata &egrave possibile modificare i campi che costituiscono l'appuntamento<br><br>

<form action="" method="post">
	<table align="center">
		<tr><td align="right">Nome:</td><td><input name="nome" type="text" value="${ app.getNome() }" ></td>
		<td align="right">Cognome:</td><td><input name="cognome" type="text" value="${ app.getCognome() }"></td></tr>
		<tr><td align="right">Data:</td><td><input name="data" type="text" value="${ app.getData() }"></td>
		<td align="right">Ora:</td><td><input name="ora" type="text" value="${ app.getOra() }"></td></tr>
		<tr><td align="right">Contatto:</td><td><input name="nome" type="text" value="${ app.getContatto() }"></td>
		<td></td><td></td></tr>
		<tr><td colspan="4">Descrizione:<br><textarea name='descrizione' cols='40' rows='4'>${ app.getDescrizione() }</textarea></td></tr>
		<tr><td align="center" colspan="4"><input value="Modifica" type="submit">
		<input value="Reset" type="reset"></td></tr>
	</table>
</form>

</div>