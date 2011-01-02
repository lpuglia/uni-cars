<%//Richiamando questa pagina viene visualizzato nel menu a destra il profilo dell'utente collegato%>
<h2>Dettagli Operatore</h2>
Nome: ${operatore.nome}<br>
Cognome: ${operatore.cognome}<br>
Username: ${operatore.username}<br>
E-Mail: ${operatore.email}<br>
<form action="Logout" method="GET">
<input type="submit" value="Logout">
</form>