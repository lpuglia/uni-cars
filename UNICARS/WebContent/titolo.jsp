<%//Richiamando questa pagina viene settato il titolo della pagina %>
<%
String id1 = request.getParameter("id");
if(id1!=null){
	if (id1.equals("chiSiamo")){ %>Chi Siamo
<%	}else if (id1.equals("doveSiamo")){ %>Dove Siamo
<%	}else if (id1.equals("ilGruppo")){ %>Il Gruppo
<%	}else if (id1.equals("accessoAreaWeb")){ %>Accesso Area Web
<%	}else if (id1.equals("accessoUtenti")){ %>Accesso Utenti
<%	}else if (id1.equals("visualizzaVeicoli")){ %>Visualizza Veicoli
<%	}else if (id1.equals("segnalaInteresse1")){ %>Segnala Interesse
<%	}else if (id1.equals("segnalaInteresse2")){ %>Segnala Interesse
<%	}else if (id1.equals("inserisciVeicolo")){ %>Inserisci Veicolo
<%	}else if (id1.equals("modificaVeicolo")){ %>Modifica Veicolo
<%	}else if (id1.equals("eliminaVeicolo")){ %>Elimina Veicolo
<%	}else if (id1.equals("visualizzaParcoVeicoli")){ %>Visualizza Parco Veicoli
<%	}else if (id1.equals("inserisciRiparazione")){ %>Inserisci Riparazione
<%	}else if (id1.equals("modificaRiparazione")){ %>Modifica Riparazione
<%	}else if (id1.equals("eliminaRiparazione")){ %>Elimina Riparazione
<%	}else if (id1.equals("visualizzaRiparazioni")){ %>Visualizza Riparazioni
<%	}else if (id1.equals("inserisciCliente")){ %>Inserisci Cliente
<%	}else if (id1.equals("modificaCliente")){ %>Modifica Cliente
<%	}else if (id1.equals("eliminaCliente")){ %>Elimina Cliente
<%	}else if (id1.equals("inserisciVendita")){ %>Inserisci Vendita
<%	}else if (id1.equals("modificaVendita1")){ %>Modifica Vendita
<%	}else if (id1.equals("modificaVendita2")){ %>Modifica Vendita
<%	}else if (id1.equals("eliminaVendita1")){ %>Elimina Vendita
<%	}else if (id1.equals("eliminaVendita2")){ %>Elimina Vendita
<%	}else if (id1.equals("visualizzaVendite")){ %>Visualizza Vendite
<%	}else if (id1.equals("inserisciAppuntamento")){ %>Inserisci Appuntamento
<%	}else if (id1.equals("modificaAppuntamento1")){ %>Modifica Appuntamento
<%	}else if (id1.equals("modificaAppuntamento2")){ %>Modifica Appuntamento
<%	}else if (id1.equals("eliminaAppuntamento1")){ %>Elimina Appuntamneto
<%	}else if (id1.equals("eliminaAppuntamento2")){ %>Elimina Appuntamento
<%	}else if (id1.equals("visualizzaAppuntamenti")){ %>Visualizza Appuntamenti
<%	} 
%> - <%
}%>Unicars