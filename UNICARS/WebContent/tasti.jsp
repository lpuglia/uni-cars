<%//Richiamando questa pagina vengono visualizzati i bottoni della navigazione %>
<div style="margin-left:15px; margin-top:-5px;">

<a href="index.jsp" onMouseOver="cambia(home,'image/tasti/homeH.png')" onMouseOut="cambia(home,'image/tasti/home.png')"><img
name="home" src="image/tasti/home.png"></a><a href="index.jsp?id=chiSiamo" onMouseOver="cambia(chiSiamo,'image/tasti/chiSiamoH.png')" onMouseOut="cambia(chiSiamo,'image/tasti/chiSiamo.png')"><img
name="chiSiamo" src="image/tasti/chiSiamo.png"></a><a href="index.jsp?id=doveSiamo" onMouseOver="cambia(doveSiamo,'image/tasti/doveSiamoH.png')" onMouseOut="cambia(doveSiamo,'image/tasti/doveSiamo.png')"><img
name="doveSiamo" src="image/tasti/doveSiamo.png"></a><a href="index.jsp?id=ilGruppo" onMouseOver="cambia(ilGruppo,'image/tasti/ilGruppoH.png')" onMouseOut="cambia(ilGruppo,'image/tasti/ilGruppo.png')"><img
name="ilGruppo" src="image/tasti/ilGruppo.png"></a><% if(session.getAttribute("operatore")!=null){%><a onMouseOver="cambia(help,'image/tasti/helpH.png')" onMouseOut="cambia(help,'image/tasti/help.png')" onClick="Popup()"><img
name="help" src="image/tasti/help.png"></a><img src="image/tasti/blank.png">
		<%}else{%><img src="image/tasti/blank2.png"><%}%>
</div>