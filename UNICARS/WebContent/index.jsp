<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">

<table>
<tr>
	<td colspan="3">
	<img src="image/banner.jpg">
	<%@ include file="/tasti.jsp" %>
	</td>
</tr>
<tr>
	<td style="width: 232px; text-align: center;">
	<%@ include file="/opzioniUtente.jsp"%>
	</td>
	<td style="text-align: center; width: 511px;">----------?
	</td>
	<td style="text-align: center; width: 221px;">
	<%@ include file="/accesso.jsp"%>
	</td>
</tr>
</table>
</body>
</html>