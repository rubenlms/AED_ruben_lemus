<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/vista.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Alumnos</title>
  </head>
  <body>
    <div class="container-fluid fondo">
      <div id="titulo" class="container-fluid"><h1>Gestionar instituto</h1></div>
			<div id="seccion" class="container-fluid"><h2>Alumnos</h2></div>
      <br/>
      <div id="general" class="flex-container">
        <div id="agregar" class="flex-item">
        <h3>Agregar alumno</h3>
        
        <form action="agregaralumno" method="POST">
					<label for="nombreAgregar">*Nombre:</label>
          <input type="text" name="nombreAgregar"></input><br>
					<label for="apellidosAgregar">*Apellidos:</label>
          <input type="text" name="apellidosAgregar"></input><br>
					<label for="nacimientoAgregar">*Nacimiento:</label>
          <input type="text" name="nacimientoAgregar"></input><br>
          <label for="dniAgregar">*DNI:</label>
          <input type="text" name="dniAgregar"></input><br>
          <br>
          <span><button name="agregarButton" class="btn btn-primary" type="submit">Agregar</button></span>
        </form>
      </div>

        <div id="borrar" class="flex-item">
          <h3>Borrar alumno</h3>
          
          <form action="borraralumno" method="POST">
						<label for="dniBorrar">*DNI:</label>
						<input type="text" name="dniBorrar"></input><br>
            <br>
            <button name="borrarButton" class="btn btn-primary" type="submit">Borrar</button>
          </form>
        </div>

        <div id="editar" class="flex-item">
        <h3>Editar alumno</h3>
        
        <form action="editaralumno" method="POST">
          <label for="nombreEditar">*Nombre:</label>
          <input type="text" name="nombreEditar"></input><br>
					<label for="apellidosEditar">*Apellidos:</label>
          <input type="text" name="apellidosEditar"></input><br>
					<label for="nacimientoEditar">*Nacimiento:</label>
          <input type="text" name="nacimientoEditar"></input><br>
          <label for="dniEditar">*DNI:</label>
          <input type="text" name="dniEditar"></input><br>
          <br>
          <button name="editarButton" class="btn btn-primary" type="submit">Editar</button>
        </form>
      </div>

      <div id="mostrar" class="flex-item">
        <h3>Mostrar alumno</h3>
        <label>(Escribir en uno de los campos ??nicamente)</label>
        
        <form action="mostraralumno" method="POST">
					<label for="nombreMostrar">*Nombre:</label>
          <input type="text" name="nombreMostrar"></input><br>
          <label for="dniMostrar">*DNI:</label>
          <input type="text" name="dniMostrar"></input><br>
          <br>
          <button name="mostrarButton" class="btn btn-primary" type="submit">Mostrar</button>
        </form>
      </div>
      <h6>Nota:los campos marcados con asterisco son obligatorios.</h6>
    </div>
    <textarea id="" name="mostrarTextArea" rows="17" cols="100" readonly>
      Aqu?? se mostrar?? la consulta.
      </textarea>
  </div>
  <div>
    <a href="#" class="btn btn-secondary btn-lg" role="button">Volver</a>
  </div>

  </body>
</html>