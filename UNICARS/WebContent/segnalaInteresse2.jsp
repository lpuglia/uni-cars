<%//Richiamando questa pagina viene visualizzata la schermata in cui inserire i propri dati %>
<div style="text-align:center; width:90%; margin-left:auto; margin-right:auto;">
<h1>Segnala Interesse</h1>
Inserisci i tuoi dati per segnalare il tuo interesse su questo modello.
<br><br><form name="interesse" method="POST">
<table align="center">
      <tr><td>Nome:</td><td><input name="nome" type="text"></td></tr>
      <tr><td>Cognome:</td><td><input name="cognome" type="text"></td></tr>
      <tr><td>Recapito:</td><td><input name="contatto" type="text">
      <input name="descrizione" type="hidden" value="<%=request.getParameter("code")%>"></td></tr>
	  <tr><td colspan="2"><input value="Segnala Interesse" type="button" onClick="validaInteresse()"></td></tr>
</table>
</form>
</div>
<br><br><br>