<%--
  Created by IntelliJ IDEA.
  User: Demetrio Del Carmen
  Date: 21/06/2019
  Time: 05:19 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="js/scripts.js"></script>
  <title>Document</title>
</head>

<body>
<div class="container">
  <div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
      <table class="table table-striped">
        <thead>
        <th>Matricula</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Asignatura</th>
        <th>Calificacion</th>
        <th>Acciones</th>
        </thead>
        <tbody>
         <!--   expression languaje-->
          <c:forEach var="estudiante" items="${estudiantes}">
            <tr>
              <td>${estudiante.matricula}</td>
              <td>${estudiante.nombre}</td>
              <td>${estudiante.apellidos}</td>
              <td>${estudiante.asignatura}</td>
              <td>${estudiante.calificacion}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="col-md-3"></div>
  </div>
  <div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">

      <form method="post" action="EstudianteServlet">
        <div class="form-group">
          <label for="matricula1">Matricula</label>
          <input type="text" class="form-control" id="matricula1" name="matricula" />
        </div>
        <div class="form-group">
          <label for="nombre">Nombre</label>
          <input type="text" class="form-control" id="nombre" name="nombre"/>
        </div>
        <div class="form-group">
          <label for="apellidos">Apellidos</label>
          <input type="text" class="form-control" id="apellidos" name="apellidos"/>
        </div>

        <div class="form-group">
          <label for="asignatura">Asignatura</label>
          <select class="form-control" id="asignatura" name="asignatura">
            <option value="indefinido">Selecciona una opcion</option>
            <option value="Aplicaciones Web">Aplicaciones Web</option>
            <option value="Base de Datos">Base de Datos</option>
            <option value="Sistemas Operativos">Sistemas Operativos</option>
          </select>
        </div>
        <div class="form-group">
          <label for="calificacion">Calificacion</label>
          <input type="text" class="form-control" id="calificacion" name="calificacion"/>
        </div>

        <button type="button" class="btn btn-danger" id="borrar" name="borrar">Borrar</button>
        <button type="submit" class="btn btn-success" id="guardar" name="guardar">Guardar</button>

      </form>
    </div>
    <div class="col-md-3"></div>
  </div>
</div>
</body>

</html>