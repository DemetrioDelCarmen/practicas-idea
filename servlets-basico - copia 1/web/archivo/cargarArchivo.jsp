<%--
  Created by IntelliJ IDEA.
  User: Demetrio Del Carmen
  Date: 06/08/2019
  Time: 03:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cargar archivo</title>

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

            <form action="ArchivoServlet" method="POST" role="form">

                <input  class="form-control m-2" type="text" name="id">
                <input  class="btn btn-info m-2" type="submit" value="Descargar">
                <input  type="hidden" name="accion" value="descargar">


            </form>
            <form action="ArchivoServlet" method="POST" role="form" enctype="multipart/form-data">
                <input  class="btn btn-light" type="file" name="archivo" id="archivo">
                <input  type="submit" class="btn btn-dark m-2" value="Cargar">
                <input  type="hidden" name="accion" value="cargar">
            </form>

</body>
</html>
