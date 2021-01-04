<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' href='css/style.css'>
<script src="javascript/script.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
<title>Film</title>
</head>
<body>
	${nav}
	<div class="container">
	<div class="search">
		<form action="film" method="get" id="searchmovie">
			<input type="text" name="titolo" placeholder="cerca" onkeyup="submitForm()" />
			<input type="submit" value="cerca">
		</form>
	</div>
	<div class="newMovie">
		<a href="/Imdb/addfilm">
			<img src="img/icons/addIcon.png" />
		</a>
	</div>
	<c:forEach items="${film}" var="fi">
		<div class="col-3">
			<div class="col-3-img">
				<img src="${fi.imgpath}" />
			</div>
			<h4><a href="/Imdb/films?fi=${fi.id}">${fi.id}- ${fi.titolo}</a></h4>
		</div>
	</c:forEach>
	</div>
</body>
</html>