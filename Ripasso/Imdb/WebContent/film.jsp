<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' href='css/style.css'>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
<title>Film</title>
</head>
<body>
	${nav}
	<div class="container">
	<c:forEach items="${film}" var="fi">
		<div class="col-3">
			<p>${fi.id}</p>
			<p>${fi.titolo}</p>
			<p>${fi.durata}'</p>
		</div>
	</c:forEach>
	</div>
</body>
</html>