<%--
  Created by IntelliJ IDEA.
  User: Demetrio Del Carmen
  Date: 08/07/2019
  Time: 02:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Bienvenido <%=request.getAttribute("nombre") == null ? "":
        request.getAttribute("nombre")%></h1>

</body>
</html>
