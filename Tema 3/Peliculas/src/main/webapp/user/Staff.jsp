<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zona de Staff</title>
</head>
<body>
	<h2>Estás en la parte de staff</h2>
	<h3>Selecciona tu nombre:</h3>
	<ul>
	<c:forEach items="${listastaff}" var="staff">
		<li>
		<a href="staff?staff_id=${staff.getStaffId()}">
		${staff.getFirstName()} ${staff.getLastName()}</a>
		</li>
	</c:forEach>
	</ul>
</body>
</html>