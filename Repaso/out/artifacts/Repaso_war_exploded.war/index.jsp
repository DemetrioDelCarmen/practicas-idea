<%--
  Created by IntelliJ IDEA.
  User: Demetrio Del Carmen
  Date: 19/08/2019
  Time: 02:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<div>
    <form role="form" method="POST" action="LibroServlet">

        <div class="form-group">
            <label for="titulo">Título del libro</label>
            <input type="text" class="form-control" name="titulo" id="titulo">
        </div>

        <div class="form-group">
            <label for="editorial">Editorial</label>
            <input type="text" class="form-control" name="editorial" id="editorial">
        </div>

        <div class="form-group">
            <label for="edicion">Edicion</label>
            <input type="text" class="form-control" name="edicion" id="edicion">
        </div>

        <div class="form-group">
            <label for="resumen">Resumen</label>
            <textarea class="form-control"
                      name="resumen"
                      id="resumen"
                      cols="30"
                      rows="10"></textarea>
        </div>

        <div>
            <label for="anio">Año:</label>
            <input class="form-control" type="number" name="anio" id="anio">
        </div>

        <div>

            <input type="reset" value="Limpiar">

        </div>
        <div>

            <input type="submit" value="Enviar">
        </div>
    </form>

</div>

$END$
</body>
</html>
