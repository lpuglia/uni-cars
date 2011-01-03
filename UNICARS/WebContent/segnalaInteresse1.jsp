<%//Richiamando questa pagina viene visualizzata la scheda relativa al veicolo scelto %>
<%@page import="unicars.bean.Veicolo" %>

<%	Veicolo veicolo = (Veicolo) request.getAttribute("veicolo"); %>

<div style="text-align:left; background-color:white; color: black; width:90%; margin-left:auto; margin-bottom:15px; margin-right:auto; -moz-border-radius: 15px; -webkit-border-radius: 15px; padding:10px">
<table style="width: 100%;">
    <tr>
      <td colspan="2">
      <div align="center"><h1>Scheda Tecnica</h1></div>
      </td>
    </tr>
    <tr>
    <td><img src="image/veicoli/<%=veicolo.getTarga()%>.jpg" width="250px"></td>
    <td>
    Numero di Telaio: <%=veicolo.getTelaio()%><br>
    Numero di Targa: <%=veicolo.getTarga()%><br>
    Tipo: <%=veicolo.getTipo()%><br>
    Marca: <%=veicolo.getMarca()%><br>
    Modello: <%=veicolo.getModello()%><br>
    Prezzo Vendita: <%=veicolo.getPrezzoV()%><br>
    Allestimento: <%=veicolo.getAllestimento()%><br>
    Colore: <%=veicolo.getColore()%><br>
	</td>
    </tr>
    <tr>
    <td colspan="2">
    	<div style="text-align:center;"><a class="black" href="index.jsp?id=segnalaInteresse2&code=<%=veicolo.getTarga()%>">Segnala Interesse</a></div>
      </td>
    </tr>
</table>
</div>