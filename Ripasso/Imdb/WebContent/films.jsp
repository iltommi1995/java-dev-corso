<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Films</title>
</head>
<body>
	<c:forEach items="${film}" var="fi">
		<p>${fi.id}- ${fi.titolo}</p>
	</c:forEach>
</body>
</html>