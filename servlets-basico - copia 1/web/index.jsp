<%--
  Created by IntelliJ IDEA.
  User: Demetrio Del Carmen
  Date: 27/06/2019
  Time: 02:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Inicio de Sesión</title>
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col col-md-3"></div>
        <div class="col col-md-6">

            <form role="form" action="UsuarioServlet" method="post">
                <div class="form-group">
                    <label for="usuario">Usuario</label>
                    <input type="text" class="form-control m-2" name="usuario" id="usuario">

                </div>
                <div class="form-group">
                    <label for="contrasena">Contraseña</label>
                    <input type="password" class="form-control m-2" name="contrasena" id="contrasena">
                </div>
                <a href="UsuarioServlet?action=verAsesorias"> Ver Hola</a>
                <input type="hidden" value="login" name="accion">
                <input type="submit" class="btn btn-primary" value="Iniciar">
            </form>

        </div>
        <div class="col col-md-3"></div>
    </div>
</div>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">${error}</div>
    <div class="col-md-3"></div>
</div>

</body>
</html>
