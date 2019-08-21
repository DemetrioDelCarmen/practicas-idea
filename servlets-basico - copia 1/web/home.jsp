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

    <meta charset="UTF-8">
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>


    <script src="js/fontawesome.js" type="application/javascript" ></script>
    <script src="js/FAall.min.js"  type="application/javascript"></script>


    <link rel="stylesheet" href="css/FAall.min.css">
    <link rel="stylesheet" href="css/fontawesome.css">
    <script src="js/asincrono.js" type="application/javascript"></script>



    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>


<div class="container">
    <div class="row">

        <div class="col-md-3"></div>
        <div class="col-md-6">

            <button type="button" class=" btn btn-primary"
                    id="btn-registrar"
                    data-toggle="modal"
                    data-target="#modalRegistro">Añadir Usuario
            </button>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Imagen</th>
                    <th>Usuario</th>
                    <th>Rol</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td><img src="data:image/jpge;base64, ${usuario.imagen}" width="100%" alt=""></td>
                        <td>${usuario.usuario}</td>
                        <td>${usuario.rol}</td>
                        <td>

                            <button data-id="${usuario.idUsuario}" class="btn btn-sm btn-danger"><i class="fas fa-user-times"></i></button>
                            <button data-id="${usuario.idUsuario}" class="btn btn-sm btn-primary btn-actualizar"
                                    data-toggle="modal"
                                    data-target="#modalRegistro"><i class="fas fa-user-edit"></i></button>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-3"></div>

    </div>


</div>
<!-- Modal -->
<div class="modal fade" id="modalRegistro" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form role="form"  id="formUsuario" action="UsuarioServlet" method="post">
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control m-2" name="usuario" id="usuario">

                    </div>
                    <div class="form-group">
                        <label for="contrasena">Contraseña</label>
                        <input type="password" class="form-control m-2" name="contrasena" id="contrasena">
                    </div>
                    <div class="form-group">
                        <label for="rol">Rol</label>
                        <select name="rol" id="rol" class="custom-select m-2">
                            <c:forEach items="${roles}" var="rol">
                                <option value="${rol.idRol}">${rol.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="hidden" value="" name="id" id="idRegistro"/>
                </form>
            </div>
            <div class="modal-footer">


                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-success btn-registrar">Registrar</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
