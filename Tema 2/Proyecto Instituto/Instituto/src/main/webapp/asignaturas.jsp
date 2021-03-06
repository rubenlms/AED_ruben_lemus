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

    <title>Asignaturas</title>
  </head>
  <body>
    <div class="container-fluid fondo">
      <div id="titulo" class="container-fluid"><h1>Gestionar instituto</h1></div>
			<div id="seccion" class="container-fluid"><h2>Asignaturas</h2></div>
      <br/>
      <div id="general" class="flex-container">
        <div id="agregar" class="flex-item">
        <h3>Agregar asignatura</h3>
        <form>
          <label for="idAsingturaAgregar">*ID asignatura:</label>
          <input type="text" name="idAsingturaAgregar"></input><br>
					<label for="nombreAgregar">*Nombre asignatura:</label>
          <input type="text" name="nombreAgregar"></input><br>
					<label for="cursoAgregar">*Curso:</label>
          <input type="text" name="cursoAgregar"></input><br>
					<label for="horasAgregar">*Horas semanales:</label>
          <input type="text" name="horasAgregar"></input><br>
          <br>
          <span><button name="agregarButton" class="btn btn-primary" type="submit">Agregar</button></span>
        </form>
      </div>

        <div id="borrar" class="flex-item">
          <h3>Borrar asignatura</h3>
          <form>
						<label for="idAsignaturaBorrar">*ID asignatura:</label>
						<input type="text" name="idAsignaturaBorrar"></input><br>
            <br>
            <button name="borrarButton" class="btn btn-primary" type="submit">Borrar</button>
          </form>
        </div>

        <div id="editar" class="flex-item">
        <h3>Editar asignatura</h3>
        <form>
          <label for="idAsingturaEditar">*ID asignatura:</label>
          <input type="text" name="idAsingturaEditar"></input><br>
					<label for="nombreEditar">*Nombre asignatura:</label>
          <input type="text" name="nombreEditar"></input><br>
					<label for="cursoEditar">*Curso:</label>
          <input type="text" name="cursoEditar"></input><br>
					<label for="horasEditar">*Horas semanales:</label>
          <input type="text" name="horasEditar"></input><br>
          <br>
          <span><button name="editarButton" class="btn btn-primary" type="submit">Editar</button></span>
        </form>
      </div>

      <div id="mostrar" class="flex-item">
        <h3>Mostrar asignatura</h3>
        <label>(Escribir en uno de los campos ??nicamente)</label>
        <form>
					<label for="nombreMostrar">*Nombre:</label>
          <input type="text" name="nombreMostrar"></input><br>
          <label for="idAsignaturaMostrar">*ID asignatura:</label>
          <input type="text" name="idAsignaturaMostrar"></input><br>
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