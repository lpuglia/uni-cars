<%@page import="unicars.utility.Messaggio" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><%@ include file="/titolo.jsp"%></title>
	<link rel="stylesheet" href="css/stile.css" type="text/css">
	<link rel="shortcut icon" href="image/ico.png" type="image/x-icon"> 
	
	<script language="JavaScript">
	function cambia(ImageName,ImageFile){
	ImageName.src = ImageFile;
	}
	</script>
	<script type="text/javascript">
     function Popup(apri) {
    	 window.open('help/index.html','','width=800,height=600,toolbar=0, location=0,menubar=0,resizable=0,titlebar=1,direct ories=1,status=0,scrollbars=1');
     }
 	</script>
	
	<script type="text/javascript" language="Javascript" src="js/validaAppuntamento.js"></script>
	<script type="text/javascript" language="Javascript" src="js/validaVendita.js"></script>
	<script type="text/javascript" language="Javascript" src="js/validaInteresse.js"></script>

</head>
<body>
<!-- <div style="position:absolute; width:100%; height:100%; background-color:black; opacity:0.4;"></div> -->
	<div class="mainT">
		<a href="index.jsp"><img src="image/banner.jpg"></a>
		
		<%@ include file="/tasti.jsp" %>
	</div>
	<div class="site">
		<% //Menu laterale destro
		if(session.getAttribute("operatore")!=null){%>
			<div class="corniceMenu" style="height:530px">
			<div id="menu" class="celle">
			<%@ include file="/opzioniOperatore.jsp"%>
			</div></div>
		<%}else{%>
			<div class="corniceMenu" style="height:310px">
			<div id="menu" class="celle" style="padding-left:20px;">
			<br><br>
			<%@ include file="/opzioniUtente.jsp"%>
			</div></div>
		<%}%><div id="container" class="celle">
		<br>
		<img src="image/contenuti.png">
		<br><br>
		<%//Contenitore principale del sito %>
		<%@ include file="/contenuti.jsp"%>
		</div>
		<div class="corniceLogin">
		<div id="login" class="celle" >
		<% //Menu di login a destra
		if(session.getAttribute("operatore")==null){%>
			<img src="image/accessoOperatori.png">
			<%@ include file="/accesso.jsp"%>
		<%}else{%>
			<%@ include file="/profilo.jsp"%>
		<%}%>
		</div></div>
	</div>
</body>
</html>