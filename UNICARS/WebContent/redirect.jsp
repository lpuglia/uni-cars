<%@page import="unicars.utility.Messaggio" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UniCars</title>
	<link rel="stylesheet" href="css/stile.css" type="text/css">
	
	<script language="JavaScript">
		var time = null
		function move() {
		window.location = 'index.jsp?';
		}
	</script>
	
</head>
<body onload="timer=setTimeout('move()',5000)">
<div class="corniceRedirect">
	<div class="redirect">
		<br><h1>${msg.messaggio}</h1><br><br>
		Tra 5 secondi sarai<br>reindirizzato alla index del sito.<br>
		Se nn vuoi attendere oltre clicca <a class="black" href="index.jsp">qui</a>.
	</div>
</div>
</body>
</html>