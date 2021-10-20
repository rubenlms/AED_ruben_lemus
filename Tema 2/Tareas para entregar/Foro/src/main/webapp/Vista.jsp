<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foro</title>
</head>
<body>
	<h1>FORO</h1>
	<h3>Introduzca aquí:</h3>
    <form action="escribirMensaje" method="GET"> 
        <label for="nombre">Escriba su nombre:</label>
	    <input type="text" name="nombre" id="nombre"/><br>
        <label for="mensaje">Escriba su mensaje: </label>
	    <input type="text" name="mensaje" id="mensaje"/><br>
	    <br>
	    <input type="submit" value="Enviar" />                            
    </form>
    <br>
    <h3>Mensajes:</h3>
    <textarea rows="4" cols="20">
 		<c:forEach items="${mensajes}" var="linea">
			${linea} <br>
		</c:forEach>
	</textarea>
</body>
</html>