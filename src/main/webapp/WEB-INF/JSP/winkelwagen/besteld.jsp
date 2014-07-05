<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Bier</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
<h1>Je winkelwagen is bevestigd als bestelbon ${param.bestelbonNr}</h1>

</body>
</html>