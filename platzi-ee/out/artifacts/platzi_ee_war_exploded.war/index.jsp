<%--
  Created by IntelliJ IDEA.
  User: Demetrio Del Carmen
  Date: 07/07/2019
  Time: 02:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hola mundo</title>
</head>
<body>
        <h1>Hola mundo desde Java EE by Platzi</h1>
        <form action="InicioSesionServlet" method="post">
            <div>
                <label for="usuario">Usuario</label>
                <input type="text" name="usuario" id="usuario">
            </div>
            <div>

                <label for="contrasena">Contraseña</label>
                <input type="password" name="contrasena" id="contrasena">


            </div>

            <div>
                <input type="submit" value="Iniciar Sesion">
            </div>

        </form>
</body>
</html>
