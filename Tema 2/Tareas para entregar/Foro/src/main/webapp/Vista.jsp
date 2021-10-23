<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilos.css">
<title>Foro</title>
</head>
<body>
	<h1>FORO</h1>

<div class="foro">

	<div class="datos">
    <form action="principal" method="GET">
      <label for="nombre">Nombre:</label><br>
	    <input type="text" name="nombre" id="nombre"/><br>
	    <textarea name="mensaje" id="mensaje" cols="40" rows="7"></textarea><br>
	    <input type="submit" value="Enviar" />
    </form>
    </div>
    <br>

    <div class="publicaciones">
    <textarea rows="20" cols="100">
 		<c:forEach items="${mensajes}" var="linea">
			${linea} <br>
		</c:forEach>
	</textarea>
	</div>
  
</div>
</body>
</html>