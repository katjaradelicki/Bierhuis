<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Welkom</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
<h1>${gekozenBrouwer.naam} (${gekozenBrouwer.adres.gemeente})</h1>
<c:if test="${not empty bieren}">
<ul>

<c:forEach items="${bieren}" var="bier">
<c:url var="detailUrl" value="/bieren/bier"><c:param name="idBier" value="${bier.bierNr}" /></c:url>
<li><a href="${detailUrl}">${bier.naam}</a></li></c:forEach>
</ul>
</c:if>
</body>
</html>