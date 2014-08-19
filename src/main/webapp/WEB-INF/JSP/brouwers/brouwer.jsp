<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html>
<head>
<v:head title="${brouwer.naam}"/>
</head>
<body>
<v:menu/>
<h1>${brouwer.naam} (${brouwer.gemeente})</h1>
<ul>
<c:forEach items="${bieren}" var="bier">
	<spring:url value="/bier/{id}" var="bierURL">
		<spring:param name="id" value="${bier.id}"/>
	</spring:url>
	<li><a href="${bierURL}">${bier.naam}</a></li>
</c:forEach>
</ul>
</body>
</html>