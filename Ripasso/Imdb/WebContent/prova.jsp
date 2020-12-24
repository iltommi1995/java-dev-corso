<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' href='css/style.css'>
<title>Insert title here</title>
</head>
	<body>
		<h1>ciao</h1>
		<ul>
		<c:forEach items="${generi}" var="genere">
			<li>${genere.id}- ${genere.nome}</li>
		</c:forEach>
		</ul>
		<a href="/Imdb/serie">Vai alle serie</a>
	</body>
</html>