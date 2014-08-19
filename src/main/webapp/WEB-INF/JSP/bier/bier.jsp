<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!DOCTYPE html>
<html>
<head>
<v:head title="${bier.naam}"/>
</head>
<body>
<v:menu/>
<h1>${bier.naam}</h1>
<dl>
<dt>Alcohol</dt>
<dd><fmt:formatNumber value="${bier.alcohol}"/>%</dd>
<dt>prijs</dt>
<dd><fmt:formatNumber value="${bier.prijs}"/> &euro;</dd>
<dt>Soort</dt>
<dd>${bier.soort}</dd>
<dt>Brouwer</dt>
<dd>${bier.brouwer.naam}</dd>
</dl>
<spring:url value="/bier/{id}/toevoegen" var="toevoegURL">
	<spring:param name="id" value="${bier.id}"/>
</spring:url>
<form:form commandName="bierForm" action="${toevoegURL}" method="post">
<form:label path="aantal">Aantal <form:errors path="aantal" cssClass="fout"/> </form:label>
<form:input path="aantal" autofocus="true" type="number"/>
<input type="submit" value="toevoegen"/> 
</form:form>
</body>
</html>