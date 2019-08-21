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
    <title>Registro</title>
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <script src="js/validaciones.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>


<div class="container">
    <div class="row">
        <div class="col col-md-3"></div>
        <div class="col col-md-6">



                <!-- Button trigger modal -->
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal">
                    Launch demo modal
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form role="form" action="UsuarioServlet" method="post">
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


                                    <input type="hidden" value="registrar" name="accion">
                                    <input type="submit" class="btn btn-primary" value="Registrar">


                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                <input type="hidden" value="registrar" name="accion">
                                <input type="submit" class="btn btn-primary" value="Registrar" data-dismiss="modal">

                            </div>
                        </div>
                    </div>
                </div>




                <div class="pt-4">
                    <button type="button" class=" btn btn-info" id="saludar">SALUDAR A DULCE</button>

                    <div id="areaDeSaludo"></div>
                </div>









        </div>
        <div class="col col-md-3"></div>
    </div>
</div>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">${mensaje}</div>
    <div class="col-md-3"></div>
</div>

</body>
</html>

