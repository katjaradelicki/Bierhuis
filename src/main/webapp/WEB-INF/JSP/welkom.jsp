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
<h1>Welkom in het huis van de Belgische bieren</h1>
<img alt="bieren.jpg" src="${pageContext.servletContext.contextPath}/images/bierhuis.jpg">
<footer>We hebben momenteel ${aantalBieren} bieren</footer>
</body>
</html>