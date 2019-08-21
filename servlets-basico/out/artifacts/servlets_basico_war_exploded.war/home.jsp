<%--
  Created by IntelliJ IDEA.
  User: Demetrio Del Carmen
  Date: 08/07/2019
  Time: 02:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>

    <script src="js/ajax.js" type="application/javascript"></script>
    <script src="js/asincrono.js" type="application/javascript"></script>


    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

            <table class="table table-dark">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Rol</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                            <c:forEach items="${usuarios}" var="usuario">
                                    <tr>
                                        <td>${usuario.usuario}</td>
                                        <td>${usuario.rol}</td>
                                        <td>

                                            <button data-id="${usuario.idUsuario}" class="btn btn-sm btn-danger">Eliminar</button>
                                            <button data-id="${usuario.idUsuario}" class="btn btn-sm btn-primary">Actualizar</button>
                                        </td>
                                    </tr>

                            </c:forEach>
                </tbody>
            </table>


</body>
</html>
