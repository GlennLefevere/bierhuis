<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>
<!DOCTYPE html>
<html>
<head>
<v:head title="welkom"/>
</head>
<body>
<v:menu/>
<h1>Welkom in het huis van de belgische bieren</h1>
<img src="${contextPath}/images/bierhuis.jpg"/>
<p>We hebben momenteel ${aantal} bieren.</p>
</body>
</html>