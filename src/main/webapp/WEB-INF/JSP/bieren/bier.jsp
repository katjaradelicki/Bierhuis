<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang='nl'>
<head>
<title>Bier</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
<h1>${gekozenBier.naam}</h1>
<dl>
<dt>Alcohol</dt>
<dd><fmt:formatNumber maxFractionDigits="0" value="${gekozenBier.percentageAlcohol}" />%
<!--<spring:eval expression="gekozenBier.percentageAlcohol"/> geeft 800% ipv 8%-->
</dd>
<dt>Prijs</dt>
<dd><fmt:formatNumber type="currency" currencySymbol="€" value="${gekozenBier.prijs}" />
<!--<spring:eval expression="gekozenBier.prijs"/> geeft een soort sterteken ipv €-teken-->
</dd>
<dt>Soort</dt>
<dd>${gekozenBier.soort.naam}</dd>
<dt>Brouwer</dt>
<dd>${gekozenBier.brouwer.naam}</dd>
</dl>
<c:url var="winkelwagenUrl" value="/winkelwagen">
<c:param name="idBier" value="${gekozenBier.bierNr}"></c:param>
</c:url>
<form:form action="${winkelwagenUrl}" method="post" commandName="bestelbonLijnForm">
<dl><dt>Aantal</dt>
<dd><form:input path="aantal" type="number" autofocus="autofocus"/>  <!--  autofocus werkt NIET in firefox (in chrome wel) -->
</dd>
</dl>
<input type="submit" value="Toevoegen" />
</form:form>
</body>
</html>