<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UniCars</title>
	<link rel="stylesheet" href="css/stile.css" type="text/css">
	
	<script language=""JavaScript"">
	function cambia(ImageName,ImageFile){
	ImageName.src = ImageFile;
	}
	</script>

</head>
<body>
	<div class="mainT">
		<img src="image/banner.jpg">
		<%@ include file="/tasti.jsp" %>
	</div>
	<div class="site">
		<div id="menu" class="celle">
		<%@ include file="/opzioniOperatore.jsp"%>
		</div><div id="container" class="celle">
		<br>
		<img src="image/contents.png">
		<br><br>
		<%@ include file="/inserisciCliente.jsp"%>
		</div>
		<div id="login" class="celle" ><%@ include file="/accesso.jsp"%></div>
	</div>
</body>
</html>