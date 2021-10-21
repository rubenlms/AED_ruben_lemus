<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="estilos.css">
<title>Foro</title>
</head>
<body>
	<h1>FORO</h1>
	<h3>Introduzca aquí:</h3>
	<div class="caja">
    <form action="escribirMensaje" method="GET"> 
        <label for="nombre">Su nombre:</label>
	    <input type="text" name="nombre" id="nombre"/><br>
        <label for="mensaje">Su mensaje: </label>
	    <input type="text" name="mensaje" id="mensaje"/><br>
	    <br>
	    <input type="submit" value="Enviar" />                            
    </form>
    </div>
    <br>
    <h3>Mensajes:</h3>
    <div class="caja">
    <textarea rows="10" cols="40">
 		<c:forEach items="${mensajes}" var="linea">
			${linea} <br>
		</c:forEach>
	</textarea>
	</div>
</body>
</html>