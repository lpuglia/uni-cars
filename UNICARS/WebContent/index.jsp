<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UniCars</title>
	<link rel="stylesheet" href="css/stile.css" type="text/css">
	
	<script language="JavaScript">
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
		<img src="image/contenuti.png">
		<br><br>
		<% 
		String id = request.getParameter("id");
		if(id!=null){
			if (id.equals("chiSiamo")){ %>
				<%@ include file="chiSiamo.jsp" %>
		<%	}else if (id.equals("doveSiamo")){ %>
				<%@ include file="doveSiamo.jsp" %>
		<%	}else if (id.equals("ilGruppo")){ %>
				<%@ include file="ilGruppo.jsp" %>
		<%	}else if (id.equals("inserisciVeicolo")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("modificaVeicolo")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("eliminaVeicolo")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("visualizzaParcoVeicoli")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("inserisciRiparazione")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("modificaRiparazione")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("eliminaRiparazione")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("visualizzaStatoRiparazioni")){ %>
				<%@ include file="riparazioni/visualizzaRiparazioni.jsp" %>
		<%	}else if (id.equals("inserisciCliente")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("modificaCliente")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("eliminaCliente")){ %>
				<%@ include file="notImplementedYet.jsp" %>
		<%	}else if (id.equals("inserisciVendita")){ %>
				<%@ include file="vendite/inserisciVendita.jsp" %>
		<%	}else if (id.equals("modificaVendita1")){ %>
				<%@ include file="vendite/modificaVendita1.jsp" %>
		<%	}else if (id.equals("modificaVendita2")){ %>
				<%@ include file="vendite/modificaVendita2.jsp" %>
		<%	}else if (id.equals("eliminaVendita1")){ %>
				<%@ include file="vendite/eliminaVendita1.jsp" %>
		<%	}else if (id.equals("eliminaVendita2")){ %>
				<%@ include file="vendite/eliminaVendita2.jsp" %>
		<%	}else if (id.equals("inserisciAppuntamento")){ %>
				<%@ include file="appuntamenti/inserisciAppuntamento.jsp" %>
		<%	}else if (id.equals("modificaAppuntamento1")){ %>
				<%@ include file="appuntamenti/modificaAppuntamento1.jsp" %>
		<%	}else if (id.equals("modificaAppuntamento2")){ %>
				<%@ include file="appuntamenti/modificaAppuntamento2.jsp" %>
		<%	}else if (id.equals("eliminaAppuntamento1")){ %>
				<%@ include file="appuntamenti/eliminaAppuntamento1.jsp" %>
		<%	}else if (id.equals("eliminaAppuntamento2")){ %>
				<%@ include file="appuntamenti/eliminaAppuntamento2.jsp" %>
		<%	}else{ %>
				<%@ include file="home.jsp" %>
		<%	}
		} %>
		</div>
	<div id="login" class="celle" ><%@ include file="/accesso.jsp"%></div>
	</div>
</body>
</html>