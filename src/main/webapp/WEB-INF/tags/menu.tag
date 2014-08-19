<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>
<nav>
	<ul>
	<li><a href="<c:url value='/'/>">Welkom</a></li>
	<li><a href="<c:url value='/brouwers'/>">Bieren van een brouwer</a></li>
	<li><a href="<c:url value='/winkelwagen'/>">Winkelwagen</a></li>
	</ul>
</nav>
