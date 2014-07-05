<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
<h1>Brouwers</h1>
<c:if test="${not empty brouwers}">
<ul>
<c:forEach items="${brouwers}" var="brouwer">
<c:url var="brouwerUrl" value="/bieren">
<c:param name="idBrouwer" value="${brouwer.brouwerNr}"/>
</c:url>
<li><a href="${brouwerUrl}">${brouwer.naam} (${brouwer.adres.gemeente})</a>
</li>

</c:forEach>
</ul>
</c:if>
</body>
</html>