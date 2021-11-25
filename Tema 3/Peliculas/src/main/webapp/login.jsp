<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/estilos.css" href="css/bootstrapt.min.css">
<meta charset="UTF-8">
<title>Iniciar sesión</title>
</head>
<body>
<div id="login">
    <h3 class="text-center text-white pt-5">LOGIN</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="" method="post">
                        <h3 class="text-center text-info">Introduce tu usuario y contraseña:</h3><br>
                        <div class="form-group">
                            <label for="username" class="text-info">Usuario:</label><br>
                            <input type="text" name="username" id="username" class="form-control">
                            <br>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Contraseña:</label><br>
                            <input type="text" name="password" id="password" class="form-control">
                            <br>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="Validar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  </div>
</body>
</html>