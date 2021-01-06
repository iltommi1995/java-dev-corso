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
<title>Insert New Film</title>
</head>
<body>
	${nav}
	<div class="container">
		<form action="newfilm" method="get">
			Titolo: <input type="text" name="titolo"/>
			<br>
			Da vedere:
			<br>
			<input type="radio" id="vedereTrue" name="vedere" value="true">
			<label for="vedereTrue">Vero</label>
			<input type="radio" id="vedereFalse" name="vedere" value="false">
			<label for="vedereFalse">Falso</label>
			<br>
			Visto:
			<br>
			<input type="radio" id="vistoTrue" name="visto" value="true">
			<label for="vistoTrue">Vero</label>
			<input type="radio" id="vistoFalse" name="visto" value="false">
			<label for="vistoFalse">Falso</label>
			Percorso locandina: <input type="text" name="imgpath"/>
			Regista: 
			<select name="regista" id="regista">
				<option value="nuovoRegista">Nuovo regista</option>
			    <c:forEach items="${registi}" var="re">
			    	<option value="${re.id}">${re.nome} ${re.cognome}</option>
				</c:forEach>
			</select>
			<br>
			Durata: <input type="number" name="durata"/>
			Data Uscita: <input type="date" name="data"/>
			Oscar: 
			<input type="radio" id="oscarTrue" name="oscar" value="true">
			<label for="oscarTrue">Vero</label>
			<input type="radio" id="oscarFalse" name="oscar" value="false">
			<label for="oscarFalse">Falso</label>
			<br>
			Generi:
			<br>
			<c:forEach items="${generi}" var="gen">
				<input type="checkbox" id="genre${gen.id}" name="genere" value="${gen.id}">
	  			<label for="genre${gen.id}"> ${gen.nome}</label>
	  			<br>
			</c:forEach>
			
			
			<input type="submit" value="Salva">
		</form>
	</div>
</body>
</html>