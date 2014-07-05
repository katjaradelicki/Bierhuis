<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Winkelwagen</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
<h1>Winkelwagen</h1>
<!-- sessie rechtsreeks aanspreken zonder request attribuut WAAROM WERKT DIT NIET
${winkelwagenOnSession}
${sessionScope.winkelwagenOnSession}
<c:if test="${not empty sessionScope.winkelwagenOnSession.bestelbon.bestelbonLijnen}">er zit iets in het mandje</c:if>
<c:if test="${empty sessionScope.winkelwagenOnSession.bestelbon.bestelbonLijnen}">er zit niets in het madje</c:if>
 -->
 
<c:if test="${not empty winkelwagen.bestelbon.bestelbonLijnen}">
<table>
<thead><tr><th>Bier</th><th>Prijs</th><th>Aantal</th><th>Te betalen</th></tr></thead>
<tfoot><tr><td></td> <td></td> <td></td>   <td>Totaal: ${winkelwagen.bestelbon.getTotaleKost()}</td></tr></tfoot>
<tbody>
<c:forEach items="${winkelwagen.bestelbon.bestelbonLijnen}" var="bestelbonLijn"><tr><td>${bestelbonLijn.bier.naam}</td><td>${bestelbonLijn.bier.prijs}</td><td>${bestelbonLijn.aantal}</td><td>${bestelbonLijn.getKostBestelbonLijn()}</td>   </c:forEach>
</tbody>
</table>

</c:if>
<c:if test="${empty winkelwagen.bestelbon.bestelbonLijnen}">Het winkelmandje is nog leeg</c:if>
</body>
<c:url var="overzichtUrl" value="/winkelwagen/overzicht"></c:url>
<form:form method="post" action="${overzichtUrl}" commandName="bestelbon">
<dl>
<dt><form:label path="naam">Naam</form:label><form:errors path='naam' cssClass='fout'/> </dt>
<dd><form:input path="naam" autofocus='autofocus'/></dd>
<dt><form:label path="adres.straat">Straat</form:label></dt>
<dd><form:input  path="adres.straat"/></dd>
<dt><form:label path="adres.huisNr">Huisnummer</form:label></dt>
<dd><form:input path="adres.huisNr"/></dd>
<dt><form:label path="adres.postcode" type="number">Postcode</form:label><form:errors path='adres.postcode' cssClass='fout'/></dt>
<dd><form:input path="adres.postcode"/></dd>
<dt><form:label path="adres.gemeente">Gemeente</form:label></dt>
<dd><form:input path="adres.gemeente"/></dd>
</dl>
<input type="submit" value="Als bestelbon bevestigen"/>

</form:form>



</html>