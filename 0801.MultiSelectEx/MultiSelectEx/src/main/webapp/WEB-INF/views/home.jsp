<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr />
<c:forEach var="vo" items="${list2 }">
	${vo } <br />
</c:forEach>
<hr />
<c:forEach var="vo" items="${list3 }">
	${vo } <br />
</c:forEach>
</body>
</html>
