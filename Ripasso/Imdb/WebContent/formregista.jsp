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
<title>Insert New Director</title>
</head>
<body>
${nav}
	<div class="container">
		<form action="newdirector" method="get">
			<c:forEach items="${prova}" var="pr">
				<input type="hidden" name=${pr.split("=")[0]} value=${pr.split("=")[1]}>
			</c:forEach>
			Nome: <input type="text" name="nome"/>
			<br>
			Cognome: <input type="text" name="cognome"/>
			<br>
			Data di nascita: <input type="date" name="dobregista"/>
			<br>
			Nazionalità: <input type="text" name="nazionalita"/>
			<br>
			Immagine: <input type="text" name="imgregista"/>
			<br>
			Ha vinto oscar per la regia?: 
			<br>
			<input type="radio" id="oscarTrue" name="oscarregia" value="true">
			<label for="oscarTrue">Vero</label>
			<input type="radio" id="oscarFalse" name="oscarregia" value="false">
			<label for="oscarFalse">Falso</label>
			<br>
			Ha vinto bafta per la regia?: 
			<br>
			<input type="radio" id="baftaTrue" name="baftaregia" value="true">
			<label for="baftaTrue">Vero</label>
			<input type="radio" id="baftaFalse" name="baftaregia" value="false">
			<label for="baftaFalse">Falso</label>
			<br>
			
			<input type="submit" value="Salva">
		</form>
	</div>
</body>
</html>