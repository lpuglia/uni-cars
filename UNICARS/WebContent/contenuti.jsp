<%//Richiamando questa pagina vengono visualizzati i vari contenuti del sito %>
<%
boolean check=false;
String id = request.getParameter("id");
if(session.getAttribute("operatore")!=null)
	check=true;

if(id!=null){
	if (id.equals("chiSiamo")){ %>
		<%@ include file="chiSiamo.jsp" %>
<%	}else if (id.equals("doveSiamo")){ %>
		<%@ include file="doveSiamo.jsp" %>
<%	}else if (id.equals("ilGruppo")){ %>
		<%@ include file="ilGruppo.jsp" %>
<%	}else if (id.equals("registrazioneCliente")){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("modificaDati")){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("ricercaVettura")){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("visualizzazioneDati")){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("visualizzaVeicoli")){ %>
		<%@ include file="segnalaInteresse.jsp" %>
<%	}else if (id.equals("segnalaInteresse1")){ %>
		<%@ include file="segnalaInteresse1.jsp" %>
<%	}else if (id.equals("segnalaInteresse2")){ %>
		<%@ include file="segnalaInteresse2.jsp" %>
<%	}else if (id.equals("inserisciVeicolo") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("modificaVeicolo") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("eliminaVeicolo") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("visualizzaParcoVeicoli") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("inserisciRiparazione") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("modificaRiparazione") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("eliminaRiparazione") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("visualizzaRiparazioni") && check){ %>
		<%@ include file="riparazioni/visualizzaRiparazioni.jsp" %>
<%	}else if (id.equals("inserisciCliente") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("modificaCliente") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("eliminaCliente") && check){ %>
		<%@ include file="notImplementedYet.jsp" %>
<%	}else if (id.equals("inserisciVendita") && check){ %>
		<%@ include file="vendite/inserisciVendita.jsp" %>
<%	}else if (id.equals("modificaVendita1") && check){ %>
		<%@ include file="vendite/modificaVendita1.jsp" %>
<%	}else if (id.equals("modificaVendita2") && check){ %>
		<%@ include file="vendite/modificaVendita2.jsp" %>
<%	}else if (id.equals("eliminaVendita1") && check){ %>
		<%@ include file="vendite/eliminaVendita1.jsp" %>
<%	}else if (id.equals("eliminaVendita2") && check){ %>
		<%@ include file="vendite/eliminaVendita2.jsp" %>
<%	}else if (id.equals("visualizzaVendite") && check){ %>
		<%@ include file="vendite/visualizzaVendite.jsp" %>
<%	}else if (id.equals("inserisciAppuntamento") && check){ %>
		<%@ include file="appuntamenti/inserisciAppuntamento.jsp" %>
<%	}else if (id.equals("modificaAppuntamento1") && check){ %>
		<%@ include file="appuntamenti/modificaAppuntamento1.jsp" %>
<%	}else if (id.equals("modificaAppuntamento2") && check){ %>
		<%@ include file="appuntamenti/modificaAppuntamento2.jsp" %>
<%	}else if (id.equals("eliminaAppuntamento1") && check){ %>
		<%@ include file="appuntamenti/eliminaAppuntamento1.jsp" %>
<%	}else if (id.equals("eliminaAppuntamento2") && check){ %>
		<%@ include file="appuntamenti/eliminaAppuntamento2.jsp" %>
<%	}else if (id.equals("visualizzaAppuntamenti") && check){ %>
		<%@ include file="appuntamenti/visualizzaAppuntamenti.jsp" %>
<%	}else{ %>
		<%@ include file="home.jsp" %>
<%	}
} else {%>
	<%@ include file="home.jsp" %>
<%}%>