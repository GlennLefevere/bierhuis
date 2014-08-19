<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!DOCTYPE html>
<html>
<head>
<v:head title="winkelwagen"/>
</head>
<body>
<v:menu/>
<h1>Winkelwagen</h1>
<table>
<tr>
	<th>Bier</th>
	<th>Prijs</th>
	<th>Aaantal</th>
	<th>Te betalen</th>
</tr>
<c:if test="${not empty bestelbon.bestelbonlijnen}">
	<c:forEach items="${bestelbon.bestelbonlijnen}" var="bestelbonlijn">
		<tr>
			<td>${bestelbonlijn.bier.naam}</td>
			<td id="number"><fmt:formatNumber value="${bestelbonlijn.bier.prijs}"/></td>
			<td id="number">${bestelbonlijn.aantal}</td>
			<td id="number"><fmt:formatNumber value="${bestelbonlijn.teBetalen}"/></td>
		</tr>
	</c:forEach>
</c:if>
<tr>
<td id="number" colspan="4">Totaal: <fmt:formatNumber value="${bestelbon.totaal}"/> </td>
</tr>
</table>
<spring:url value="/winkelwagen/bestellen" var="bestellenURL"/>
<form:form commandName="bestelbon" action="${bestellenURL}" method="post">
	<form:label path="naam">Naam <form:errors path="naam" cssClass="fout"/></form:label>
	<form:input path="naam"/>
	<form:label path="straat">straat <form:errors path="straat" cssClass="fout"/></form:label>
	<form:input path="straat"/>
	<form:label path="huisNr">huisnummer <form:errors path="huisNr" cssClass="fout"/></form:label>
	<form:input path="huisNr"/>
	<form:label path="postcode">postcode <form:errors path="postcode" cssClass="fout"/></form:label>
	<form:input path="postcode" type="number"/>
	<form:label path="gemeente">gemeente <form:errors path="gemeente" cssClass="fout"/></form:label>
	<form:input path="gemeente"/>
	<input type="submit" value="Als bestelbon bevestigen"/>
</form:form>
</body>
</html>