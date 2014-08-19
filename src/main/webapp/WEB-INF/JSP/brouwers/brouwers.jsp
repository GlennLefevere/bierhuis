<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html>
<head>
<v:head title="Brouwers" />
</head>
<body>
	<v:menu />
	<h1>Brouwers</h1>
	<c:if test="${not empty page}">
		<ul>
			<c:forEach items="${page.content}" var="brouwer">
				<spring:url value="/brouwers/{id}" var="brouwerURL">
					<spring:param name="id" value="${brouwer.id}"/>
				</spring:url>
				<li><a href="${brouwerURL}">${brouwer.naam}(${brouwer.gemeente})</a></li>
			</c:forEach>
		</ul>
		<div class="pages">
			<c:forEach var="i" begin="1" end="${page.totalPages}">
				<c:url value="/brouwers" var="url">
					<c:param name="page" value="${i-1}" />
				</c:url>
				<a href="${url}">${i}</a>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>